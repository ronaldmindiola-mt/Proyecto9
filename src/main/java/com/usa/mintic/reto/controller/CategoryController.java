package com.usa.mintic.reto.controller;

import com.usa.mintic.reto.entities.Category;
import com.usa.mintic.reto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategories(){return categoryService.getCategories();}

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){ return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category c){return categoryService.saveCategory(c);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCategory(@RequestBody Category c){return categoryService.updateCategory(c);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int categoryId){return categoryService.deleteCategory(categoryId);}
}
