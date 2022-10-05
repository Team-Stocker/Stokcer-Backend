package com.teamStocker.domain.user.service;

import com.teamStocker.domain.user.domain.User;
import com.teamStocker.domain.user.facade.UserFacade;
import com.teamStocker.domain.user.presentation.dto.request.LoginRequest;
import com.teamStocker.domain.user.presentation.dto.response.JwtResponse;
import com.teamStocker.global.redis.RedisService;
import com.teamStocker.global.security.jwt.JwtProperties;
import com.teamStocker.global.security.jwt.JwtTokenProvider;
import com.teamStocker.global.security.jwt.JwtValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtValidateService jwtValidateService;
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisService redisService;

    @Transactional(readOnly = true)
    public JwtResponse login(LoginRequest request) {
        User user = userFacade.findUserByEmail(request.getEmail());
        userFacade.checkPassword(user, request.getPassword());

        final String accessToken = jwtTokenProvider.createAccessToken(user.getEmail());
        final String refreshToken = jwtTokenProvider.createRefreshToken(user.getEmail());

        redisService.setDataExpire(request.getEmail(), refreshToken,  Duration.ofMillis(JwtProperties.REFRESH_TOKEN_VALID_TIME));


        return JwtResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Transactional(readOnly = true)
    public JwtResponse getNewAccessToken(String refreshToken) {
        jwtValidateService.validateRefreshToken(refreshToken);

        return JwtResponse.builder()
                .accessToken(
                        jwtTokenProvider.createAccessToken(
                                jwtValidateService.getEmail(refreshToken)
                        )
                )
                .build();
    }
}
