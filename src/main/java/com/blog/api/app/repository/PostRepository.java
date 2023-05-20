package com.blog.api.app.repository;

import com.blog.api.app.entity.Category;
import com.blog.api.app.entity.Post;
import com.blog.api.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findByUser(User user1);


    Post findByCategory(Category category1);
}
