package com.avdeeva.web.application.onlinecourse.service;

import com.avdeeva.web.application.onlinecourse.domain.Role;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    public int addUser(User user)  {
        User userFromDb = userRepository.findByLogin(user.getLogin());

        if (userFromDb != null) {
            return 1;
        }

        if (userFromDb != null) {
            return 2;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());

        userRepository.save(user);

        String message = String.format(
                "Привет, %s! \n" +
                        "Добро пожаловать на DoWhile.Pro. Чтобы активировать свой аккаунт, пожалйста, перейди по ссылке http://localhost:8080/activate/%s",
                user.getLogin(),
                user.getActivationCode()
        );

        mailSender.send(user.getEmail(), "Activation code", message);


        return 0;
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        userRepository.save(user);
        return true;
    }
}
