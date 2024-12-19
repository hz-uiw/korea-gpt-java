package test;

// 1번 문제
// -
/*
    변수를 선언할 때 사용하는 기본 데이터 타입
    종류) int: 정수, char: 문자, double: 실수 등이 있음
    예) int a = 1;
 */


// -
/*
    고유한 주소값을 가지는 변수명
    종류) String: 문자열 등이 있음
    예) String name = "권민창";
 */

// 6번 문제
// : 오브젝트

// 7번 문제
// : get()

// 8번 문제
// : ==, !=

// 9번 문제
// : 4

// 10번 문제
// : 2

// 11번 문제
// : Parent

// 12번 문제
// : public static

// 13번 문제
// : 2

// 14번 문제
// :

// 15번 문제
// : 2

// 16번 문제
// : 3

// 17번 문제
// : public

// 18번 문제
// : 4

// 19번
// :



// 20번
// :


import java.util.Scanner;


class Student {
    private String name;
    private int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
}
public class Test {
    public static void main(String[] args) {
        // 2번 문제
        int num1 = 10; double num2 = 3.5;
        double result = (double) num1 + num2;
        System.out.println(result);

        // 3번 문제
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 하나 입력 >>> ");
        int num = scanner.nextInt();

        if(num%2==0) System.out.println("입력하신 숫자는 짝수입니다.");
        else System.out.println("입력하신 숫자는 홀수입니다.");


        // 4번 문제
        int[] numbers = {1, 2, 3, 4, 5};

        for(int number : numbers) System.out.println(number);

        // 5번 문제
        // : class Test 바로 위에 클래스를 작성하고 main 메서드 내부에서 객체를 생성하세요.

        Student[] students = {
                new Student("학생1", 85),
                new Student("학생2", 95),
                new Student("학생3", 60),
                new Student("학생4", 70),
                new Student("학생5", 90)
        };

        for(Student student : students) {
            if(student.getScore() >= 90) System.out.println(student.getName());
        }

    }
}
