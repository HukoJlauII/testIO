package ru.nglushko.testio.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "pages-login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "pages-register";
    }

}