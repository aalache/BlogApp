package com.blogapp.myblogapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.services.IBlogerService;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BloggerController {

    @Autowired
    private IBlogerService blogerService;

    @GetMapping("/register")
    public String getMethodName(Model model) {
        Bloger user = new Bloger();
        model.addAttribute("user", user);
        return "signUp";
    }

    @PostMapping("/register")
    public String createBlogger(@Valid Bloger bloger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bloggerForm"; // return the form view with errors
        }
        blogerService.saveBloger(bloger);
        return "redirect:/bloggers";
    }
}