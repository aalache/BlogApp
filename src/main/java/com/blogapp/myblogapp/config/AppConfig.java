package com.blogapp.myblogapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blogapp.myblogapp.services.BlogerServiceImpl;
import com.blogapp.myblogapp.services.IBlogerService;
import com.blogapp.myblogapp.services.IpostService;
import com.blogapp.myblogapp.services.PostServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public IBlogerService blogerService() {
        return new BlogerServiceImpl();
    }

    @Bean
    public IpostService postService() {
        return new PostServiceImpl();
    }
}