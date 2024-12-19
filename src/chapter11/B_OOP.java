package chapter11;

/*
        4. 인터페이스 분리 원칙 (ISP, Interface Segregation Principle)
            - 하나의 큰 인터페이스보다 여러 개의 인터페이스를 사용하는 것을 권장
            - 인터페이스의 단일 책임을 강조 -> SRP의 인터페이스 버전
            - 클래스는 자신이 사용하지 않는 메서드에 의존하지 않아야 함
 */

// ISP의 잘못된 예 - 로봇은 work() 메서드에 해당되나, eat() 메서드를 실행할 수 없으므로 일관된 행위의 인터페이스로 구현
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("로봇은 일을 할 수 있습니다.");
    }

    // 로봇이 먹는 행위를 필요하지 않지만 강제로 구현해야 함
    @Override
    public void eat() {
        System.out.println("로봇은 음식을 먹지 않습니다.");
    }
}

// ISP 설계 원칙 - 하나의 인터페이스의 work();와 eat(); 메서드를 구분하여 두개의 인터페이스에 구현
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class WorkRobot implements Workable { // 인터페이스로부터 상속받은 클래스를 필요에 맞게 implements한다
    @Override
    public void work() {
        System.out.println("로봇은 일을 할 수 있습니다.");
    }
}
/*
        5. 의존 역전 원칙(DIP, Dependency Inversion Principle)
            - 고수준 모듈은 저수준 모듈에 의존해서는 안되며 둘 다 추상화에 의존해야 함
            - 세부 구현이 아닌, 추상화된 인터페이스에 의존하도록 설계해야 함
 */
// DIP 잘못된 예시 - 컴퓨터를 통해서 키보드 객체를 생성하는 것이 아닌 상위 클래스/인터페이스로 객체 생성
class Keyboard {}
class Computer {
    private Keyboard keyboard;
    public Computer() {
        // Computer가 Keyboard라는 구체적인 구현 클래스에 의존
        this.keyboard = new Keyboard();
    }
}

// DIP 설계 원칙 - 
interface InputDevice {} // InputDevice라는 상위 인터페이스에 하위 클래스 DipComputer로 인터페이스를 인자로 한 클래스 생성 -> 의존성 관리

class Mouse implements InputDevice {}

class Speaker implements InputDevice {}

// DipComputer는 InputDevice라는 추상화에 의존
// - 새로운 입력 장치가 추가되더라도 코드 수정 없이 확장 가능
class DipComputer {
    private InputDevice inputDevice;

    public DipComputer(InputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }
}

// >> 의존 역전 원칙은 각 클래스 간의 결합도(Coupling)을 낮추는 것
public class B_OOP {
    public static void main(String[] args) {
        
    }
}
