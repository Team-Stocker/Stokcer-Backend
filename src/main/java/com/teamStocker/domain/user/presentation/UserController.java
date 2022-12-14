package com.teamStocker.domain.user.presentation;

import com.teamStocker.domain.diary.presentation.dto.response.DiaryResponse;
import com.teamStocker.domain.user.presentation.dto.request.CreateUserRequest;
import com.teamStocker.domain.user.presentation.dto.response.MyPageResponse;
import com.teamStocker.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @Operation(summary = "마이 페이지")
    @GetMapping("/profile")
    public MyPageResponse findMyPage() {
        return userService.findMyPage();
    }

    @Operation(summary = "자신이 쓴 일기 전부 조회")
    @GetMapping("/dairy")
    public List<DiaryResponse> findAllMyDiary() {
        return userService.findAllMyDiary();
    }
}
