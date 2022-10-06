package com.teamStocker.domain.diary.presentation;

import com.teamStocker.domain.diary.domain.type.Category;
import com.teamStocker.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.teamStocker.domain.diary.presentation.dto.response.DiaryDetailResponse;
import com.teamStocker.domain.diary.presentation.dto.response.DiaryResponse;
import com.teamStocker.domain.diary.service.DiaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "일기", description = "일기 관련 API입니다.")
@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @Operation(summary = "일기 생성")
    @PostMapping
    public void createDiary(@RequestBody @Valid CreateDiaryRequest request) {
        diaryService.createDiary(request);
    }

    @Operation(summary = "일기 수정")
    @PutMapping("/{id}")
    public void updateDiary(
            @PathVariable Long id,
            @RequestBody @Valid CreateDiaryRequest request
    ) {
        diaryService.updateDiary(id, request);
    }

    @Operation(summary = "일기 삭제")
    @DeleteMapping("/{id}")
    public void deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
    }

    @Operation(summary = "일기 전체 리스트 조회")
    @GetMapping
    public List<DiaryResponse> findAllDiary() {
        return diaryService.findAllDiary();
    }

    @Operation(summary = "일기 상세보기 조회")
    @GetMapping("/{id}")
    public DiaryDetailResponse findDiaryDetail(@PathVariable Long id) {
        return diaryService.findDiaryDetail(id);
    }

    @Operation(summary = "일기 카테코리 별로 조회하기")
    @GetMapping("/category")
    public List<DiaryResponse> findAllDiaryByCategory(@RequestParam Category category) {
        return diaryService.findAllDiaryByCategory(category);
    }

    @Operation(summary = "좋아요 가장 많은 일기 3개 조회")
    @GetMapping("/like")
    public List<DiaryResponse> findTop3GreatestDiary() {
        return diaryService.findTop3GreatestDiary();
    }

    @Operation(summary = "상승 일기 3개 조회")
    @GetMapping("/asc")
    public List<DiaryResponse> findTop3RateAsc() {
        return diaryService.findTop3RateAsc();
    }

    @Operation(summary = "하락 일기 3개 조회")
    @GetMapping("/desc")
    public List<DiaryResponse> findTop3RateDesc() {
        return diaryService.findTop3RateDesc();
    }
}
