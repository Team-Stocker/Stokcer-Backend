package com.teamStocker.domain.user.presentation.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {

    private String email;

    private String password;
}
