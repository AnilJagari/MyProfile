package com.anil.jagari.myprofile.controller;

import com.anil.jagari.myprofile.dto.ContactForm;
import com.anil.jagari.myprofile.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ContactController {

    private final MailService mailService;

    public ContactController(MailService mailService) {
        this.mailService = mailService;
    }

    // Show contact form
    @GetMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    // Handle form submission
    @PostMapping("/contact")
    public String submitContact(@ModelAttribute ContactForm contactForm, Model model) {
        mailService.sendEmail(contactForm);
        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "contact";
    }
}
