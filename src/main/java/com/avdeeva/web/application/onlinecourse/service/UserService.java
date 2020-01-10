package com.avdeeva.web.application.onlinecourse.service;

import com.avdeeva.web.application.onlinecourse.domain.Role;
import com.avdeeva.web.application.onlinecourse.domain.Task;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.TaskRepository;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TaskRepository taskRepository;

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
        user.setPhoto("e77a53de-22be-44f5-940a-c2597d694f28.scale_1200.png");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

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

    public Task notResolvingTask (List<Task> tasks, User user) {
        for (Task one : tasks) {
            boolean fit = true;
            for (Task t : user.getTasks()) {
                if (t.getId().equals(one.getId())) {
                    fit = false;
                }
            }
            if (fit) {
                return one;
            }
        }
        return null;
    }
}
