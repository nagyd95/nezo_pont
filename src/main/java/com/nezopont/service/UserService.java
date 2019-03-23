package com.nezopont.service;

import com.nezopont.entity.Role;
import com.nezopont.entity.User;
import com.nezopont.repository.UserRepository;
import com.nezopont.service.exceptions.UserNotValidException;
import com.nezopont.web.DTO.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;

    private static User userC;

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


    public static User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return userC = userRepository.findByEmail(user.getEmail());
        }
        throw new UserNotValidException();
    }

    public static boolean isValid(User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent();
    }

}
