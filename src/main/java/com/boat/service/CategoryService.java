package com.boat.service;

import com.boat.model.Category;
import com.boat.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
    
    public boolean deleteCategory(int id){
        Optional<Category> miCategoria = categoryRepository.getCategory(id);
        
        if (miCategoria.isEmpty()){
            return false;
        }else{
            categoryRepository.delete(miCategoria.get());
            return true;
        }
    }
    
    /*
        {"id":1,"name":"modificada"}
    */
    public Category updateCategory(Category category){
        if (category.getId()!=null){
            Optional<Category> categoria = categoryRepository.getCategory(category.getId());
            
            if (!categoria.isEmpty()){
               if (category.getName()!=null){
                   categoria.get().setName(category.getName());
               }
               if (category.getDescription()!=null){
                   categoria.get().setDescription(category.getDescription());
               }
               return categoryRepository.save(categoria.get());
            }else{
               return category;
            }
        }
        return category;     
    }
}

