package com.anil.jagari.myprofile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }

    // Removed the conflicting /contact mapping
    // @GetMapping("/contact") -> removed to avoid ambiguity
}
