package school.facade;

import school.decorator.UserAccess;
import school.factory.ProfileFactory;
import school.factory.StaffFactory;
import school.factory.StudentFactory;
import school.model.Grade;
import school.model.Staff;
import school.model.Student;
import school.model.User;
import school.observer.GradeNotification;
import school.singleton.SchoolDatabase;
import school.strategy.AverageGrade;
import school.strategy.GradeStrategy;

import java.util.ArrayList;
import java.util.List;

public class SchoolManagementFacade {

    private final SchoolDatabase database;
    private GradeStrategy gradeStrategy;

    public SchoolManagementFacade() {
        database = SchoolDatabase.getInstance();
        gradeStrategy = new AverageGrade();
    }

    public Student createStudent(
            String id,
            String name,
            String gradeLevel
    ) {
        ProfileFactory factory = new StudentFactory();

        Student student = (Student) factory.createProfile(
                id, name, gradeLevel
        );

        database.addStudent(student);

        return student;
    }

    public Staff createStaff(
            String id,
            String name,
            String position
    ) {
        ProfileFactory factory = new StaffFactory();

        Staff staff = (Staff) factory.createProfile(
                id, name, position
        );

        database.addStaff(staff);

        return staff;
    }

    public void addGrade(
            UserAccess access,
            String teacherId,
            String studentId,
            double score,
            double weight
    ) {
        if (!access.canEditGrades()) {
            throw new IllegalStateException(
                    "You do not have permission to edit grades."
            );
        }

        Staff teacher = database.getStaff(teacherId);

        if (teacher == null) {
            throw new IllegalArgumentException(
                    "Teacher/staff profile was not found."
            );
        }

        Student student = database.getStudent(studentId);

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student was not found."
            );
        }

        Grade grade = new Grade(studentId, score, weight);

        student.addGrade(grade);

        GradeNotification notification =
                database.getNotification(studentId);

        notification.notifyObservers(
                "A new grade was added: " + score
                        + " by " + teacher.getName()
        );
    }

    public String generateReport(
            UserAccess access,
            String studentId
    ) {
        if (!access.canViewReports()) {
            throw new IllegalStateException(
                    "You do not have permission to view reports."
            );
        }

        Student student = database.getStudent(studentId);

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student was not found."
            );
        }

        List<Grade> grades = student.getGrades();

        double result = gradeStrategy.calculate(grades);

        StringBuilder report = new StringBuilder();

        report.append("\n===== STUDENT REPORT =====\n");
        report.append("Student: ")
                .append(student.getName()).append("\n");

        report.append("Student ID: ")
                .append(student.getId()).append("\n");

        report.append("Grade level: ")
                .append(student.getGradeLevel()).append("\n");

        report.append("Calculation: ")
                .append(gradeStrategy.getName()).append("\n");

        report.append("Grades: ");

        if (grades.isEmpty()) {
            report.append("No grades yet");
        } else {
            for (Grade grade : grades) {
                report.append(grade.getScore()).append(" ");
            }
        }

        report.append("\nFinal result: ");

        if (grades.isEmpty()) {
            report.append("No result yet");
        } else {
            report.append(String.format("%.2f", result));
        }

        report.append("\n==========================");

        return report.toString();
    }

    public void setGradeStrategy(GradeStrategy gradeStrategy) {

        if (gradeStrategy == null) {
            throw new IllegalArgumentException(
                    "Grade strategy cannot be null."
            );
        }

        this.gradeStrategy = gradeStrategy;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(database.getAllUsers());
    }
}