package com.blog.api.app.controller;

import com.blog.api.app.entity.User;
import com.blog.api.app.repository.UserRepository;
import com.blog.api.app.service.UserService;
import lombok.Getter;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){
         User users  =  this.userService.createUser(user);
          return new ResponseEntity<User>(users, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable ("id") Integer userid){
        User users  =  this.userService.getUserById(userid);
        return new ResponseEntity<User>(users, HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users  =  this.userService.getAllUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


   @DeleteMapping("/deleteById/{id}")
   public ResponseEntity<User> deleteUser(@PathVariable ("id") Integer userid){
        this.userService.deleteUser(userid);
       return new ResponseEntity<User>(HttpStatus.OK);


   }

   @PutMapping("/updateById/{id}")
   public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable ("id") Integer userid){
       User users  =  this.userService.updateUser(user,userid);
       return new ResponseEntity<User>(users, HttpStatus.CREATED);
   }



}
