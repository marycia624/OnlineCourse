package com.avdeeva.web.application.onlinecourse.controller;


import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public String adding() {
        return "addNews";
    }

    @RequestMapping(value = "/personal-account", method = RequestMethod.GET)
    public String getPersonalPage(@AuthenticationPrincipal User user, Model model)
    {
        model.addAttribute("user", user);
        return "personal-account";
    }

    @RequestMapping(value = "/personal-account", method = RequestMethod.POST)
    public String postPersonalPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "personal-account";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getNewsPage(@AuthenticationPrincipal User user)
    { return "news"; }


    @RequestMapping(value = "/studing", method = RequestMethod.GET)
    public String getStuding(@AuthenticationPrincipal User user)
    { return "studing"; }


}
