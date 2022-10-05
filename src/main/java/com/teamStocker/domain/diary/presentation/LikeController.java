package com.teamStocker.domain.diary.presentation;

import com.teamStocker.domain.diary.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "좋아요", description = "좋아요 관련 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/diary/like/{id}")
public class LikeController {

    private final LikeService likeService;

    @Operation(summary = "좋아요 누르기")
    @PostMapping
    public void createLike(@PathVariable Long id) {
        likeService.createLike(id);
    }

    @Operation(summary = "좋아요 누르기 취소")
    @DeleteMapping
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
    }
}
