package com.teamStocker.domain.image.controller;


import com.teamStocker.domain.image.controller.dto.ImageUrlResponse;
import com.teamStocker.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/image")
@RestController
public class ImageController {

    private final ImageService imageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ImageUrlResponse saveImage(@RequestPart List<MultipartFile> images) {
        return imageService.imageUpload(images);
    }
}
