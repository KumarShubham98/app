package com.blog.api.app.impl;

import com.blog.api.app.Exception.ResourceNotFoundException;
import com.blog.api.app.entity.User;
import com.blog.api.app.repository.UserRepository;
import com.blog.api.app.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @Override
    public User createUser(User user) {
       User user1 =userRepository.save(user);
      return user1;

    }

    @Override
    public User getUserById(Integer userId) {
        User user2  =  userRepository.findById(userId).orElseThrow(() ->new ResourceNotFoundException("User","Id",userId));
        return user2 ;
    }

    @Override
    public List<User> getAllUser() {

      List<User> user3 = this.userRepository.findAll();
        return user3;
    }

    @Override
    public User updateUser(User user ,Integer userId) {

       User user2 = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

        user2.setUserId(user.getUserId());
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());

        User updateUser= userRepository.save(user2);
        return updateUser;
    }

    @Override
    public void deleteUser(Integer userId) {

   User user =  this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
          userRepository.delete(user);

    }
}
