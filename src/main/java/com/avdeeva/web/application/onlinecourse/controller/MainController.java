package com.avdeeva.web.application.onlinecourse.controller;


import com.avdeeva.web.application.onlinecourse.domain.Role;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.TaskRepository;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String main() { return "index"; }

    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public String adding(@RequestParam(name= "image",required = false) String image, Model model) {


        if (image != null) {
            model.addAttribute("image", image);
        }

        model.addAttribute("what", "/addNewNews");
        return "addNews";
    }

    @RequestMapping(value = "/personal-account", method = RequestMethod.GET)
    public String getPersonalPage(@AuthenticationPrincipal User user, Model model)
    {
        model.addAttribute("maxvalue", taskRepository.findAll().size());
        model.addAttribute("points", user.getTasks().size());
        model.addAttribute("user", user);
        return "personal-account";
    }

    @RequestMapping(value = "/personal-account", method = RequestMethod.POST)
    public String postPersonalPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("maxvalue", taskRepository.findAll().size());
        model.addAttribute("points", user.getTasks().size());
        model.addAttribute("user", user);
        return "personal-account";
    }




}
