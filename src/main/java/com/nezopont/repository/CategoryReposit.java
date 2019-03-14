package com.nezopont.repository;

import com.nezopont.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryReposit extends JpaRepository<Category,Integer> {

    @Override
   List<Category> findAll();
}
