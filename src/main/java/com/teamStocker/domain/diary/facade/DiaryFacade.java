package com.teamStocker.domain.diary.facade;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.repository.DiaryRepository;
import com.teamStocker.domain.diary.exception.DiaryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiaryFacade {

    private final DiaryRepository diaryRepository;

    public Diary findDiaryById(Long id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> DiaryNotFoundException.EXCEPTION);
    }
}
