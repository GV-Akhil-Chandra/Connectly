package com.connectly.uploader_service.Config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class UploaderConfig {
    @Value("${cloudinary.cloud-name}")
    private String cloud_name;

    @Value("${cloudinary.api-key}")
    private String api_key;

    @Value("${cloudinary.api-secret}")
    private String api_secret;


    // config for getting cloudinary object with api secrets
    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> apiMap = Map.of(
                "cloud_name", cloud_name,
                "api_key", api_key,
                "api_secret", api_secret
        );
        return new Cloudinary(apiMap);
    }
}
