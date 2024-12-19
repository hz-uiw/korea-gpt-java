package chapter07.animalApp;

import java.util.ArrayList;
// 1st
// == 동물 관리 시스템 == //
public class App {
    public static void main(String[] args) {
        // == 서비스 계층 생성 ==
        AnimalService service = new AnimalService();

        // 객체 생성 및 처리
        Animal cat = new Cat();
        Animal dog = new Dog();

        service.handleAnimal(cat); // 야옹!!
        service.handleAnimal(dog); // 멍멍!!

        // cat.eat(); - Error 다운캐스팅 필요 -> Animal cat = new Cat(); -> cat의 데이터 타입은 Animal이기 때문

        if (cat instanceof Cat) {
            Cat onlyCat = (Cat) cat; // 다운캐스팅 - 해당 클래스가 가진 고유 멤버에 접근 가능
            onlyCat.eat(); // 나는 츄르가 좋아
        }


        // 동물을 관리하는 List 생성
        ArrayList<Animal> animals = new ArrayList<>();

        // 동적 배열에 객체 추가 - 업캐스팅
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cat());

        // 동적 배열의 모든 동물들을 service로 처리
        for (Animal animal : animals) {
            service.handleAnimal(animal);
        }
    }
}
