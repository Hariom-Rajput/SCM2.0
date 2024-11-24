package com.scm.hari.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scm")
public class AppController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    
    @GetMapping("/services")
    public String servicesPage() {
        return "services";
    }
        
    @GetMapping("/contactus")
    public String contactPage() {
        return "contactus";
    }
    
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
