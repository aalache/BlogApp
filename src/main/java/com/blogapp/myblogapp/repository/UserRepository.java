package com.blogapp.myblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

}
