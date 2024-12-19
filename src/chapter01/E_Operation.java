package chapter01;

public class E_Operation {
    public static void main(String[] args) {
        /*
            연산자(Operation)
            : 프로그램에서 데이터를 조작하거나 계산
         */

        System.out.println("=== 산술 연산자 ===");
        System.out.println(10 + 20);    // 덧셈
        System.out.println(10 - 20);    // 뺄셈
        System.out.println(10 * 20);    // 곱셈
        System.out.println(21 / 10);    // 몫 - 나눗셈 결과의 몫을 저장
        System.out.println(21 % 10);    // 나머지 - 나눗셈 결과의 나머지를 저장

        System.out.println("=== 증감 연산자 ===");
        int number = 10;
        // 후위 증감 연산자: 값이 계산된 후 변경됨
        System.out.println(number++);   // 10
        System.out.println(number--);   // 11

        // 전위 증감 연산자: 값이 먼저 변경되고 나서 계산에 사용됨
        System.out.println(++number);   // 11
        System.out.println(--number);   // 10

        System.out.println("=== 대입(할당) 연산자 ===");
        number = 10;
        System.out.println(number += 3); // number = number + 3
        System.out.println(number -= 3); // number = number - 3
        System.out.println(number *= 3); // number = number * 3
        System.out.println(number /= 3); // number = number / 3
        System.out.println(number %= 3); // number = number % 3
        System.out.println(number);

        System.out.println("=== 비교 연산자 ===");
        // : 좌항을 우항과 비교한 결과를 논리(true, false) 값으로 반환
        // - <, >, <=, >=, ==, !=

        System.out.println(5 > 3);
        System.out.println(5 < 3);
        System.out.println(5 >= 3);
        System.out.println(5 <= 3);
        System.out.println(5 == 3);
        System.out.println(5 != 3);

        System.out.println("=== 논리 연산자 ===");
        // : 논리(boolean)값을 연산
        // cf) &: 앰퍼샌드, |: vertical bar

        // &&: and(논리곱)
        // - 모든 값이 true면 true
        // - 하나의 값이라도 false면 false
        System.out.println(true && true);
        System.out.println(true && true && false);

        // ||: or(논리합)
        // - 하나의 값이라도 true면 true
        System.out.println(true || true);
        System.out.println(true || false || false);

        // !: not(부정논리)
        // - 값을 전환
        // - 논리값 앞에 작성하여 값을 전환
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(!bool1);
        System.out.println(!bool2);

        System.out.println(3 > 2 && 1 == 1); // true
        System.out.println(1 != 1); // false
        System.out.println(3 >= 3 || 10 < 11 && !bool2); // true

        System.out.println("=== 조건 연산자 ===");
        // : 삼항 연산자
        // 조건식 ? 조건식이 참인 경우 반환 : 조건식이 거짓인 경우 반환;
        // cf) 조건식은 결과값이 논리값으로 반환

        int age = 27;
        System.out.println(age > 19 ? "성인입니다." : "미성년자입니다.");

        /*
            정수를 담는 x, y 변수를 선언하여 각각 10과 2를 할당
            x와 y를 사용하여 x값이 짝수이면 "2의 배수입니다.", 홀수면 "2의 배수가 아닙니다."출력
        */
        int x = 10, y = 2;
        System.out.println(x % y == 0 ? "2의 배수입니다." : "2의 배수가 아닙니다.");

        System.out.println("=== 기타 연산자 ===");
        // 문자열 연결 연산자: +
        String result = "권" + "민창";
        System.out.println(result);

        // 괄호 연산자: 우선 순위를 명시적으로 지정할 때 사용
        int num = (1 + 3) * 4;
    }

    public static class C_Conversion {
        public static void main(String[] args) {
            /*
                자바 형 변환 (Type Conversion)
                : 하나의 타입을 다른 타입으로 바꾸는 것

                자료형의 크기에 따른 변환 규칙
                byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
                - 메모리 설계 상 정수 타입보다 실수 타입이 더 큼

                char(2)
                boolean(1)
             */

            // 1. 자동 형 변환 (묵시적)
            // : 크기가 큰 자료형으로의 변환
            byte smallBox = 10; // 1byte
            int bigBox = 10000; // 4byte

            // 작은 범위의 타입을 큰 타입의 타입에 넣을 때는 컴파일러가 자동으로 형 변환을 수행
            bigBox = smallBox;

            byte a = 32;
            short b = a;
            int c = b;
            long d = c;

            float e = d;
            // char f = e; (묵시적 형 변환 X)

            // 2. 강제 형 변환 (명시적)
            // : 크기가 작은 자료형으로의 변환
            int number = 1234;
            float fNumber = number;

            float fNumber2 = 1234.123F;
            // 강제 형 변환 방법: (작은 자료형 타입) 큰 데이터 값;
            int number2 = (int)fNumber2;

            System.out.println(number2);


            // cf) char 자료형의 형 변환
            char a1 = 'a';
            char a2 = 97;   // 아스키코드 값
            char a3 = '\u0061'; // 유니코드 값

            // 줄 복사 단축키: ctrl + alt + 방향키
            System.out.println(a1); // a
            System.out.println(a2); // a
            System.out.println(a3); // a

            char example = '가';
            System.out.println((int)example);   // 44032
            System.out.println((int)example + 1);   // 44033
            System.out.println((char)((int)example + 1));   // 각

            // cf) char 자료형 음수 표현식 X

            long longType = 123456;
            int intType = (int)longType;
            short shortType = (short)intType;
            char charType = (char)shortType;
            System.out.println(charType);   // 
        }
    }
}
