package chapter14;

// 자바의 함수형 인터페이스를 보관하고 있는 패키지
import java.util.function.*;
import java.util.HashMap;
import java.util.Map;
/*
    Predicate:
        - 입력값을 받아 조건을 검사하는데 사용
        - 메서드:
            - boolean Test(T t): 주어진 입력값이 조건을 만족하면 true를 반환, 그렇지 않으면 false 반환
            - and(Predicate other), or(Predicate other), negate(): Predicate 조합을 위해 사용
            cf) negate: 부정하다 (현재의 결과를 반환)

    Function:
        - 입력값을 받아 특정 연산을 수행한 후 결과를 반환
        - 메서드:
            - R apply(t, y): 입력값을 받아 변환한 값을 반환
            - andThen(Function after): 현재 결과를 다른 Function의 입력으로 연결
            - compose(function before): 다른 Function의 결과를 현재 입력으로 연결

    Consumer:
        - 입력값을 받아 소비(출력 또는 상태 변경)하는데 사용
        - 메서드:
            - void accept(T t): 입력값을 소비
            - andThen(Consumer after): 연속적인 소비 작업을 위해 사용

    Supplier:
        - 값을 공급(생성)하는데 사용, 입력값이 필요로 하지 않음
        - 외부에서 값을 가져오거나, 데이터를 생성하여 반환하는 역할
            - T get(): 반환
 */
public class E_Lambda {
    public static void main(String[] args) {
        // ========== Predicate ==========
        // 인터페이스<T, U> 메서드명 = 매개변수, 매개변수 -> 실행문
        // : 해당 람다 내에서 다양한 타입 활용
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        // 기본 조건 검사
        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(5)); // false

        // 조건 결합
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println(isEvenAndPositive.test(4)); // true
        System.out.println(isEvenAndPositive.test(-4)); // false

        // ========== Function ==========
        // <T, R> Type parameters:
        // <T> – the type of the input to the function
        // <R> – the type of the result of the function
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, Integer> square = n -> n * n;

        System.out.println(stringLength.apply("Hello")); // 5

        Function<String, Integer> lengthAndSquare = stringLength.andThen(square);
        System.out.println(lengthAndSquare.apply("Hello")); // 25

        // ========== Consumer ==========
        Consumer<String> printMessage = msg -> System.out.println(msg);
        Consumer<String> printLength = msg -> System.out.println(msg.length());

        printMessage.accept("안녕하세요 :)"); // 안녕하세요 :)

        Consumer<String> combinedConsumer = printMessage.andThen(printLength);
        combinedConsumer.accept("안녕하세요 :)"); // 8

        // ========== Supplier ==========
        Supplier<Double> randomValue = () -> Math.random(); // 0.0과 0.1 사이의 난수
        System.out.println(randomValue.get());

        // ========== Map 활용 람다식 ==========
        Map<String, Integer> scores = new HashMap<>();
        scores.put("권민창", 85);
        scores.put("정현영", 100);
        scores.put("김민성", 0);

        scores.forEach((name, score) -> System.out.println(name + ":" +score));
    }
}
