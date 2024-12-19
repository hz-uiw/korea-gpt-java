package chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {
        /*
            1. 점수에 따른 학점 출력

            사용자로부터 점수를 입력받아 아래 기준에 따라 학점 출력
            0미만 또는 100초과인 경우: 유효하지 않은 점수
            90이상 A
            80이상 B
            70이상 C
            60이상 D
            F

            2. 삼각형 모양의 별(*) 출력
            *
            **
            ***
            ****
            *****
                *
               **
              ***
             ****
            *****
         */

        Scanner scanner = new Scanner(System.in);

        char grade;

        System.out.print("점수 입력 >>> ");
        int score = scanner.nextInt();


        if (score < 0 || score > 100) System.out.println("유효하지 않은 점수입니다.");
        else if(score >= 90) System.out.println("학점 A");
        else if(score >= 80) System.out.println("학점 B");
        else if(score >= 70) System.out.println("학점 C");
        else if(score >= 60) System.out.println("학점 D");
        else System.out.println("학점 F");


        int i, j, k;

        for(i = 1; i < 6; i++) {
            for(j=1; j <= i; j++) {
                System.out.print("*");
            }
            for(k=1; k < 6; k++) {
                System.out.print(" ");
            }
            System.out.println("");
        }

        int row = 5;

        for (i = 1; i <= row; i++) {
            // 공백 반복
            for(j=1; j <= row - i; j++) {
                System.out.print(" ");
            }
            // 별 반복
            for(k=1; k<=i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        // cf) do-while문 사용 예제
        // : 사용자 입력값을 반복적으로 받아 조건에 맞는 값을 처리할 때 유용

//        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("1부터 10사이의 정수를 입력하세요 >>> ");
            number = scanner.nextInt();

          // 입력값이 1 ~ 10 사이일 때 반복 종료
        } while(number < 1 || number > 10);

        System.out.println("입력한 숫자는 " + number);
        scanner.close();
        
        // cf) 동일한 입력 공간(System.in)을 여러 번 여는 경우 표준 입력 스트림을 닫고 재실행하는 경우 에러 발생 - 운영체제 자원의 스트림이기 때문에 한 번 닫으면 다시 열 수 없음.


        /*
            *****
            ****
            ***
            **
            *

            *****
             ****
              ***
               **
                *
         */

        for(i=0; i<5; i++) {
            // 별 5 4 3 2 1
            for(j=1; j<=row-i; j++) {
                System.out.print("*");
            }
            // 공백 0 1 2 3 4
            for(k=1; k<=row; k++){
                System.out.print(" ");
            }
            System.out.println();
        }

        for(i=1; i<6; i++) {
            // 별 5 4 3 2 1
            for(k=0; k<=row-i; k++) {
                System.out.print("*");
            }
            // 공백 0 1 2 3 4
            for(j=1; j<=i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
