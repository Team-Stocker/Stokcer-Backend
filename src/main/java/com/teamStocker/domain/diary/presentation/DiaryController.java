package com.teamStocker.domain.diary.presentation;

import com.teamStocker.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.teamStocker.domain.diary.presentation.dto.response.DiaryResponse;
import com.teamStocker.domain.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public void createDiary(@RequestBody @Valid CreateDiaryRequest request) {
        diaryService.createDiary(request);
    }

    @PutMapping("/{id}")
    public void updateDiary(
            @PathVariable Long id,
            @RequestBody @Valid CreateDiaryRequest request
    ) {
        diaryService.updateDiary(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
    }

    @GetMapping
    public List<DiaryResponse> findAllDiary() {
        return diaryService.findAllDiary();
    }
}
