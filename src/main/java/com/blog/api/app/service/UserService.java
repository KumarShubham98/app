package com.blog.api.app.service;

import com.blog.api.app.entity.User;
import com.blog.api.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        User saveduser = userRepository.save(user);
        return saveduser;

    }

    @Override
    public User updateUser(User user) {
        User saveduser = userRepository.save(user);
        return saveduser;
    }

    @Override
    public List<User> getallUser() {

       List<User> getall =userRepository.findAll();
        return getall;
    }

    @Override
    public User getallUserbyid(Long useridL) {

     User   usergetbyid=userRepository.findById(useridL).get();
        return usergetbyid;
    }

    @Override
    public User deleteUserbyid(Long deleteuseridL) {
       userRepository.deleteById(deleteuseridL);
        return null;
    }




}
