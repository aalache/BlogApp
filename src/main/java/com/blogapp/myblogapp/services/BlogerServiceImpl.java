package com.blogapp.myblogapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogapp.myblogapp.dto.BlogerDto;
import com.blogapp.myblogapp.dto.DtoMapping;
import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.entities.Role;
import com.blogapp.myblogapp.entities.User;
import com.blogapp.myblogapp.repository.UserRepository;

public class BlogerServiceImpl implements IBlogerService {

    @Autowired
    private UserRepository userRepository;

    private DtoMapping dtoMapping;

    public BlogerServiceImpl() {
        this.dtoMapping = new DtoMapping();
    }

    @Override
    public void friendRequest(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'friendRequest'");
    }

    // ? User Authentification
    @Override
    public User authenticate(String username, String password) throws Exception {
        User user = userRepository.findByUserName(username).orElse(null);

        if (user == null) {
            throw new Exception("Invalid Username");
        }
        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid Password");
        }
        return user;
    }

    // ? User Crud operations

    public boolean isUsernameUnique(String username) {
        User user = userRepository.findByUserName(username).orElse(null);
        if (user == null)
            return true;
        else
            return false;
    }

    public boolean isEmailUnique(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null)
            return true;
        else
            return false;
    }

    @Override
    public Boolean saveBloger(User user) {
        if (user != null && isUsernameUnique(user.getUserName()) && isEmailUnique(user.getEmail())) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateBloger(User user) {

        if (user != null) {
            userRepository.save(user);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteBloger(Long id) {

        Bloger userToDelete = (Bloger) userRepository.findById(id).orElse(null);

        if (userToDelete != null) {
            userRepository.delete(userToDelete);
            return true;
        } else
            return false;
    }

    // ? filters

    @Override
    public List<BlogerDto> findAllBlogers() {
        List<User> users = userRepository.findAll();
        List<BlogerDto> allUsers = new ArrayList<BlogerDto>();
        if (!users.isEmpty()) {
            for (User user : users) {
                allUsers.add(dtoMapping.mapToBlogerDto((Bloger) user));
            }
        }
        return allUsers;
    }

    @Override
    public BlogerDto findById(Long id) {
        Bloger res = (Bloger) userRepository.findById(id).orElse(null);
        if (res != null)
            return dtoMapping.mapToBlogerDto(res);
        else
            return null;
    }

    @Override
    public BlogerDto findByUserName(String userName) {
        Bloger res = (Bloger) userRepository.findByUserName(userName).orElse(null);
        if (res != null)
            return dtoMapping.mapToBlogerDto(res);
        else
            return null;
    }

    @Override
    public BlogerDto findByEmail(String email) {
        Bloger res = (Bloger) userRepository.findByEmail(email).orElse(null);
        if (res != null)
            return dtoMapping.mapToBlogerDto(res);
        else
            return null;
    }

}
