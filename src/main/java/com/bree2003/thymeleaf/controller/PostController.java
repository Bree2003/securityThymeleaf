package com.bree2003.thymeleaf.controller;

import com.bree2003.thymeleaf.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return "/posts/home";
    }


}