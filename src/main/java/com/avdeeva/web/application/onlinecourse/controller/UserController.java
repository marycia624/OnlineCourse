package com.avdeeva.web.application.onlinecourse.controller;

import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${image.upload.path}")
    private String uploadFile;

    @GetMapping("/userEdit")
    private String editUser (@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping("/userEdit")
    private String edit (@AuthenticationPrincipal User user,
                         @RequestParam String login,
                         @RequestParam String email,
                          Model model) {
        if (!user.getLogin().equals(login)) {
            if (userRepository.findByLogin(login) != null) {
                model.addAttribute("duplicateLogin", "Пользователь с таким логином уже существует");
                model.addAttribute("user", user);
                return "userEdit";
            }
            user.setLogin(login);
        }

        if (!user.getEmail().equals(email)) {
            if (userRepository.findByEmail(email) != null) {
                model.addAttribute("duplicateEmail", "Пользователь с таким email уже существует");
                model.addAttribute("user", user);
                return "userEdit";
            }
            user.setEmail(email);
        }
        userRepository.save(user);
        return "redirect:/personal-account";
    }

    @GetMapping("/editPassword")
    private String editPassword () {
        return "editPassword";
    }

    @PostMapping("/editPassword")
    private String changePassword (@AuthenticationPrincipal User user,
                                   @RequestParam("old_password") String old_password,
                                   @RequestParam("password") String password,
                                   Model model) {

        String oldPassword = passwordEncoder.encode(old_password);
        if (!user.getPassword().equals(oldPassword)) {
            model.addAttribute("wrongPassword", "Введен неверный старый пароль");
            return "editPassword";
        }
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/personal-account";
    }

    @PostMapping("/image")
    private String addImage(@AuthenticationPrincipal User user,
                            @RequestParam("file") MultipartFile file,
                            Model model) throws IOException {
        File uploadDir = new File(uploadFile);
        if (uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(uploadFile + resultFileName));

        user.setPhoto(resultFileName);
        userRepository.save(user);

        return "redirect:/personal-account";
    }
}
