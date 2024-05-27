package com.blogapp.myblogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blogapp.myblogapp.dto.BlogerDto;
import com.blogapp.myblogapp.dto.PostDto;
import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.entities.Categorie;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.entities.Visibility;
import com.blogapp.myblogapp.services.IBlogerService;
import com.blogapp.myblogapp.services.IpostService;

@Controller
public class PostController {
    @Autowired
    private IpostService postService;

    @Autowired
    private IBlogerService blogerService;

    @GetMapping(value = "/")
    public String index(Model model) {

        Bloger bloger = Bloger.builder().build();
        bloger.setUserName("@zakariae");
        bloger.setEmail("zakariae@gmail.com");
        bloger.setPassword("passwd321");

        blogerService.AddBloger(bloger);

        Post post1 = Post.builder()
                .categorie(Categorie.LIFESTYLE)
                .content("this is the my first Post ,it's about Life Style ...")
                .likes(255)
                .title("How to ?")
                .visibility(Visibility.PUBLIC)
                .build();

        postService.createPost(post1);

        post1.setAuthor(bloger);
        postService.savePost(post1);

        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        List<BlogerDto> blogers = blogerService.findAllBlogers();

        BlogerDto id = blogerService.findById(1L);
        model.addAttribute("id", id);

        model.addAttribute("blogers", blogers);
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
