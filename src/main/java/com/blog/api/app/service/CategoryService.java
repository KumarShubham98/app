package com.blog.api.app.service;


import com.blog.api.app.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {


     public Category createCategory(Category category);

     public  Category  getCategoryById(Integer categoryId);

     public List<Category> getAllCategory();

     public  Category   updateCategory(Category category,Integer categoryId);

     public  void deleteCategory(Integer categoryId);

}
