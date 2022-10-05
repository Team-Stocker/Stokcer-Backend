package com.teamStocker.domain.diary.service;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.Like;
import com.teamStocker.domain.diary.domain.repository.LikeRepository;
import com.teamStocker.domain.diary.facade.DiaryFacade;
import com.teamStocker.domain.diary.facade.LikeFacade;
import com.teamStocker.domain.user.domain.User;
import com.teamStocker.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final DiaryFacade diaryFacade;
    private final UserFacade userFacade;
    private final LikeFacade likeFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public void createLike(Long id) {
        User user = userFacade.getCurrentUser();
        Diary diary = diaryFacade.findDiaryById(id);

        likeFacade.validateCreateLike(user, diary);

        likeRepository.save(Like.createLike(user, diary));
    }

    @Transactional
    public void deleteLike(Long id) {
        User user = userFacade.getCurrentUser();
        Diary diary = diaryFacade.findDiaryById(id);

        likeRepository.deleteByUserAndDiary(user, diary);
    }
}
