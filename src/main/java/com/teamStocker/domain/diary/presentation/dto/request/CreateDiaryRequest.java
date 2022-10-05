package com.teamStocker.domain.diary.presentation.dto.request;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.type.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateDiaryRequest {

    private String title;

    private String content;

    private Category category;

    private int rate;

    public Diary toEntity() {
        return Diary.builder()
                .title(title)
                .content(content)
                .category(category)
                .rate(rate)
                .build();
    }
}
