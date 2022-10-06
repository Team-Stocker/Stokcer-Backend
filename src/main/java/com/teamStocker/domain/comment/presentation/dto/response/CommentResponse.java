package com.teamStocker.domain.comment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {
    private final String nickname;
    private final String content;
}
