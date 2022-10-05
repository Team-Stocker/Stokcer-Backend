package com.teamStocker.domain.user.presentation;

import com.teamStocker.domain.user.presentation.dto.request.LoginRequest;
import com.teamStocker.domain.user.presentation.dto.response.JwtResponse;
import com.teamStocker.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public JwtResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }

    @PutMapping
    public JwtResponse getNewAccessToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return authService.getNewAccessToken(refreshToken);
    }
}
