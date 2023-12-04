package com.codingdojo.autorizacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.autorizacion.models.User;

import jakarta.validation.Valid;

@Controller
public class UserController {
	@RequestMapping("/register")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
}
