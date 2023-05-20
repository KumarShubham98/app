package com.blog.api.app.controller;


import com.blog.api.app.entity.Post;
import com.blog.api.app.entity.User;
import com.blog.api.app.impl.PostServiceImpl;
import com.blog.api.app.payloads.ApiResponse;
import com.blog.api.app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestcontroller {

    @Autowired
    private PostServiceImpl postServiceImpl;

    @PostMapping("/user/{userId}/category/{catId}/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post,@PathVariable("userId") Integer userId,
                                           @PathVariable("catId") Integer categoryId){

      Post post1  =  this.postServiceImpl.createPost(post,userId,categoryId);
        return new ResponseEntity<Post>(post1, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable ("id") Integer postId){
        Post posts  =  this.postServiceImpl.getPostById(postId);
        return new ResponseEntity<Post>(posts, HttpStatus.OK);
    }

    @GetMapping("/getAllPost")
    public ResponseEntity<List<Post>> getAllPost(){
        List<Post> post4  =  this.postServiceImpl.getAllPost();
        return new ResponseEntity<List<Post>>(post4, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ApiResponse>  deletePost(@PathVariable ("id") Integer postId){
         this.postServiceImpl.deletePost(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("post is deleted",true),HttpStatus.OK) ;


    }



    @PutMapping("/updateById/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post,@PathVariable ("id") Integer postid){
        Post post4  =  this.postServiceImpl.updatePost(post,postid);
        return new ResponseEntity<Post>(post4, HttpStatus.CREATED);
    }


    @GetMapping("/getPostByUserId/{id}")
    public ResponseEntity<Post> getPostByUserId(@PathVariable ("id") Integer userId){
        Post post3  =  this.postServiceImpl.getPostByUserId(userId);
        return new ResponseEntity<Post>(post3, HttpStatus.OK);
    }

    @GetMapping("/getPostByCategoryId/{id}/postId{id}")
    public ResponseEntity<Post> getPostByCategoryId(@PathVariable ("id") Integer postId){
        Post posts  =  this.postServiceImpl.getPostByCategoryId(postId);
        return new ResponseEntity<Post>(posts, HttpStatus.OK);
    }
}
