package chapter09;

/*
    자바 예외 처리

    1. 예외(Exception):
        - 프로그램 실행 중에 발생할 수 있는 예기치 못한 문제나 조건

        +)예외 처리:
            - 예외가 발생할 경우 프로그램이 중단되지 않고 대응하여 정상적인 흐름을 유지하는 방법

    2. 자바 예외 클래스 구조:
        - Throwable:
            - 모든 예외와 오류의 최상위 클래스
            - 모든 예외 클래스는 해당 클래스를 상속 받음
            >> 예외와 관련된 메시지, 처리 방법에 대한 예시 정보를 포함
 */
class CustomException extends Throwable {

}
/*
        1) Exception 클래스 (예외):
            프로그램이 처리할 수 있는 예외들을 정리
            >> 예외 처리를 통해 개발자가 처리할 수 있는 문제들을 정의

            - Checked Exception:
                - 컴파일 시점에 체크되는 예외
                - 개발자가 직접 반드시 처리
                - 컴파일러는 해당 예외가 처리되어 있지 않을 경우 오류를 발생

            - Runtime(Unchecked) Exception:
                - 런타임 시점에 발생되는 예외
                - 개발자의 실수로 발생하는 예외
                - 컴파일러가 강제하지 않음 (체크하지 않음)

            +) 컴파일 시점과 런타임 시점 차이:
                - 컴파일: 소스코드를 기계어로 번역하는 단계, 실행되지 않고 코드를 분석하고 변환하는 과정에만 국한
                        자바에서는 .java파일이 컴파일 되어 .class 파일(바이트코드)로 생성
                - 런타임: 컴파일된 프로그램이 실행되는 단계, 프로그램이 실제로 메모리에 로드되고 CPU에서 실행됨
                        컴파일 시점에서 잡히지 않은 논리적 오류나 런타임 예외 발생 가능성이 존재


        2) Error (오류):
            - 프로그램 외부에서 발생하는 시스템 수준 문제
            >> 개발자가 직접 처리할 수 없음
            ex) 메모리 부족, 네트워크 연결 등

        3) 자바 예외처리 방법:
            - try-catch 블록, throws throw 사용자 정의 예외

            try-catch 블록:
                try {
                    예외가 발생할 수 있는 코드
                } catch (ExceptionType1 e1) {
                    예외 발생 시 실행할 코드
                } catch (ExceptionType2 e2) {
                    예외 발생 시 실행할 코드
                }

                - catch 블록: 특정 예외 타입이 발생했을 때 실행될 코드를 정의
                    >> 다중 catch 블록으로 사용 가능 (여러 예외 처리 가능)
*/
public class Exception01 {
    public static void main(String[] args) {
        //  char c1 = 'abc'; - 컴파일 예외
        String s1 = "string";

        // System.out.println(c1); - 컴파일 예외
        System.out.println(s1);

        // int division = 10 / 0; - 런타임 예외

        try {
            // 예외 발생 가능성 코드 작성
            int division = 10 / 0; // 정수를 0으로 나눌 수 없다
        } catch (Exception e) {
            // try 블록 내에서 발생하는 예외를 ()소괄호 내에서 매개변수로 전달 받아 {} 실행문에서 처리
            System.out.println(e.getMessage()); // / by zero
            System.out.println("0으로 나눌 수 없습니다.");
        }

        System.out.println("정상적인 실행입니다.");
        System.out.println("===========================================");
        try {
            System.out.println("정상 실행");
//            int division = 10 / 0; // ArithmeticException 발생
            System.out.println("실행되지 않음");
            int[] numbers = new int[5];
//            numbers[10] = 50; // ArrayIndexOutOfBoundsException 발생

            String text = null;
            System.out.println(text.length());
            // null을 계산할 경우 예외 발생: NullPointerException 발생

        } catch (ArithmeticException e) {
            System.out.println("수학적 공식의 에러 발생 " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 인덱스 초과 오류 발생 " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("null 계산할 경우 오류 발생 " + e.getMessage());
        } catch (Exception e) {
            System.out.println("초과 오류 발생 " + e.getMessage());
        } finally {
            // 예외 발생 여부와 상관없이 항상 실행되는 코드 블럭
            System.out.println("finally 블록 실행");
        }
/*
    throw 키워드:
        - 프로그램 실행 중에 특정 조건에서 예외를 직접 발생시킬 때 사용
        > 주로 조건문과 함께 사용

        사용법:
            throw new ExceptionType("예외 메시지");
 */
        int age = -10;

        try {
            if (age < 0) {
                throw new Exception("나이는 음수가 될 수 없습니다."); // 나이는 음수가 될 수 없습니다.
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("반드시 실행되어야 할 코드");
    }
}
