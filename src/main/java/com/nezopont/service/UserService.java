package com.nezopont.service;

import com.nezopont.entity.Role;
import com.nezopont.entity.User;
import com.nezopont.repository.UserRepository;
import com.nezopont.web.DTO.LogindDTO;
import com.nezopont.web.DTO.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserRegistrationDTO user){
        User newUser=new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(newUser);
    }


    public String login(LogindDTO login)  {
            User loginUser=new User(login.getEmail(),login.getPassword());
            System.out.println(loginUser.getPassword());
            System.out.println(userRepository.findByEmail(loginUser.getEmail()).getPassword());
        System.out.println(passwordEncoder.encode(login.getPassword()));
        boolean bent=(passwordEncoder.matches(loginUser.getPassword(),userRepository.findByEmail(loginUser.getEmail()).getPassword()));
        System.out.println(bent);
            return loginUser.getEmail();


    }
   public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<User> findAllCategory(){
        return userRepository.findAll();
    }



}
