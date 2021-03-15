package com.dawrop.XBook;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
    @RequestMapping("/")
    public String fun() {
        return "Hello World!";
    }
}
