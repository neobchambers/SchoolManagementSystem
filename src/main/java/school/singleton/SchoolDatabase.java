package school.singleton;

import school.model.Staff;
import school.model.Student;
import school.model.User;
import school.observer.GradeNotification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchoolDatabase {

    private static final SchoolDatabase instance =
            new SchoolDatabase();

    private final Map<String, Student> students =
            new LinkedHashMap<>();

    private final Map<String, Staff> staffMembers =
            new LinkedHashMap<>();

    private final Map<String, GradeNotification> notifications =
            new LinkedHashMap<>();

    private SchoolDatabase() {
    }

    public static SchoolDatabase getInstance() {
        return instance;
    }

    public void addStudent(Student student) {

        if (students.containsKey(student.getId())
                || staffMembers.containsKey(student.getId())) {
            throw new IllegalArgumentException(
                    "A profile with this ID already exists."
            );
        }

        students.put(student.getId(), student);

        GradeNotification notification =
                new GradeNotification();

        notification.attach(student);

        notifications.put(student.getId(), notification);
    }

    public void addStaff(Staff staff) {

        if (students.containsKey(staff.getId())
                || staffMembers.containsKey(staff.getId())) {
            throw new IllegalArgumentException(
                    "A profile with this ID already exists."
            );
        }

        staffMembers.put(staff.getId(), staff);
    }

    public Student getStudent(String id) {
        return students.get(id);
    }

    public Staff getStaff(String id) {
        return staffMembers.get(id);
    }

    public GradeNotification getNotification(String studentId) {
        return notifications.get(studentId);
    }

    public Collection<User> getAllUsers() {

        ArrayList<User> users = new ArrayList<>();

        users.addAll(students.values());
        users.addAll(staffMembers.values());

        return users;
    }
}