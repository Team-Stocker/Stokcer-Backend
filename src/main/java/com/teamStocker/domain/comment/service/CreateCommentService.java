package com.teamStocker.domain.comment.service;

import com.teamStocker.domain.comment.domain.Comment;
import com.teamStocker.domain.comment.domain.repository.CommentRepository;
import com.teamStocker.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.facade.DiaryFacade;
import com.teamStocker.domain.user.domain.User;
import com.teamStocker.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCommentService {

    private final UserFacade userFacade;
    private final DiaryFacade diaryFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public void createComment(Long diaryId, CreateCommentRequest request) {

        User user = userFacade.getCurrentUser();
        Diary diary = diaryFacade.findDiaryById(diaryId);

        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .user(user)
                        .diary(diary)
                        .build()
        );
    }
}
