package com.usa.mintic.reto.repository;

import com.usa.mintic.reto.entities.Category;
import com.usa.mintic.reto.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getCategories(){ return (List<Category>) categoryCrudRepository.findAll();}

    public Optional<Category> getCategory(int id){ return categoryCrudRepository.findById(id);}

    public Category saveCategory(Category c) { return categoryCrudRepository.save(c);}

    public void deleteCategory(Category c) {categoryCrudRepository.delete(c);}
}
