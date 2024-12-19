package chapter09;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/*
    java.util 패키지:
        - 자바 표준 라이브러리 중 하나
        - 데이터의 구조, 시간과 날짜 처리, 무작위 숫자 생성 등의 기능을 포함
        - 외부에 있는 클래스를 import하여 사용

    시간과 날짜 처리 클래스
    1. Date 클래스:
        - 날짜와 시간을 표현
        - 현재의 밀리초 단위까지 반환 (1000밀리초 == 1초)

    2. Calendar 클래스:
        - 날짜와 시간을 조작하거나 필드를 개별적으로 제정할 수 있는 도구
        - '추상 클래스'이며 getInstance() 메서드를 통해 구현 객체를 반환받아 사용

    3. java.time 패키지:
        - 날짜와 시간을 다루는 도구 (명확성과 유연성을 제공)
        - java.util Date와 Calendar의 문제점을 보완
 */
public class JavaUtil {
    public static void main(String[] args) {
        // 1. Date 클래스
            // - Date 객체를 생성하여 인스턴스 필드와 메서드를 활용
        Date date = new Date();
            // 1) toString: 날짜와 시간을 문자열로 반환
        System.out.println("현재 날짜와 시간: " + date.toString()); // 현재 날짜와 시간: Thu Dec 05 11:32:14 KST 2024
            // 2) getTime(): 1970년 1월 1일 UTC 기준으로 현재 시간까지 밀리초(ms)를 반환
            // UTC: 시간대의 기준점 한국 (한국 == UTC + 9시간)
            // (오늘 날짜 + 9:00) - (어제 날짜 +9:00)
        System.out.println("현재 시간의 밀리초: " + date.getTime());

        // 2. Calendar 클래스
            // 1) getInstance(): 현재 날짜와 시간으로 초기화된 Calendar 객체 반환
        Calendar calendar = Calendar.getInstance(); // static 메서드

            // 2) get(int field): 지정된 필드의 값을 반환
            // Calendar.YEAR / .MONTH / .Day_Of_Month
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1); // 0 ~ 11 까지 수로 반환
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

            // 3) set(int year, int month, int date): 날짜 설정
        calendar.set(2025, 3, 14);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
