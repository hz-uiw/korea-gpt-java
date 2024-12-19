package chapter10;

import java.util.*;

/*
    Map 인터페이스:
        - 키(key)와 값(Value)의 쌍으로 요소를 저장하는 데이터 구조
        - 키는 고유한 데이터를 가짐 (중복 키 허용 안됨)
        - 동일한 키에 서로 다른 전달하는 경우 기존 값이 새로운 값으로 떺어씌워짐
        ex) name: "권민창"이 존재한 상태에서 name: "권민"을 추가하는 경우 name의 키에는 "권민"만이 존재
        - 서로 다른 키에서 동일한 값 저장은 가능
        ex) name: "개구리", nickname: "개구리" 가능
        - 키의 유일성, 값의 중복성, 순서 보장되지 않음 -> LinkedHashMap은 순서 보장
        - 키를 기반으로 빠른 검색 가능

     Map의 인터페이스 종류(구현체):
        1. HashMap:
            - 가장 많이 사용되는 Map 구현체
            - 키와 값에 null 허용
            - 빠른 검색 및 삽입 성능 제공
            - 순서 유지 안됨

        2. LinkedHashMap:
            - HashMap + 삽입 순서 유지
            - 삽입 순서가 중요하고 빠른 검색이 필요할 때 주로 사용

        3. TreeMap:
            - 키에 따라 자동 정렬 기능 보장
            - 키에 null 허용 안됨
 */
public class E_Map {
    public static void main(String[] args) {
        // Map 인터페이스 메서드

        // put(K key, V value): 키와 값을 Map에 추가
        // get(Object key): 지정된 키에 매핑된 '값'을 반환
        // remove(Object key): 주어진 키와 연관된 '키-값' 쌍 삭제(반환)
        // containsKey(Object key): 주어진 키가 Map에 있는지 확인하여 boolean 값으로 반환

        // keySet(): Map의 키를 Set으로 반환
        // values(): Map의 값을 컬렉션 타입으로 반환 -> Collection의 경우 컬렉션 프레임워크들의 상위 집합

        // entrySet(): Map의 키-값 쌍을 나타내는 Set을 반환

        // Map의 컬렉션 선언 방법
        // Map<키타입< 값타입> 인스턴스명 = new Map종류<>();

        Map<String, Integer> students = new HashMap<>();
        // 이름(키), 나이(값)
        students.put("권민창", 25);
        students.put("권영진", 22);
        students.put("정현영", 28);

        System.out.println(students); // {권영진=22, 정현영=28, 권민창=25} -> 순서 보장 되지 않고 {} 형식 사용, 키와 값을 '='로 구분

        System.out.println(students.get("권영진")); // 22

        students.remove("권영진");
        System.out.println(students);

        System.out.println(students.containsKey("정현영")); // true
        System.out.println(students.containsKey("권민")); // false

        System.out.println(students.size()); // 2

        System.out.println(students.keySet()); // [정현영, 권민창]
        Set<String> names = students.keySet();

        System.out.println(students.values()); // [28, 25]
        Collection<Integer> ages = students.values();

        // Collection을 List로 변환
        // : List 인터페이스의 구현체로 변환
        List<Integer> listAges = new ArrayList<>(ages);

    }
}
