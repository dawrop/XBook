package com.dawrop.XBook.controllers;

import com.dawrop.XBook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;


}
