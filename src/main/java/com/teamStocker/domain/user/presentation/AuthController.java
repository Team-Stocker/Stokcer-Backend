package com.teamStocker.domain.user.presentation;

import com.teamStocker.domain.user.presentation.dto.request.LoginRequest;
import com.teamStocker.domain.user.presentation.dto.response.JwtResponse;
import com.teamStocker.domain.user.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Auth",description = "Auth 관련 API입니다.")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "로그인")
    @PostMapping
    public JwtResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }

    @Operation(summary = "토큰 재발급")
    @PutMapping
    public JwtResponse getNewAccessToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return authService.getNewAccessToken(refreshToken);
    }
}
