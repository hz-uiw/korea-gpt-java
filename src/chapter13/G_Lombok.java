package chapter13;

import lombok.Getter;
import lombok.Lombok;
import lombok.Setter;

@Getter
@Setter
class LombokExample {
    private String name;
    private int age;

//    public void setName(String name) {
//        this.name = name;
//    }
}
public class G_Lombok {
    public static void main(String[] args) {
        LombokExample lombokExample = new LombokExample();
        lombokExample.setName("권민창");
        lombokExample.setAge(25);

        System.out.println(lombokExample.getName());
        System.out.println(lombokExample.getAge());
    }
}
