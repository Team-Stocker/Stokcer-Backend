package com.teamStocker.domain.comment.presentation;

import com.teamStocker.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.teamStocker.domain.comment.service.CreateCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "댓글", description = "댓글 관련 API입니다.")
@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;

    @Operation(summary = "댓글 생성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{diary-id}")
    public void createComment(@PathVariable(name = "diary-id") Long lifeId, @RequestBody @Valid CreateCommentRequest request) {
        createCommentService.createComment(lifeId, request);
    }
}
