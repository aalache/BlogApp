package com.blogapp.myblogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.blogapp.myblogapp.dto.PostDto;
import com.blogapp.myblogapp.services.IpostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private IpostService postService;

    @GetMapping({ "", "/" })
    public String showPostList(Model model) {
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

}
