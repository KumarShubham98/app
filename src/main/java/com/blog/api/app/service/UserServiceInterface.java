package com.blog.api.app.service;

import com.blog.api.app.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterface {


    public User addUser(User user);


    User updateUser(User user);


    List<User> getallUser();


    User getallUserbyid(Long useridL);

    User deleteUserbyid(Long deleteuseridL);


}
