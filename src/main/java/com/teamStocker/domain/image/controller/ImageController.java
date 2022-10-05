package com.teamStocker.domain.image.controller;


import com.teamStocker.domain.image.controller.dto.ImageUrlResponse;
import com.teamStocker.domain.image.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "이미지", description = "이미지 관련 API 입니다.")
@RequiredArgsConstructor
@RequestMapping("/image")
@RestController
public class ImageController {

    private final ImageService imageService;

    @Operation(summary = "이미지 업로드")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ImageUrlResponse saveImage(@RequestPart List<MultipartFile> images) {
        return imageService.imageUpload(images);
    }
}
