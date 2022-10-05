package com.teamStocker.domain.diary.presentation;

import com.teamStocker.domain.diary.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary/like/{id}")
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public void createLike(@PathVariable Long id) {
        likeService.createLike(id);
    }

    @DeleteMapping
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteLiek(id);
    }
}
