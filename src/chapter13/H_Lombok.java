package chapter13;

import lombok.*;

/*
    Lombok(롬복) 라이브러리:
        - 보일러 플레이트 코드를 줄여주는 라이브러리
        - 어노테이션을 사용하여 코드를 간결하게 만들어 줌

        cf) 보일러플레이트 코드: 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화 된 코드
 */

// 1. @Getter / @Setter 어노테이션
    // : 필드에 대한 getter와 setter 메서드를 자동으로 생성
//@Getter
//@Setter

// 2. @ToString 어노테이션
// : 클래스의 toString() 메서드를 자동으로 구현
// - sout에 객체를 출력하는 경우 아래와 같이 출력
// - 클래스명(필드명1 = 필드값1, 필드명2 = 필드값2)
//@ToString

// 3. 생성자 어노테이션
// cf) 매개변수 - parameter(params), 인자(인수) - argument(args)
// 1) @NoArgsConstructor: 기본 생성자
// 2) @RequiredArgsConstructor: 필수 필드 생성자
// 3) AllArgsConstructor: 전체 필드 생성자
//@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

// 4. @Data 어노테이션
// : @Setter, @Getter, @ToString, @RequiredConstructor, @EqualAndHashCode 어노테이션을 한번에 적용하는 어노테이션
@Data // @Setter, @Getter, @ToString, @RequiredConstructor, @EqualAndHashCode 포함

// 5. @Builder 어노테이션
// : 복잡한 객체를 생성할 때 사용하는 빌더 패턴을 자동으로 구현
// - @Builder 어노테이션을 사용하는 빌더 패턴의 경우
    // 필드 값을 모두 메서드 체이닝으로 가져옴
// - 클래스명.builder().build();
    // : 필수값을 builder() 메서드의 인자로 받지 않음
    // : 메서드 체이닝 내에서 누락시 오류
@Builder
class LombokClass {
    private final String title;
    private String author;

    // public String getTitle() { return title; }
    // public String getAuthor() { return author; }

    // toString 메서드: Object 객체 클래스 내의 메서드 - 클래스 내의 데이터의 문자열 출력을 담당
//    @Override
//    public String toString() {
//        return "Title: " + title + ", Author: " + author;
//    }

//    LombokClass(String title) {
//        this.title = title;
//    }

//    // Builder 클래스
//    // : 프로젝트 전역적인 접근이 가능
//    public static class Builder {
//        private final String title;
//        private String author = "작가 미상";
//
//        // 빌더 클래스의 인자 - 필수 필드값
//        public Builder(String title) {
//            this.title = title;
//        }
//
//        // 선택 필드값 설정을 위한 메서드
//        public Builder author(String author) {
//            this.author = author;
//            return this;
//        }
//        // 만들어진 Builder의 인스턴스를 LombokClass에 전달하는 build 메서드
//        public Lombok build() {
//            return new Lombok(this);
//        }
//    }
//
//    // build 메서드 내에서 호출될 생성자
//    // : Builder 패턴으로 만들어진 필드값들을 전달 받는 ㅅ ㅐㅇ성자
//    public LombokClass(Builder builder) {
//        this.title = builder.title;
//        this.author = builder.author;
//    }
}
public class H_Lombok {
    // 필드에 필수값을 지정
    // : null 값이 들어갈 수 없음!

    // cf) final 키워드 - 참조 데이터 타입의 기본값으로 null이 포함 가능
    @NonNull
    public static void main(String[] args) {
        LombokClass lombokClass1 = new LombokClass("Hey", "Kwon");
        // cf) final 변수값 - 재할당 불가
        // lombokClass1.setTitle("건민창");
        lombokClass1.setAuthor("권민창");

        LombokClass lombokClass2 = new LombokClass("sick", "kim");
        // lombokClass2.setTitle("김민성 븅신");
        lombokClass2.setAuthor("김민성");

        System.out.println(lombokClass1); // LombokClass(title=건민창, author=권민창)
        System.out.println(lombokClass2);

        // 정적 내부 클래스: 클래스명.내부클래스()
        LombokClass lombokClass3 = LombokClass.builder().title("건민창").build();
        System.out.println(lombokClass3.getAuthor());

        // @NonNull 어노테이션 필드는 반드시 생성 시 값의 할당이 이루어져야 함!
        LombokClass lombokClass4 = LombokClass.builder().author("루피").build();
        System.out.println(lombokClass4.getTitle());
        System.out.println(lombokClass4.getAuthor());
    }
}
