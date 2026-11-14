package school.model;

import school.observer.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends User implements Observer {

    private final String gradeLevel;
    private final List<Grade> grades = new ArrayList<>();

    public Student(String id, String name, String gradeLevel) {
        super(id, name);

        if (gradeLevel == null || gradeLevel.isBlank()) {
            throw new IllegalArgumentException(
                    "Grade level cannot be empty."
            );
        }

        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public void update(String message) {
        System.out.println(
                "\n[NOTIFICATION for " + getName() + "] " + message
        );
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade level: " + gradeLevel);
    }
}
