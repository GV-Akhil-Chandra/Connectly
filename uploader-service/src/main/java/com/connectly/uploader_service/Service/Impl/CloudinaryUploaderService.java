package com.connectly.uploader_service.Service.Impl;

import com.cloudinary.Cloudinary;
import com.connectly.uploader_service.Service.UploaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CloudinaryUploaderService implements UploaderService {
    private final Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile file) {
        Map uploadResult;
        try {
            uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return uploadResult.get("secure_url").toString();
    }
}
