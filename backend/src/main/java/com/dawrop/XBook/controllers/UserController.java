package com.dawrop.XBook.controllers;

import com.dawrop.XBook.models.User;
import com.dawrop.XBook.repositories.UserRepository;
import com.dawrop.XBook.structures.UserStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:8081")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String userRegistration(@RequestBody UserStructure userStructure) {
        User user = null;

        try {
            if (userRepository.existsByEmail(userStructure.getEmail())) {
                return "User with this email already exists.";
            }

            if (!userStructure.getPassword().equals(userStructure.getRepeatPassword())) {
                return "Passwords don't match.";
            }

            user = new User(userStructure.getName(),
                            userStructure.getSurname(),
                            passwordEncoder.encode(userStructure.getPassword()),
                            userStructure.getEmail(),
                            "default.png",
                            "user");
            userRepository.save(user);
        } catch (Exception e) {
            return "Error creating the user: " + e.toString();
        }

        return "User succesfully created!";
    }




    @GetMapping("/test")
    public String test() {
        User user = userRepository.findFirstByEmail("email@wp.pl");
        //user = new User("Dawid", "Ropa", "haslo1", "dawr@o2.pl", "def.png", "user");

        return user.getName();
    }
}
