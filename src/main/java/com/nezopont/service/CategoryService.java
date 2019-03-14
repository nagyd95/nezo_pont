package com.nezopont.service;

import com.nezopont.entity.Category;
import com.nezopont.repository.CategoryReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryReposit categoryReposit;

    @Autowired
    public CategoryService(CategoryReposit categoryReposit) {
        this.categoryReposit = categoryReposit;
    }

    public List<Category> findAllCategory(){
        return categoryReposit.findAll();
    }

}
