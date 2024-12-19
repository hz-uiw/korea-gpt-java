package chapter07;

/*
    final 키워드:
        - 변수, 메서드, 클래스에서 사용 가능
        
        1) 변수: 값을 변경할 수 없는 상수를 선언
        2) 메서드: 자식 클래스에서 재정의(오버라이드)할 수 없는 메서드 선언
        3) 클래스: 상속될 수 없는 클래스를 선언 
 */
class MyFinalClass {
    // 1. final 변수: 
        // 상수를 지정하는 키워드
        // 한 번만 초기화 가능(선언과 동시에 초기화), 재할당 불가능
        // 변수명을 대문자로 작성, 단어 사이에 언더스코어(_)를 사용
    final int FINAL_VARIABLE = 30;
    
    // 2. final 메서드
        // 자식 클래스에서 오버라이드(재정의)할 수 없는 메서드를 의미
        // (접근 제한자) final 반환타입 메서드명 () {}
    public final void myMethod() {
        System.out.println("재정의할 수 없는 메서드!");
    }
}

class ChildClass extends MyFinalClass{
    // 상속받은 final 메서드는 자식 클래스에서 재정의 되지 않는다.
    // 생략된 형태로만 사용 가능
    
    ChildClass() {
        super.myMethod(); 
        // 자식 클래스 생성시 부모 클래스의 메서드 호출
        // 재정의 안되지만 사용 가능하다
    }
}

// 3. final 클래스
// final class 클래스명 {}
// 더 이상 상속될 수 없는 클래스를 의미
// final 클래스를 부모 클래스로 사용할 수 없음

final class Example1 {}

//class Example2 extends Example1 {} // Example1이 final이라 상속할 수 없음

public class C_Final {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass(); // 재정의할 수 없는 메서드!
        childClass.myMethod(); // 재정의할 수 없는 메서드!

        // final의 장단점:
            // 1) 장점: 불변성 (안전성 보장)
            // 2) 단점: 유연성 감소 (상속, 오버라이딩 등이 사용하지 못함. -> 그 자체로만 사용 가능)
    }
}
