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

    @GetMapping(value = "/posts")
    public String index(Model model) {

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

        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);

        return "blogs";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
    
      // Endpoint to like a post
    @PostMapping("/{postId}/like")
    public ResponseEntity<Boolean> likePost(@PathVariable Long postId) {
        Boolean result = postService.likePost(postId);
        if (result) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    // Endpoint to create a new post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody Post post, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        PostDto postDto = postService.createPost(post);
        return ResponseEntity.ok(postDto);
    }

    // Endpoint to save a post
    @PutMapping
    public ResponseEntity<PostDto> savePost(@Valid @RequestBody Post post, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        PostDto postDto = postService.savePost(post);
        return ResponseEntity.ok(postDto);
    }

    // Endpoint to update a post
    @PutMapping("/{postId}")
    public ResponseEntity<Boolean> updatePost(@PathVariable Long postId, @Valid @RequestBody Post post, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(false);
        }
        post.setId(postId); // Ensure the ID is set for updating
        Boolean updated = postService.updatePost(post);
        return ResponseEntity.ok(updated);
    }

    // Endpoint to delete a post
    @DeleteMapping("/{postId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long postId) {
        Boolean deleted = postService.deletePost(postId);
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }
}

}
