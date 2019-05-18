package com.nezopont.repository;

import com.nezopont.entity.Category;
import com.nezopont.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findByEmail(String email);
}
