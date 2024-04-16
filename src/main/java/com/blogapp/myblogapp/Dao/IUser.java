package com.blogapp.myblogapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.User;

public interface IUser extends JpaRepository<User, Long> {

}
