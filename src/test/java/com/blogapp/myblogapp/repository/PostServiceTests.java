package com.blogapp.myblogapp.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import com.blogapp.myblogapp.dto.PostDto;
import com.blogapp.myblogapp.entities.Categorie;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.entities.Visibility;
import com.blogapp.myblogapp.services.PostServiceImpl;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/myTestDB"
})
class PostServiceTests {

    @Autowired
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postServiceImpl;

    @Test
    void Post_FindAll_returnsList() {

        List<PostDto> allPosts = postServiceImpl.findAllPosts();

        Assertions.assertThat(allPosts).asList();
        Assertions.assertThat(allPosts).isNotNull();

    }

    @Test
    void Post_Create_ReturnsCreatedPost() {

        // Arrange
        Post post = Post.builder().title("Holla").categorie(Categorie.SPORT)
                .visibility(Visibility.PUBLIC).build();

        // Act
        PostDto createdPost = postServiceImpl.createPost(post);

        // Assert
        Assertions.assertThat(createdPost).isNotNull();
        Assertions.assertThat(createdPost.getId()).isGreaterThan(0);
    }

    @Test
    void Post_Save_ReturnsSavedPost() {

        // Arrange
        Post post = Post.builder().title("pokemon").categorie(Categorie.SPORT)
                .visibility(Visibility.PUBLIC).build();

        // Act
        PostDto savedPost = postServiceImpl.savePost(post);

        // Assert
        Assertions.assertThat(savedPost).isNotNull();
        Assertions.assertThat(savedPost.getId()).isGreaterThan(0);

    }

    @Test
    void Post_Update_ReturnsUpdatedPost() {
        // Arrange
        Post post = Post.builder().id(1).title("update").categorie(Categorie.SPORT)
                .visibility(Visibility.PUBLIC).build();

        // Act
        Boolean updatedPost = postServiceImpl.updatePost(post);

        // Assert
        Assertions.assertThat(updatedPost).isTrue();
        Assertions.assertThat(updatedPost).isNotNull();

    }

}
