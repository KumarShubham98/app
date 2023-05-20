package com.blog.api.app.service;


import com.blog.api.app.entity.Category;
import com.blog.api.app.entity.Post;
import com.blog.api.app.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    public Post createPost(Post post,Integer userId,Integer categoryId);

    public Post  getPostById(Integer postId);

    public List<Post> getAllPost();

    public Post   updatePost(Post post,Integer postId);

    public void  deletePost(Integer postId);


    public Post getPostByUserId( Integer userId);


    public Post getPostByCategoryId(Integer categoryId);


}
