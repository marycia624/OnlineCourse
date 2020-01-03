package com.avdeeva.web.application.onlinecourse.controller;


import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import com.avdeeva.web.application.onlinecourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signUp", method= RequestMethod.GET)
    public String getSignUp() {
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method=RequestMethod.POST)
    public String addNewUser(@RequestParam("login") String login,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        int error = userService.addUser(user);

        if (error == 1) {
            model.addAttribute("duplicateLogin", "Пользователь с таким логином уже существует");
            return "signUp";
        }

        if (error == 2) {
            model.addAttribute("duplicateEmail", "Пользователь с таким email уже существует");
            return "signUp";
        }


        model.addAttribute("message", "Вам на почту отправлена ссылка для активации аккаунта");
        return "login";
    }

    @GetMapping(value = "/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Активация прошла успешно");
        } else {
            model.addAttribute("message", "Упс, что-то пошло не так. Попробуй зарегистрироваться снова :)");
        }

        return "login";
    }

  /* @PostMapping(value = "/login")
    public String loginAct(Model model,
                        @RequestParam String username,
                           @RequestParam String password) {
        User userFromDb = userRepository.findByLogin(username);
        if (userFromDb.getActivationCode() != null) {
            model.addAttribute("message", "Ваш аккаунт не активирован");
            return "login";
        }
        return "redirect:/personal-account";
    }*/
}
