package school;

import school.decorator.BasicAccess;
import school.decorator.GradeEditor;
import school.decorator.ReportViewer;
import school.decorator.UserAccess;
import school.facade.SchoolManagementFacade;
import school.model.Staff;
import school.model.Student;
import school.model.User;
import school.strategy.AverageGrade;
import school.strategy.GradeStrategy;
import school.strategy.WeightedGrade;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SchoolManagementFacade school =
                new SchoolManagementFacade();

        UserAccess basicAccess = new BasicAccess();

        UserAccess teacherAccess =
                new GradeEditor(
                        new ReportViewer(new BasicAccess())
                );

        System.out.println("================================");
        System.out.println("     SCHOOL MANAGEMENT SYSTEM");
        System.out.println("================================");

        System.out.println(
                "Current access: " +
                        teacherAccess.getDescription()
        );

        boolean running = true;

        while (running) {

            System.out.println("\n1. Create student");
            System.out.println("2. Create staff member");
            System.out.println("3. Add grade");
            System.out.println("4. Show all profiles");
            System.out.println("5. Show student report");
            System.out.println("6. Change grade calculation strategy");
            System.out.println("7. Show access permissions");
            System.out.println("0. Exit");

            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            try {

                switch (choice) {

                    case "1" -> {

                        System.out.print("Student ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Student name: ");
                        String name = scanner.nextLine();

                        System.out.print("Grade level: ");
                        String level = scanner.nextLine();

                        Student student =
                                school.createStudent(id, name, level);

                        System.out.println(
                                "Student created: " +
                                        student.getName()
                        );
                    }

                    case "2" -> {

                        System.out.print("Staff ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Staff name: ");
                        String name = scanner.nextLine();

                        System.out.print(
                                "Position (Teacher/Administrator): "
                        );

                        String position = scanner.nextLine();

                        Staff staff =
                                school.createStaff(id, name, position);

                        System.out.println(
                                "Staff member created: " +
                                        staff.getName()
                        );
                    }

                    case "3" -> {

                        System.out.print("Teacher ID: ");
                        String teacherId = scanner.nextLine();

                        System.out.print("Student ID: ");
                        String studentId = scanner.nextLine();

                        double score = readDouble(
                                scanner, "Score (0-100): "
                        );

                        double weight = readDouble(
                                scanner,
                                "Weight (for weighted average): "
                        );

                        school.addGrade(
                                teacherAccess,
                                teacherId,
                                studentId,
                                score,
                                weight
                        );
                    }

                    case "4" -> {

                        List<User> users = school.getAllUsers();

                        if (users.isEmpty()) {
                            System.out.println("No profiles found.");
                        } else {

                            for (User user : users) {

                                System.out.println(
                                        "\n--------------------"
                                );

                                user.displayInfo();
                            }
                        }
                    }

                    case "5" -> {

                        System.out.print("Student ID: ");
                        String studentId = scanner.nextLine();

                        System.out.println(
                                school.generateReport(
                                        teacherAccess,
                                        studentId
                                )
                        );
                    }

                    case "6" -> {

                        System.out.println("1. Average");
                        System.out.println("2. Weighted average");

                        System.out.print("Choose strategy: ");

                        String strategyChoice = scanner.nextLine();

                        GradeStrategy strategy;

                        if (strategyChoice.equals("1")) {

                            strategy = new AverageGrade();

                        } else if (strategyChoice.equals("2")) {

                            strategy = new WeightedGrade();

                        } else {

                            System.out.println("Unknown strategy.");
                            break;
                        }

                        school.setGradeStrategy(strategy);

                        System.out.println(
                                "Strategy changed to: " +
                                        strategy.getName()
                        );
                    }

                    case "7" -> {

                        System.out.println(
                                "Basic access: " +
                                        basicAccess.getDescription()
                        );

                        System.out.println(
                                "Can edit grades: " +
                                        basicAccess.canEditGrades()
                        );

                        System.out.println(
                                "Can view reports: " +
                                        basicAccess.canViewReports()
                        );

                        System.out.println();

                        System.out.println(
                                "Decorated teacher access: " +
                                        teacherAccess.getDescription()
                        );

                        System.out.println(
                                "Can edit grades: " +
                                        teacherAccess.canEditGrades()
                        );

                        System.out.println(
                                "Can view reports: " +
                                        teacherAccess.canViewReports()
                        );
                    }

                    case "0" -> {

                        running = false;

                        System.out.println("Goodbye!");
                    }

                    default -> System.out.println(
                            "Please choose a valid menu option."
                    );
                }

            } catch (
                    IllegalArgumentException |
                    IllegalStateException e
            ) {

                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static double readDouble(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a number."
                );
            }
        }
    }
}