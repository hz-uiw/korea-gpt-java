package chapter09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
    java.time 패키지:
        - ISO-8601 표준을 기반으로 설계되어 있음
        - YYYY-MM-DDThh:mm:ss.sssZ
 */
public class JavaTime {
    public static void main(String[] args) {
        // 1) LocalDate (날짜: 연도, 월, 일)
            // .now() - 현재 날짜 반환
            // .of(연도, 월, 일) - 특정 날짜 반환
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate specificDate = LocalDate.of(2025, 3, 14);
        System.out.println(specificDate);

        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

        LocalDate oneMonthAgo = today.minusMonths(1);
        System.out.println(oneMonthAgo);

        // 2) LocalTime (시간)
            // 시간(시, 분, 초, 나노초)만 다룸
            //날짜와 시간대 정보는 포함하지 않는다
            // .now() - 현재 시간 반환
            // .of(시, 분, 초) - 특정 시간 반환
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime specificTime = LocalTime.of(14, 30);
        System.out.println(specificTime);

        LocalTime thirtyThreeMinutesLater = now.plusMinutes(33);
        System.out.println(thirtyThreeMinutesLater);

        LocalTime oneHourAgo = now.minusHours(1);
        System.out.println(oneHourAgo);

        // cf) get 메서드
        // getYear(), getMonth(), getDayOfMonth() - 날짜 정보 반환
        // getHour(), getMinute(), getSecond() - 시간 정보 반환
        System.out.println(today.getMonth());
        System.out.println(now.getHour());

        // cf) LocalDateTime 클래스:
            // 날짜와 시간을 함께 다루는 클래스
            // .now(), .of(), .plus~(), .minus~() 사용 가능
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);
        System.out.println(nowDateTime.toLocalDate());
        System.out.println(nowDateTime.toLocalTime());

        // cf) 날짜와 시간 포맷팅(formatting)
        LocalDateTime example = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(example.format(formatter));
    }
}
