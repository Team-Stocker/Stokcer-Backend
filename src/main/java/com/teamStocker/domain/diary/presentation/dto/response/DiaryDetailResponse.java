package com.teamStocker.domain.diary.presentation.dto.response;

import com.teamStocker.domain.comment.presentation.dto.response.CommentResponse;
import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.type.Category;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class DiaryDetailResponse {

    private final String title;

    private final String content;

    private final Category category;

    private final int rate;

    private final int numberOfLikes;

    private  final List<CommentResponse> commentResponseList;
}
