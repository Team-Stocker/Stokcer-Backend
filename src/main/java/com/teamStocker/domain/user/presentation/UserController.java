package com.teamStocker.domain.user.presentation;

import com.teamStocker.domain.user.presentation.dto.request.CreateUserRequest;
import com.teamStocker.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void signUp(@RequestBody @Valid CreateUserRequest request) {
        userService.signUp(request);
    }
}
