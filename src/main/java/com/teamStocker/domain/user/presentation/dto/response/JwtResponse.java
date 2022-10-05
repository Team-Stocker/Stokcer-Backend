package com.teamStocker.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtResponse {

    private String accessToken;
    private String refreshToken;
}
