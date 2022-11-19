package com.greenhome.thymeleaf.controller;

import com.greenhome.thymeleaf.entity.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ThymeleafController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/date")
    public String getDate(Model model) {
        model.addAttribute("dateNow", new Date());
        return "date";
    }

    @GetMapping("/variables")
    public String getVariable(Model model) {
        model.addAttribute("today", "Monday");

        Profile profile = new Profile();
        profile.setFullName("Ly Thanh Qui");
        profile.setEmail("ceoltqui@gmail.com");

        model.addAttribute("profile", profile);

        model.addAttribute("id", 3);
        model.addAttribute("page", 3);
        model.addAttribute("limit", 10);
        model.addAttribute("lang", "en");

        return "variables";
    }

    @GetMapping("/condition")
    public String getCondition(Model model) {
        model.addAttribute("age", 18);
        model.addAttribute("dow", 5);
        return "condition";
    }

    @GetMapping("/loop")
    public String getLoop(Model model) {
        String[] flowers = new String[]{
                "Rose",
                "Lily",
                "Tulip"
        };
        model.addAttribute("flowers", flowers);
        return "loop";
    }

    @GetMapping("/class")
    public String getClass(Model model){
        model.addAttribute("isAdmin", true);
        return "class";
    }
}
