package com.avdeeva.web.application.onlinecourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.nio.ch.sctp.SctpChannelImpl;

@Service
public class MailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Value("spring.mail.username")
    private String username;

    public void send(String emailTo, String title, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(title);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
