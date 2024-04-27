package com.blogapp.myblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
