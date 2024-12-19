package chapter03;

import java.util.Arrays;

/*
    Arrays 클래스:
        배열을 조작하는데 유용한 기능들을 제공해주는 자바 내부 클래스
        정렬, 검색, 변환 등
 */
public class C_Array {
    public static void main(String[] args) {
        // === Arrays 클래스 사용법 ===

        // 배열 생성
        int[] numbers = {3, 2, 5, 4, 1};

        // == 1. 배열 정렬 (오름 차순) ==
        // Arrays.sort(정렬할 배열);
        Arrays.sort(numbers);
        System.out.println(numbers[0]);

        // == 2. 배열 변환 ==
        // Arrays.toString(); >> 배열의 전체 구조를 파악할 수 있는 기능
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));

        // == 3. 배열 내 검색 ==
        // Arrays.binarySearch(배열, 검색내용); >> 존재하면 해당 요소의 인덱스 번호 반환, 존재하지 않으면 음수 반환
        System.out.println(Arrays.binarySearch(numbers, 1));
        System.out.println(Arrays.binarySearch(numbers, 6));

        // == 4. 배열의 비교 ==
        // Arrays.equals(a배열, b배열); >> 논리형태로 반환(true, false)
        int[] numbers2 = {1, 2, 3, 5, 4};
        System.out.println(Arrays.equals(numbers, numbers2));

        // == 5. 배열의 채움 ==
        // Arrays.fill(배열, 삽입할 값); >> 배열의 모든 요소를 특정 값으로 채움
        int[] example = new int[3];
        System.out.println(Arrays.toString(example));
        Arrays.fill(example, 10);
        System.out.println(Arrays.toString(example));
    }
}
