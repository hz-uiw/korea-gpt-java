package chapter02;

public class G_Practice {
    public static void main(String[] args) {
        int height1 = 5, height2 = 5;
        /*
            별의 높이를 고정값 5로 설정
            줄의 순서: 1, 2, 3, 4, 5
            별의 개수: 5, 4, 3, 2, 1
            *****
            ****
            ***
            **
            *
         */

        // 첫 번째 for문: row 제어
        for(int i = height1; i >= 1; i--) {
            // 두 번째 for문: 각 줄에 별을 출력
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }

        /*
            *****
             ****
              ***
               **
                *
         */

        // 첫 번째 for문: row제어
        for(int i = height2; i >= 1; i--) {
            // 두번째 for문: 줄의 시작 부분에 공백을 추가(오른쪽 정렬)
            // 0, 1, 2, 3, 4
            for(int j = 1; j <= height2 - i; j++)
                System.out.print(" ");
            // 세번째 for문: 별 추가
            // 5, 4, 3, 2, 1
            for (int k = 1; k <= i; k++)
                System.out.print("*");
            System.out.println();
        }
    }
}
