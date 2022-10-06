package com.teamStocker.domain.user.facade;

import com.teamStocker.domain.user.domain.User;
import com.teamStocker.domain.user.domain.repository.UserRepository;
import com.teamStocker.domain.user.exception.PasswordMismatchException;
import com.teamStocker.domain.user.exception.UserAlreadyExistsException;
import com.teamStocker.domain.user.exception.UserNotFoundException;
import com.teamStocker.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkPassword(User user, String password) {
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }

    public void validateSignUp(String email, String nickName) {
        if (userRepository.existsByEmail(email) || userRepository.existsByNickName(nickName)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserByEmail(auth.getUsername());
    }
}
