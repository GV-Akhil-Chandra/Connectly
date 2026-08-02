package com.connectly.uploader_service.Controller;

import com.connectly.uploader_service.Service.UploaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class UploaderController {

    private final UploaderService uploaderService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("image") MultipartFile multipartFile){
        String url = uploaderService.upload(multipartFile);
        return new ResponseEntity<>(url, HttpStatus.OK);
    }
}
