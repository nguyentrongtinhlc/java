package com.example.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model) {
        WelcomeMessage message = new WelcomeMessage("Chào mừng bạn đến với ứng dụng!", LocalDateTime.now());
        model.addAttribute("welcome", message);
        return "welcome";
    }
}