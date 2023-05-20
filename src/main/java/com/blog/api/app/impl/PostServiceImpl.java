package com.blog.api.app.impl;


import com.blog.api.app.Exception.ResourceNotFoundException;
import com.blog.api.app.entity.Category;
import com.blog.api.app.entity.Post;
import com.blog.api.app.entity.User;
import com.blog.api.app.repository.CategoryRepository;
import com.blog.api.app.repository.PostRepository;
import com.blog.api.app.repository.UserRepository;
import com.blog.api.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Post createPost(Post post, Integer userId, Integer categoryId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("userid", "id", userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));
        post.setImageName(" ");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post post1 = this.postRepository.save(post);

        return post1;
    }

    @Override
    public Post getPostById(Integer postId) {
        Post post2 = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        List<Post> post3 = this.postRepository.findAll();
        return post3;
    }

    @Override
    public Post updatePost(Post post, Integer postId) {

      Post post4 =  this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
      post4.setTitle(post.getTitle());
      post4.setContent(post.getContent());
      post4.setAddedDate(post.getAddedDate());

       return  this.postRepository.save(post4);
    }

    @Override
    public void deletePost(Integer postId) {

   Post post5   =this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));
        this.postRepository.delete(post5);
    }

    @Override
    public Post getPostByUserId(Integer userId ) {

       User user1=  this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
       Post post6  = this.postRepository.findByUser(user1);
        return post6;
    }

    @Override
    public Post getPostByCategoryId(Integer categoryId) {

    Category category1    = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));

       Post post7 = this.postRepository.findByCategory(category1);
        return post7 ;
    }
}
