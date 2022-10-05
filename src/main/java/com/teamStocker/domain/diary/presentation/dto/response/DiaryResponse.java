package com.teamStocker.domain.diary.presentation.dto.response;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.type.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiaryResponse {

    private Long id;

    private String title;

    private String content;

    private Category category;

    private int rate;

    public static DiaryResponse of(Diary diary) {
        return DiaryResponse.builder()
                .id(diary.getId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .category(diary.getCategory())
                .rate(diary.getRate())
                .build()
    }
}
