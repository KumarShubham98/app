package com.blog.api.app.impl;

import com.blog.api.app.Exception.ResourceNotFoundException;
import com.blog.api.app.entity.Category;
import com.blog.api.app.repository.CategoryRepository;
import com.blog.api.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        Category save = this.categoryRepository.save(category);
        return save;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        Category catg = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        return catg;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categ = this.categoryRepository.findAll();
        return categ;
    }

    @Override
    public Category updateCategory(Category category, Integer categoryId) {

        Category categ = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        categ.setCategoryId(category.getCategoryId());
        categ.setTitle(category.getTitle());
        categ.setDescription(category.getDescription());

        Category updateCategory = this.categoryRepository.save(category);

        return updateCategory;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category category1 = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));
        this.categoryRepository.delete(category1);

    }
}
