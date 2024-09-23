package com.susan.prg2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.susan.prg2.entity.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        // Hardcoded username and password for demo purposes
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Registration logic here (e.g., saving user to a database)
        System.out.println("Registering user: " + user.getUsername());
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
