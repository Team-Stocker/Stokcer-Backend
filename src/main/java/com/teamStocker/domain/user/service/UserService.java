package com.teamStocker.domain.user.service;

import com.teamStocker.domain.diary.presentation.dto.response.DiaryResponse;
import com.teamStocker.domain.user.domain.repository.UserRepository;
import com.teamStocker.domain.user.facade.UserFacade;
import com.teamStocker.domain.user.presentation.dto.request.CreateUserRequest;
import com.teamStocker.domain.user.presentation.dto.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(CreateUserRequest request) {
        userFacade.validateSignUp(request.getEmail(), request.getNickName());
        userRepository.save(request.toEntity(passwordEncoder));
    }

    @Transactional(readOnly = true)
    public MyPageResponse findMyPage() {
        return MyPageResponse.of(userFacade.getCurrentUser());
    }

    @Transactional(readOnly = true)
    public List<DiaryResponse> findAllMyDiary() {
        return userFacade.getCurrentUser().getDiaries().stream()
                .map(DiaryResponse::of)
                .collect(Collectors.toList());
    }
}
