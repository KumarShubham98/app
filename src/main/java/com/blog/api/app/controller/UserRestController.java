package com.blog.api.app.controller;


import com.blog.api.app.entity.User;
import com.blog.api.app.repository.UserRepository;
import com.blog.api.app.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceInterface userServiceInterface;



    @PostMapping("/save")
    public ResponseEntity<User> addUser(@RequestBody  User user){
      User saveuser  = userServiceInterface.addUser(user);
      return new ResponseEntity<User>(saveuser, HttpStatus.ACCEPTED);

    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody  User user){
        User saveuser  = userServiceInterface.updateUser(user);
        return new ResponseEntity<User>(saveuser, HttpStatus.ACCEPTED);

    }

    @GetMapping("getall")
    public ResponseEntity<List<User>> getallUser(){
       List<User> getall= userServiceInterface.getallUser();
       return new ResponseEntity<List<User>>(getall,HttpStatus.OK);
    }


    @GetMapping("/getall/{userid}")
    public ResponseEntity<User> getallUserbyid(@PathVariable("userid") Long useridL){
        User getuserbyid= userServiceInterface.getallUserbyid(useridL);
        return new ResponseEntity<User>(getuserbyid,HttpStatus.OK);
    }


    @DeleteMapping("/getall/{deleteuserid}")
    public ResponseEntity<User> deleteUserbyid(@PathVariable("deleteuserid") Long deleteuseridL){
         userServiceInterface.deleteUserbyid(deleteuseridL);
        return  new ResponseEntity<>(HttpStatus.OK);
    }



}
