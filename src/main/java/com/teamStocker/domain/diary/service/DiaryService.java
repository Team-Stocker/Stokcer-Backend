package com.teamStocker.domain.diary.service;

import com.teamStocker.domain.diary.domain.repository.DiaryRepository;
import com.teamStocker.domain.diary.facade.DiaryFacade;
import com.teamStocker.domain.diary.presentation.dto.request.CreateDiaryRequest;
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
}
