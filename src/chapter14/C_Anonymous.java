package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Student {
    private String name;
    private int score;
}

// 인터페이스 - 성적 계산
interface Grading {
    String calculateGrade(Student student);
}

public class C_Anonymous {
    public static void main(String[] args) {
        Student student1 = new Student("권민창", 90);
        Student student2 = new Student("정현영", 100);
        Student student3 = new Student("김민성", 0);
        Student student4 = new Student("백가민", 60);
        Student student5 = new Student("문성호", 95);

        Grading grading = new Grading() {
            @Override
            public String calculateGrade(Student student) {
                int score = student.getScore();

                if(score > 100 || score < 0) {
                    System.out.println("잘못된 점수입니다.");
                    return null;
                } else if (score >= 90) {
                    return "A";
                } else if (score >= 80) {
                    return "B";
                } else if (score >= 70) {
                    return "C";
                } else if (score >= 60) {
                    return "D";
                } else {
                    return "F";
                }
            }
        };
        System.out.println(student1.getName() + "의 성적: " + grading.calculateGrade(student1));
        System.out.println(student2.getName() + "의 성적: " + grading.calculateGrade(student2));
        System.out.println(student3.getName() + "의 성적: " + grading.calculateGrade(student3));
        System.out.println(student4.getName() + "의 성적: " + grading.calculateGrade(student4));
        System.out.println(student5.getName() + "의 성적: " + grading.calculateGrade(student5));
    }
}
