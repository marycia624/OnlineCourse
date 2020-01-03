package com.avdeeva.web.application.onlinecourse.controller;

import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userEdit")
    private String editUser (@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "userEdit";
    }

    /*@PostMapping("/userEdit")
    private String edit (@AuthenticationPrincipal User user,
                         @RequestParam String login,
                         @RequestParam String email) {

    }*/
}
