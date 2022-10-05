package com.teamStocker.domain.diary.presentation.dto.response;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.type.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiaryDetailResponse {

    private String title;

    private String content;

    private Category category;

    private int rate;

    private int numberOfLikes;

    public static DiaryDetailResponse of(Diary diary) {
        return DiaryDetailResponse.builder()
                .title(diary.getTitle())
                .content(diary.getContent())
                .category(diary.getCategory())
                .rate(diary.getRate())
                .numberOfLikes(diary.getLikes().size())
                .build();
    }
}
