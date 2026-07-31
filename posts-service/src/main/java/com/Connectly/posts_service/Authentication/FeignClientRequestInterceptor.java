package com.Connectly.posts_service.Authentication;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignClientRequestInterceptor implements RequestInterceptor {

    Long userId = AuthContextHolder.getCurrentUserId();
    @Override
    public void apply(RequestTemplate template){
        if(userId != null){
            template.header("X-User-Id", userId.toString());
        }
    }
}
