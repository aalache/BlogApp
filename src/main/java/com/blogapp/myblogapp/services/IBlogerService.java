package com.blogapp.myblogapp.services;

import java.util.List;

import com.blogapp.myblogapp.dto.BlogerDto;
import com.blogapp.myblogapp.entities.User;

public interface IBlogerService {

    List<BlogerDto> findAllBlogers();

    // ? search filters
    BlogerDto findById(Long id);

    BlogerDto findByUserName(String userName);

    BlogerDto findByEmail(String email);

    // ? Auth
    BlogerDto authenticate(String username, String password) throws Exception;

    // ? Crud operations

    void friendRequest(Long userId);

    Boolean saveBloger(User user);

    Boolean updateBloger(User user);

    Boolean deleteBloger(Long id);
}
