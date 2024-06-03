package com.blogapp.myblogapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogapp.myblogapp.dto.BlogerDto;
import com.blogapp.myblogapp.services.IBlogerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("app/")
public class SessionController {

    @Autowired
    private IBlogerService blogerService;

    @GetMapping("/login")
    public String loginPage() {
        return "signIn";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
            Model model) {
        try {
            BlogerDto user = blogerService.authenticate(username, password);
            session.setAttribute("sessionUsername", user.getUsername());
            return "redirect:/app/posts";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/app/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/app/login";
    }

}
