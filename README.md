# School Management System

## Project Description

The School Management System is a console-based Java application developed as a final project for demonstrating software design patterns.

The application provides basic school management functionality, including student profile creation, staff profile creation, grade management, notifications, and academic reports.

The project is developed using Java 25 and object-oriented programming principles.

## Technologies

- Java 25
- Maven
- IntelliJ IDEA
- Object-Oriented Programming
- UML
- Design Patterns

## Design Patterns Used

This project implements six design patterns:

### 1. Factory Method
Used to create different types of user profiles, including students and staff members.

Classes:
- ProfileFactory
- StudentFactory
- StaffFactory

### 2. Observer
Used to notify students when new grades are added.

Classes:
- Observer
- Subject
- GradeNotification
- Student

### 3. Decorator
Used to extend user permissions dynamically.

Classes:
- UserAccess
- BasicAccess
- AccessDecorator
- GradeEditor
- ReportViewer

### 4. Strategy
Used to provide different grade calculation methods.

Classes:
- GradeStrategy
- AverageGrade
- WeightedGrade

### 5. Singleton
Used to provide one shared instance of the school database.

Class:
- SchoolDatabase

### 6. Facade
Used to simplify communication between the main application and system components.

Class:
- SchoolManagementFacade

## Main Features

- Create student profiles
- Create staff profiles
- Add grades to students
- Display all registered profiles
- Generate student academic reports
- Calculate average grades
- Change grade calculation strategies
- Send grade notifications
- Demonstrate user access permissions

## Project Structure

```text
SchoolManagementSystem
│
├── pom.xml
│
└── src/main/java/school/
    ├── Main.java
    │
    ├── model/
    │   ├── User.java
    │   ├── Student.java
    │   ├── Staff.java
    │   └── Grade.java
    │
    ├── factory/
    │   ├── ProfileFactory.java
    │   ├── StudentFactory.java
    │   └── StaffFactory.java
    │
    ├── observer/
    │   ├── Observer.java
    │   ├── Subject.java
    │   └── GradeNotification.java
    │
    ├── decorator/
    │   ├── UserAccess.java
    │   ├── BasicAccess.java
    │   ├── AccessDecorator.java
    │   ├── GradeEditor.java
    │   └── ReportViewer.java
    │
    ├── strategy/
    │   ├── GradeStrategy.java
    │   ├── AverageGrade.java
    │   └── WeightedGrade.java
    │
    ├── singleton/
    │   └── SchoolDatabase.java
    │
    └── facade/
        └── SchoolManagementFacade.java
```

## Requirements

To run this project, you need:

- Java JDK 25
- Maven
- IntelliJ IDEA or another Java IDE

## How to Run

1. Clone or download the project.
2. Open the project in IntelliJ IDEA.
3. Make sure JDK 25 is configured.
4. Wait for Maven dependencies and project configuration to load.
5. Open `Main.java`.
6. Run the `Main` class.

## Application Menu

The application provides the following console menu:

```text
1. Create student
2. Create staff member
3. Add grade
4. Show all profiles
5. Show student report
6. Change grade calculation strategy
7. Show access permissions
0. Exit
```

## Example Usage

A typical application workflow:

1. Create a student profile.
2. Create a staff member.
3. Add a grade to the student.
4. Receive a grade notification.
5. Generate a student report.
6. Change the grade calculation strategy.
7. Display available access permissions.

## Team Members

| Student   | Responsibilities |
|-----------|---|
| Yerkezhan | Factory Method, Decorator, Singleton |
| Nazym     | Observer, Strategy, Facade |

## Limitations

- Data is stored in memory.
- Data is not saved after the application closes.
- The application uses a console interface.
- Full authentication is not implemented.
- The database is not connected to an external DBMS.

Developed by: Kulchikova Nazym and Imanova Yerkezhan