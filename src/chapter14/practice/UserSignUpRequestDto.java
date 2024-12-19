package chapter14.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
    DTO(Data Transfer Object):
        데이터 전송 객체
        프로세스 간에 데이터를 전달하는 객체를 의미
        계층간 데이터 전송을 위해 사용하는 객체
 */
@AllArgsConstructor
@Data
public class UserSignUpRequestDto {
    private String userId;
    private String password;
    private String passwordCheck;
    private String userName;
    private String email;
    private String phone;
    private String nickname;
}
