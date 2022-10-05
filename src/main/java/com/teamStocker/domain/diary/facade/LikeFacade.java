package com.teamStocker.domain.diary.facade;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.repository.LikeRepository;
import com.teamStocker.domain.diary.exception.AlreadyLikeException;
import com.teamStocker.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeFacade {

    private final LikeRepository likeRepository;

    public void validateCreateLike(User user, Diary diary) {
        if (likeRepository.existsByUserAndDiary(user, diary)) {
            throw AlreadyLikeException.EXCEPTION;
        }
    }
}
