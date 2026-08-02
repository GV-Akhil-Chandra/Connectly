package com.connectly.uploader_service.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface UploaderService {
    String upload(MultipartFile file);
}
