package chapter14;

// 컬렉션 프레임워크 & 스트림 API & 람다 표현식 & 메서드 참조

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 1. 학생 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade;
}

public class H_Practice {
    public static void main(String[] args) {
        // 1. 학생 목록 필터링 & 정렬
        List<StudentClass> studentClasses = Arrays.asList(
                new StudentClass("권민창", 25, 4.3),
                new StudentClass("정현영", 28, 4.5),
                new StudentClass("김민성", 25, 0.0),
                new StudentClass("백가민", 25, 3.8)
        );

        // 1-1 학점이 4.0 이상인 학생 필터링
        List<StudentClass> filteredStudents = studentClasses.stream()
                .filter(student -> student.getGrade() >= 4.0)
                .collect(Collectors.toList());
        System.out.println("학점 4.0 이상인 학생");
        filteredStudents.forEach(System.out::println);
//        학점 4.0 이상인 학생
//        StudentClass(name=권민창, age=25, grade=4.3)
//        StudentClass(name=정현영, age=28, grade=4.5)

        // 1-2 학생 이름 목록
        List<String> studentNames = studentClasses.stream()
//                .map(studentClass -> studentClass.getName())
                .map(StudentClass::getName)
                .collect(Collectors.toList());
        System.out.println("학생 이름 목록");
        System.out.println(studentNames); // [권민창, 정현영, 김민성, 백가민]

        // 1-3 학생들을 점수순으로 정렬
        List<StudentClass> sortedStudents = studentClasses.stream()
                // 컬렉션 프레임워크의 중간연산 : .sorted(정렬)
                // Comparator클래스의 .comparatorDouble 정적 메서드 활용
                // : 실수값들에 대한 비교
                // StudentClass::getGrade
                .sorted(Comparator.comparingDouble(StudentClass::getGrade))
//                .sorted(Comparator.comparingDouble(StudentClass::getGrade).reversed())
                .collect(Collectors.toList());
        System.out.println("\n점수 순으로 정렬된 학생들");
        sortedStudents.forEach(System.out::println);
//        StudentClass(name=김민성, age=25, grade=0.0)
//        StudentClass(name=백가민, age=25, grade=3.8)
//        StudentClass(name=권민창, age=25, grade=4.3)
//        StudentClass(name=정현영, age=28, grade=4.5)

        // 1-4 학생들 중 '민' 단어가 이름에 포함된 학생 필터링
        List<StudentClass> studentsWithMin = studentClasses.stream()
                .filter(studentClass -> studentClass.getName().contains("민"))
                .collect(Collectors.toList());
        System.out.println("\n이름에 '민'이 포함된 학생");
        studentsWithMin.forEach(System.out::println);
//        StudentClass(name=권민창, age=25, grade=4.3)
//        StudentClass(name=김민성, age=25, grade=0.0)
//        StudentClass(name=백가민, age=25, grade=3.8)

    }
}
