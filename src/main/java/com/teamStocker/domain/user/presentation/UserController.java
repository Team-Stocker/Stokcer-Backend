package com.teamStocker.domain.user.presentation;

import com.teamStocker.domain.user.presentation.dto.request.CreateUserRequest;
import com.teamStocker.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "유저", description = "유저 관련 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @PostMapping
    public void signUp(@RequestBody @Valid CreateUserRequest request) {
        userService.signUp(request);
    }
}
