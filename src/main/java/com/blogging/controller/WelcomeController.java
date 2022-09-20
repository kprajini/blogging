package com.blogging.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.blogging.service.AdminService;

/**
 * This Controller added for the UI - Thymeleaf template Purpose
 * 
 * @author rk105670
 *
 */

@Controller
public class WelcomeController {
	
	@Autowired
    private AdminService adminServiceImpl;
 
    @GetMapping("/")
    public String viewHomePage(Model model) {
        try {
			model.addAttribute("allUserPostsList", adminServiceImpl.getPostsRelatedToUsers());
		} catch (IOException e) {
			model.addAttribute("allUserPostsList",null);
		}
        return "index";
    }
    
    @GetMapping("/posts/{id}")
    public String viewPostsDetails(@PathVariable(value = "id") int id, Model model) {
        try {
			model.addAttribute("postsInfoList", adminServiceImpl.getRelatedPostsBasedOnUserId(id));
		} catch (IOException e) {
			model.addAttribute("postsInfoList", null);
		}
        return "posts";
    }

}
