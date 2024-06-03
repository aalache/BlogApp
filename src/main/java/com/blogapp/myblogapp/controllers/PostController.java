package com.blogapp.myblogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogapp.myblogapp.dto.PostDto;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.services.IBlogerService;
import com.blogapp.myblogapp.services.IpostService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("app/")

public class PostController {
    @Autowired
    private IpostService postService;

    @Autowired
    private IBlogerService blogerService;

    @GetMapping(value = "/posts")
    public String Posts(Model model, HttpSession session) {

        // Bloger bloger = Bloger.builder().build();
        // bloger.setUserName("@zakariae");
        // bloger.setEmail("zakariae@gmail.com");
        // bloger.setPassword("passwd321");

        // blogerService.saveBloger(bloger);

        // Post post1 = Post.builder()
        // .categorie(Categorie.LIFESTYLE)
        // .content("this is the my first Post ,it's about Life Style ...")
        // .likes(255)
        // .title("How to ?")
        // .visibility(Visibility.PUBLIC)
        // .id(1)
        // .build();

        // Post post1 = Post.builder()
        // .categorie(Categorie.LIFESTYLE)
        // .content("this is the forth post for today...")
        // .likes(255)
        // .title("Post 4")
        // .visibility(Visibility.PRIVATE)
        // .id(1)
        // .build();

        // post1.setAuthor(bloger);

        // postService.createPost(post1);

        String sessionData = (String) session.getAttribute("sessionUsername");
        model.addAttribute("sessionUsername", sessionData);

        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);

        return "blogs";
    }

    @GetMapping(value = "/posts/create_post")
    public String createPost(Model model, HttpSession session) {

        Post newPost = new Post();
        model.addAttribute("newPost", newPost);

        return "newPost";
    }
}