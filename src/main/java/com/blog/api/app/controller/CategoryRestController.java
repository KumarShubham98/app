package com.blog.api.app.controller;


import com.blog.api.app.entity.Category;
import com.blog.api.app.entity.User;
import com.blog.api.app.repository.CategoryRepository;
import com.blog.api.app.service.CategoryService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController {


    @Autowired
    private CategoryService categoryService;

   @PostMapping("/save")
    public ResponseEntity<Category>  createCategory(@RequestBody Category category){
       Category category1 =  categoryService.createCategory(category);
       return ResponseEntity.ok(category1);

   }


   @GetMapping("/getById/{id}")
   public ResponseEntity<Category>  getCategoryById(@PathVariable("id") Integer categoryId){
       Category category1 =  categoryService.getCategoryById(categoryId);
       return ResponseEntity.ok(category1);

   }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>>  getAllCategory(){
        List<Category> category1 =  categoryService.getAllCategory();
        return ResponseEntity.ok(category1);

    }


    @PutMapping("update/{id}")
    public ResponseEntity<Category>  updateCategory(@RequestBody Category category,@PathVariable("id") Integer categoryId){
        Category category1 =  categoryService.updateCategory(category,categoryId);
        return ResponseEntity.ok(category1);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Category>  deleteCategory(@PathVariable("id") Integer categoryId){
         categoryService.deleteCategory(categoryId);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }


}
