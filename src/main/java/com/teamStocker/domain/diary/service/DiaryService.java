package com.teamStocker.domain.diary.service;

import com.teamStocker.domain.comment.domain.Comment;
import com.teamStocker.domain.comment.domain.repository.CommentRepository;
import com.teamStocker.domain.comment.presentation.dto.response.CommentResponse;
import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.repository.DiaryRepository;
import com.teamStocker.domain.diary.domain.type.Category;
import com.teamStocker.domain.diary.facade.DiaryFacade;
import com.teamStocker.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.teamStocker.domain.diary.presentation.dto.response.DiaryDetailResponse;
import com.teamStocker.domain.diary.presentation.dto.response.DiaryResponse;
import com.teamStocker.domain.user.domain.User;
import com.teamStocker.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final DiaryFacade diaryFacade;

    @Transactional
    public void createDiary(CreateDiaryRequest request) {
        User user = userFacade.getCurrentUser();
        diaryRepository.save(request.toEntity().setRelation(user));
    }

    @Transactional
    public void updateDiary(Long id, CreateDiaryRequest request) {
        diaryFacade.findDiaryById(id)
                .update(
                        request.getTitle(),
                        request.getContent(),
                        request.getCategory(),
                        request.getRate()
                );
    }

    @Transactional
    public void deleteDiary(Long id) {
        diaryRepository.delete(diaryFacade.findDiaryById(id));
    }

    @Transactional(readOnly = true)
    public List<DiaryResponse> findAllDiary() {
        return diaryRepository.findAll().stream()
                .map(DiaryResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DiaryDetailResponse findDiaryDetail(Long id) {
        Diary diary = diaryFacade.findDiaryById(id);

        List<CommentResponse> diaryResponses = commentRepository.findAllByDiary(diary)
                .stream()
                .map(this::commentBuilder)
                .collect(Collectors.toList());

        return DiaryDetailResponse.builder()
                .title(diary.getTitle())
                .content(diary.getContent())
                .category(diary.getCategory())
                .rate(diary.getRate())
                .numberOfLikes(diary.getLikes().size())
                .commentResponseList(diaryResponses)
                .build();
    }

    @Transactional(readOnly = true)
    public List<DiaryResponse> findAllDiaryByCategory(Category category) {
        return diaryRepository.findAllByCategory(category).stream()
                .map(DiaryResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<DiaryResponse> findTop3GreatestDiary() {
        return diaryRepository.findGreatestDiary().stream()
                .limit(3)
                .map(DiaryResponse::of)
                .collect(Collectors.toList());
    }

    private CommentResponse commentBuilder(Comment comment) {
        User user = comment.getUser();
        return CommentResponse.builder()
                .nickname(user.getNickName())
                .content(comment.getContent())
                .build();
    }
}
