package chapter10.practice1;

abstract public class Item {
    // 필드 선언
    private String id;
    private String name;

    // 생성자
    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // private로 인한 getter
    public String getId() {return id;}
    public String getName() {return name;}

    // 추상 메서드
    public abstract void display();

}
