package com.blogapp.myblogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.blogapp.myblogapp.dto.BlogDto;
import com.blogapp.myblogapp.services.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String listBlogs(Model model) {
        List<BlogDto> blogs = blogService.findAllBlogs();
        model.addAttribute("blogs", blogs);
        return "blogsList";
    }

}
