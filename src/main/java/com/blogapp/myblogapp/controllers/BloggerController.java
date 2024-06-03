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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("app/")

public class BloggerController {

    @Autowired
    private IBlogerService blogerService;

    @GetMapping("/register")
    public String getMethodName(Model model) {
        Bloger newUser = new Bloger();
        model.addAttribute("newUser", newUser);
        return "signUp";
    }

    @PostMapping("/register")
    public String createBlogger(@Valid @ModelAttribute("newUser") Bloger newUser) {

        Boolean isUnique = blogerService.saveBloger(newUser);
        if (isUnique) {
            System.out.println("********** " + "User added successfuly :)" + "*********");
            return "redirect:/posts";
        } else {
            String erroMessage = "Username or Email already exist !!!";
            System.out.println("********** " + erroMessage + "*********");
            return "signUp";
        }
    }
}