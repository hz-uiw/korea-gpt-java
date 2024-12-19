package chapter02;

// 제어문: 조건문(Condition), 반복문(Loop)

// 조건문: 프록그램의 흐름을 제어하는데 사용

// 조건문 종류
// 1. if, else, else if
// 2. switch, case, default
// +) continue, break

import java.util.Scanner;

public class A_If {
    public static void main(String[] args) {
        // 1. if문 / else문

        /*
            if (조건식) {
                조건이 참일 때 실행할 코드
            } else {
                조건이 거짓일 때 실행할 코드
            }
         */

        int age = 14;

        if (age > 19) {
            System.out.println("성인입니다.");
        } else if(age > 13) {
            System.out.println("청소년입니다.");
        } else{
            System.out.println("미성년자입니다.");
        }

        // cf) 실행될 코드 블럭에 코드가 하나의 구문이라면 {} 생략 가능
        if (age > 19) System.out.println("주류");
        else if(age > 13) System.out.println("탄산");
        else System.out.println("쥬스");

        /*
            조건문 예제 - 함수 위치 구하기
            1. 스캐너를 사용하여 x, y 변수에 데이터 저장
            2. (x, y) 좌표가 1, 2, 3, 4 사분기 중 어느 위치에 있는지 검사

            각 분기의 위치일 경우 functionScope 변수에 몇 사분면인지 할당
         */

        String functionScope;
        int x, y;

        Scanner scanner = new Scanner(System.in);

        System.out.print("x값 입력 >>> ");
        x = scanner.nextInt();
        System.out.print("y값 입력 >>> ");
        y = scanner.nextInt();

        if (x > 0 && y > 0) functionScope = "제 1사분면";
        else if (x < 0 && y > 0) functionScope = "제 2사분면";
        else if (x < 0 && y < 0) functionScope = "제 3사분면";
        else functionScope = "제 4사분면";

        System.out.println("결과: " + functionScope);


//        scanner.close();
    }
}