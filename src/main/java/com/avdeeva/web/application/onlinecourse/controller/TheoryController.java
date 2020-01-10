package com.avdeeva.web.application.onlinecourse.controller;

import com.avdeeva.web.application.onlinecourse.domain.Role;
import com.avdeeva.web.application.onlinecourse.domain.Theory;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.TheoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class TheoryController {

    @Autowired
    private TheoryRepository theoryRepository;

    @RequestMapping(value = "/studing", method = RequestMethod.GET)
    public String getStuding(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            Set<Role> roles = user.getRoles();
            for (Role role : user.getRoles()) {
                if (role.name().equals("ADMIN")) {
                    model.addAttribute("roleAdmin", true);
                }
            }
        }
        model.addAttribute("theory", theoryRepository.findAll());
        return "studing";
    }


    @GetMapping("addTheory")
    public String addTheory (Model model, @AuthenticationPrincipal User user) {

        model.addAttribute("what", "/addTheory");
        return "addNews";
    }

    @PostMapping("addTheory")
    public String addNewTheory (Model model,  @RequestParam("editor") String text) {
        Theory theory = new Theory();
        theory.setNumber((int) text.charAt(3));
        theory.setText(text.substring(8));
        theoryRepository.save(theory);
        return "redirect:/studing";
    }
}
