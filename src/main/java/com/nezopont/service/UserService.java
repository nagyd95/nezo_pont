package com.nezopont.service;

import com.nezopont.entity.Role;
import com.nezopont.entity.User;
import com.nezopont.repository.UserRepository;
import com.nezopont.web.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserRegistrationDTO user){
        User newUser=new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(newUser);
    }
}
