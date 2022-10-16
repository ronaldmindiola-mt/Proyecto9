package com.usa.mintic.reto.service;

import com.usa.mintic.reto.entities.Category;
import com.usa.mintic.reto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories(){return categoryRepository.getCategories();}

    public Optional<Category> getCategory(int id){return categoryRepository.getCategory(id);}

    public Category saveCategory(Category c){
        if(c.getId()==null){
            return categoryRepository.saveCategory(c);
        }else{
            Optional<Category> element = categoryRepository.getCategory(c.getId());
            if(element.isPresent()){
                return c;
            }else{
                return categoryRepository.saveCategory(c);
            }
        }
    }
    public Category updateCategory(Category c){
        if(c.getId()!=null){
            Optional<Category> element = categoryRepository.getCategory(c.getId());
            if(element.isPresent()){
                if(c.getName()!=null){
                    element.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    element.get().setDescription(c.getDescription());
                }
                categoryRepository.saveCategory(element.get());
                return element.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean deleteCategory(int id){
        boolean flag = false;
        Optional<Category> element = categoryRepository.getCategory(id);
        if(element.isPresent()){
            categoryRepository.deleteCategory(element.get());
            flag = true;
        }
        return flag;
    }

}
