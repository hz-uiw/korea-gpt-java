package chapter02;

/*
    반복문:
        어떤 특정 조건이 만족될 때까지 동일한 작업을 반복적으로 실행할 때 사용

    종류:
        for, while, do-while
 */
public class C_For {
    public static void main(String[] args) {
        /*
            for문:
                특정 조건이 만족될 때까지 코드 블럭 반복 실행
                횟수가 정해져 있을 때 사용

            for(초기화; 조건; 증감) {
                조건이 만족될 때 실행할 코드
            }

            1. 초기화: 반복에 사용할 변수
            2. 조건: 해당 조건이 참인 동안 반복문이 실행
            3. 증감: 매 반복마다 변수를 증감
         */

        for (int num = 1; num <= 5; num++) {
            System.out.println(num);
        }
        System.out.println();
        /*
            예제
            for 반복문 사용해서 1부터 10까지 짝수만 출력
         */
        for(int i = 1; i <= 10; i++) {
            if(i % 2 == 0) System.out.print(i);
        }
        System.out.println();

        // for 반복문을 사용하여 구구단의 일부를 출력하는 코드
        System.out.println("=== 구구단 3단 ===");
        int num = 3;

        for(int i = 1; i < 10; i++) System.out.println(num + " X " + i + " = " + num*i);
        System.out.println();

        // 중첩 for문(반복문)
        // 반복하고 싶은 횟수를 명확하게 확인, 초기화를 0으로, 조건을 횟수 미만으로 설정
        // 구구단 전체를 출력하는 코드
        for(int i = 0; i < 8; i++) {
            System.out.println("=== " + (i+2) + "단 ===");
            for(int j = 0; j < 9; j++) {
                System.out.println((i+2) + " X " + (j+1) + " = " + ((i+2)*(j+1)));
            }
            System.out.println();
        }

        int i = 0; // 같은 스코프 내의 변수가 아니기 때문에 i 변수 선언 가능
    }
}