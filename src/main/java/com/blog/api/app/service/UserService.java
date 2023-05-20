package com.blog.api.app.service;

import com.blog.api.app.entity.User;
import com.blog.api.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {



     public User createUser(User user);

     public  User getUserById(Integer userId);
     public  List<User> getAllUser();

     public User updateUser(User user ,Integer userId);

    public  void deleteUser(Integer userId);



}
