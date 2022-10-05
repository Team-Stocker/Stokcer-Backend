package com.teamStocker.domain.image.service;

import com.teamStocker.domain.image.controller.dto.ImageUrlResponse;
import com.teamStocker.infrastructure.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final S3Facade s3Facade;

    @Transactional(readOnly = true)
    public ImageUrlResponse imageUpload(List<MultipartFile> images) {
        List<String> image = images.stream()
                .map(s3Facade::uploadImage)
                .collect(Collectors.toList());

        return new ImageUrlResponse(image);
    }
}