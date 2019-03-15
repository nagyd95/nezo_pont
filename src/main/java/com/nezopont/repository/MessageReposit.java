package com.nezopont.repository;

import com.nezopont.entity.Category;
import com.nezopont.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageReposit extends JpaRepository<Message,Long> {

    @Override
    List<Message> findAll();
}
