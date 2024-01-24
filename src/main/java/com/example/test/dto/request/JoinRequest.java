package com.example.test.dto.request;

import com.example.test.entity.UserInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    private String userId;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;

    @NotBlank(message = "이름이 비어있습니다.")
    private String name;

    @NotBlank(message = "주민번호가 비어있습니다.")
    private String regNo;

    // 비밀번호 암호화 X
    public UserInfo toEntity() {
        return UserInfo.builder()
                .userId(this.userId)
                .password(this.password)
                .build();
    }

    // 비밀번호 암호화
    public UserInfo toEntity(String encodedPassword) {
        return UserInfo.builder()
                .userId(this.userId)
                .password(encodedPassword)
                .name(this.name)
                .regNo(this.regNo)
                .build();
    }
}