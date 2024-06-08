package com.blogapp.myblogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogapp.myblogapp.dto.PostDto;
import com.blogapp.myblogapp.entities.Categorie;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.services.IpostService;
import com.blogapp.myblogapp.entities.Visibility;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("app/")

public class PostController {
    @Autowired
    private IpostService postService;

    // ? Render All Posts
    @GetMapping(value = "/posts")
    public String Posts(Model model, HttpSession session) {

        String sessionData = (String) session.getAttribute("sessionUsername");
        model.addAttribute("sessionUsername", sessionData);

        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);

        return "blogs";
    }

    // ? Render Form to Create new Post
    @GetMapping(value = "/posts/create_post")
    public String createPostForm(Model model) {

        Post newPost = new Post();
        model.addAttribute("newPost", newPost);
        model.addAttribute("visibilityOps", Visibility.values());
        model.addAttribute("categoryOps", Categorie.values());

        return "newPost";
    }

    // ? Handle requests from createPostForm and save the new posts
    @PostMapping("/posts/create_post")
    public String createPost(@Valid @ModelAttribute("newPost") Post post, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/app/posts/create_post";
        }
        postService.createPost(post);
        return "redirect:/app/posts";

    }

    // ? Render Form to edit post details
    @GetMapping("/posts/edit_post/{id}")
    public String editPostForm(@PathVariable("id") Long postId, Model model) {

        PostDto currentPost = postService.findById(postId);
        model.addAttribute("currentPost", currentPost);
        model.addAttribute("visibilityOps", Visibility.values());
        model.addAttribute("categoryOps", Categorie.values());
        return "editPost";
    }

    // ? Handle requests from editPostForm and save edited Post
    @PostMapping("/posts/save")
    public String postMethodName(@ModelAttribute("currentPost") Post post) {

        postService.savePost(post);
        return "redirect:/app/posts";
    }

    // ? handle requests from delete form and delete the post selected
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable() Long postId, Model model) {

        postService.deletePost(postId);
        return "redirect:/app/posts";

    }

}