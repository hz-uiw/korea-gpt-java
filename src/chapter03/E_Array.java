package chapter03;

import java.util.ArrayList;

public class E_Array {
    public static void main(String[] args) {
        /*
            크기 10의 ArrayList 생성, 1 ~ 10까지의 숫자를 추가한 뒤 출력
            반복문 사용
            추가한 숫자 중 홀수만 제거하고 결과 출력
            인덱스 3에 값 50을 삽입, 출력
         */
        ArrayList<Integer> list = new ArrayList<>(10);

        // 리스트 생성 후 출력
        for(int i=1; i<11; i++) {
           list.add(i);
        }
        System.out.println("리스트: " + list);

        // 홀수만 제거하고 결과 출력
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)%2 != 0) {
                list.remove(i);
                // 요소를 삭제하고난 후 인덱스 조정 (ArrayList의 경우 크기가 동적으로 변경)
                // cf) 인덱스 조정을 하지 않을 경우 정상 동작이 되지 않는 경우: 연속된 요소를 제거할 때(홀수가 연속될 경우)
                i--;
            }
        }
        System.out.println("홀수 제거 리스트: " + list);


        list.set(3, 50);
        System.out.println("조정 후 리스트: " + list);
    }
}
