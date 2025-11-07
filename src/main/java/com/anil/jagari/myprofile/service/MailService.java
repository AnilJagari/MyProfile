package com.anil.jagari.myprofile.service;

import com.anil.jagari.myprofile.dto.ContactForm;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("your-email@example.com"); // replace with your recipient email
        message.setSubject("New Contact Form Submission from " + contactForm.getName());
        message.setText("Sender: " + contactForm.getName() + "\n"
                + "Email: " + contactForm.getEmail() + "\n"
                + "Message: " + contactForm.getMessage());

        mailSender.send(message);
    }
}
