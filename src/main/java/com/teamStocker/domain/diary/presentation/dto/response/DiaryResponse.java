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

    private Category category;

    private int rate;

    private int numberOfLikes;

    public static DiaryResponse of(Diary diary) {
        return DiaryResponse.builder()
                .id(diary.getId())
                .title(diary.getTitle())
                .category(diary.getCategory())
                .rate(diary.getRate())
                .numberOfLikes(diary.getLikes().size())
                .build();
    }
}
