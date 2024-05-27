package com.bree2003.thymeleaf.controller;

import com.bree2003.thymeleaf.entity.UserEntity;
import com.bree2003.thymeleaf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/record")
    public String recordPage() {
        return "/users/register";
    }

    @PostMapping("/register")
    public String register(UserEntity user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = {"/login", "/"})
    public String loginPage(){
        return "/users/login";
    }
}
