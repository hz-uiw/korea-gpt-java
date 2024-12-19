package chapter12.view;

import chapter12.controller.StudentController;
import chapter12.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private final Scanner scanner;
    private final StudentController controller;

    public StudentView() {
        this.scanner = new Scanner(System.in);
        this.controller = new StudentController();
    }

    public void showMenu() {
        while (true) {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add a student");
            System.out.println("2. Show All Students");
            System.out.println("3. Find a Student");
            System.out.println("4. Update a Student");
            System.out.println("5. Delete a Student");
            System.out.println("6. Quit");
            System.out.print("Choose an Option >>> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentView();
                    break;
                case 2:
                    showAllStudentsView();
                    break;
                case 3:
                    findStudentView();
                    break;
                case 4:
                    updateStudentView();
                    break;
                case 5:
                    removeStudentView();
                    break;
                case 6:
                    System.out.println("===== Process Exit =====");
                    return;
            }
        }
    }

    private void addStudentView() {
        System.out.print("Enter Student Name >>> ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age >>> ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student StudentID >>> ");
        String studentId = scanner.nextLine();

        controller.addStudent(name, age, studentId);
        System.out.println("Student added successfully");
    }

    private void showAllStudentsView() {
        List<Student> students = controller.getAllStudents();

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    private void findStudentView() {
        System.out.print("Enter Student ID to Find >>> ");
        String id = scanner.nextLine();
        Student student = controller.findStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    private void updateStudentView() {
        System.out.print("Enter Student StudentID to Update >>> ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Student new Name >>> ");
        String newName = scanner.nextLine();

        System.out.print("Enter Student new Age >>> ");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        if (controller.updateStudent(studentId, newName, newAge)) {
            System.out.println("Student Updated Successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    private void removeStudentView() {
        System.out.print("Enter Student Id to remove >>> ");
        String studentId = scanner.nextLine();

        if (controller.removeStudent(studentId)) {
            System.out.println("Student removed Successfully");
        } else {
            System.out.println("Student not found");
        }
    }

}
