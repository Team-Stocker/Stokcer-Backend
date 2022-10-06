package com.teamStocker.domain.user.service;

import com.teamStocker.domain.user.domain.repository.UserRepository;
import com.teamStocker.domain.user.facade.UserFacade;
import com.teamStocker.domain.user.presentation.dto.request.CreateUserRequest;
import com.teamStocker.domain.user.presentation.dto.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
