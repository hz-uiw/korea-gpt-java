package chapter12.controller;

import chapter12.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String studentId) {
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("해당 ID의 학생이 이미 존재합니다.");
            return;
        }

        students.add(new Student(name, age , studentId));

    }

    // 전체 조회
    public List<Student> getAllStudents() {
        return students;
    }

    // 단건 조회
    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if(student.getStudentId().equals(studentId)) {
                return student; // 해당 학번의 학생을 반환
            }
        }
        return null; // 학번에 해당하는 학생이 없을 경우 null 반환
    }

    public boolean updateStudent(String studentId, String newName, int newAge) {
        Student student = findStudentById(studentId);
        if(student != null) {
            student.setName(newName);
            student.setAge(newAge);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String studentId) {
//        for (Student student : students) {
//            if (student.getStudentId().equals(studentId)) {
//                students.remove(student);
//                return true;
//            }
//        }
//        return false;
        Student student = findStudentById(studentId);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
