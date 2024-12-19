package chapter07.practiceApp;

/*
    App 클래스
    - Entity의 객체(부모1, 자식2)를 활용하는 시스템 구현

    ex) (동물 / 상품 / 과일 / 학생 / 직원) 관리 시스템
 */
class Fruit {
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }
}
public class App {
    public static void main(String[] args) {

    }
}
