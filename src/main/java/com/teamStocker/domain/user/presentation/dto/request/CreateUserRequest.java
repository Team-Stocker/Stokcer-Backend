package com.teamStocker.domain.user.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamStocker.domain.user.domain.User;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;

@Getter
public class CreateUserRequest {

    @JsonProperty("nick_name")
    private String nickName;

    @NotNull(message = "이메일을 입력해주세요")
    private String email;

    @NotNull(message = "비밀번호를 입력해주세요")
    private String password;

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .nickName(nickName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
    }
}
