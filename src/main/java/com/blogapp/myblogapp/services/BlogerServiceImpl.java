package com.blogapp.myblogapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogapp.myblogapp.dto.BlogerDto;
import com.blogapp.myblogapp.dto.DtoMapping;
import com.blogapp.myblogapp.entities.Bloger;
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

    @Override
    public BlogerDto AddBloger(User user) {
        if (user != null)
            return saveBloger(user);
        else
            return null;
    }

    @Override
    public BlogerDto saveBloger(User user) {
        Bloger userIfExist = (Bloger) userRepository.findByUserName(user.getUserName()).orElse(null);

        if (userIfExist == null) {
            Bloger newUser = (Bloger) userRepository.save(user);
            return dtoMapping.mapToBlogerDto(newUser);
        } else {
            System.out.println("User already exist !!");
            return null;
        }
    }

    @Override
    public Boolean updateBloger(User user) {

        Bloger userToUpdate = (Bloger) userRepository.findById(user.getId()).orElse(null);

        if (userToUpdate != null) {
            saveBloger(userToUpdate);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteBloger(Long userId) {

        Bloger userToDelete = (Bloger) userRepository.findById(userId).orElse(null);

        if (userToDelete != null) {
            userRepository.delete(userToDelete);
            return true;
        } else
            return false;
    }

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
        return dtoMapping.mapToBlogerDto(res);
    }

    @Override
    public BlogerDto findByUserName(String userName) {
        Bloger res = (Bloger) userRepository.findByUserName(userName).orElse(null);
        return dtoMapping.mapToBlogerDto(res);
    }

    @Override
    public BlogerDto findByEmail(String email) {
        Bloger res = (Bloger) userRepository.findByEmail(email).orElse(null);
        return dtoMapping.mapToBlogerDto(res);
    }

}
