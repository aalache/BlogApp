package com.blogapp.myblogapp.services;

import java.util.List;

import com.blogapp.myblogapp.dto.BlogerDto;
import com.blogapp.myblogapp.entities.User;

public interface IBlogerService {

    List<BlogerDto> findAllBlogers();

    BlogerDto findById(Long id);

    BlogerDto findByUserName(String userName);

    BlogerDto findByEmail(String email);

    void friendRequest(Long userId);

    BlogerDto AddBloger(User user);

    BlogerDto saveBloger(User user);

    Boolean updateBloger(User user);

    Boolean deleteBloger(Long userId);
}
