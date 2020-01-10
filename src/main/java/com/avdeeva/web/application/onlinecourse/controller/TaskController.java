package com.avdeeva.web.application.onlinecourse.controller;

import com.avdeeva.web.application.onlinecourse.domain.Role;
import com.avdeeva.web.application.onlinecourse.domain.Task;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.TaskRepository;
import com.avdeeva.web.application.onlinecourse.repos.UserRepository;
import com.avdeeva.web.application.onlinecourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

@Controller
public class TaskController {

    @Value("${image.upload.path}")
    private String uploadFile;

    @Value("${image.upload.url}")
    private String uploadUrl;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/practice")
    public String getPractice(@AuthenticationPrincipal User user, Model model) {
        Set<Role> roles = user.getRoles();

        for (Role role : user.getRoles()) {
            if (role.name().equals("ADMIN")) {
                model.addAttribute("roleAdmin", true);
            }
        }

        return "practice";
    }

    @GetMapping("/task/{number}")
    public String getTasks (Model model, @PathVariable Integer number,
                            @AuthenticationPrincipal User user,
                            @RequestParam(value = "id",required = false) BigInteger id) {
        model.addAttribute("resolving", findSizeByNumberOfTask(user, number));
        model.addAttribute("all", taskRepository.findByNumber(number).size());
        Set<Role> roles = user.getRoles();

        for (Role role : user.getRoles()) {
            if (role.name().equals("ADMIN")) {
                model.addAttribute("roleAdmin", true);
            }
        }

        List<Task> task2 = taskRepository.findByNumber(number);
        Boolean delete = false;
        List<Task> task = new ArrayList<>();

        if (id != null) {
            for (Task one : task2) {
                if (one.getId().compareTo(id) > 0) {
                    task.add(taskRepository.findById(one.getId()).get());
                } else delete = true;
            }
        } else task = task2;

        if (userService.notResolvingTask(task, user) != null) {
            model.addAttribute("task", userService.notResolvingTask(task, user));
            return "practice";
        }

        if (delete) {
            model.addAttribute("task", userService.notResolvingTask(taskRepository.findByNumber(number), user));
            return "practice";
        }

        model.addAttribute("cong", true);
        return "practice";
    }

    @GetMapping("/addPractice")
    public String add () {
        return "addPractice";
    }

    @PostMapping("/addPractice")
    public String addTask (@RequestParam("number") Integer number,
                           @RequestParam("points") Integer points,
                           @RequestParam("task") String task,
                           @RequestParam("answer") String answer,
                           @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        Task newtask = new Task();
        newtask.setNumber(number);
        newtask.setPoints(points);
        newtask.setTask(task);
        newtask.setAnswer(answer);
        if (file != null) {
            File uploadDir = new File(uploadFile);

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadFile + resultFileName));
            newtask.setImage(resultFileName);
        }
        taskRepository.save(newtask);
        return "redirect:/practice";
    }

    @PostMapping("/task/{number}")
    private String check (@RequestParam("id")BigInteger id,
                          @RequestParam("answer") String answer,
                          @AuthenticationPrincipal User user,
                          Model model) {
        Set<Role> roles = user.getRoles();

        for (Role role : user.getRoles()) {
            if (role.name().equals("ADMIN")) {
                model.addAttribute("roleAdmin", true);
            }
        }


        model.addAttribute("resolving", findSizeByNumberOfTask(user,
                taskRepository.findById(id).get().getNumber()));
        model.addAttribute("all", taskRepository.findByNumber(taskRepository.findById(id).get().getNumber()).size());

        if (!taskRepository.findById(id).get().getAnswer().equals(answer)) {
            model.addAttribute("error", "Неправильно! Попробуй еще раз или переходи к следующему заданию");
            model.addAttribute("task", taskRepository.findById(id).get());
            return "practice";
        }
        model.addAttribute("error", "Правильно! Продолжай в том же духе");
        Set<Task> tasks = user.getTasks();
        if (!tasks.contains(taskRepository.findById(id).get()))
            tasks.add(taskRepository.findById(id).get());
        user.setTasks(tasks);

        user.setPoints(user.getPoints() == null ? taskRepository.findById(id).get().getPoints() : taskRepository.findById(id).get().getPoints()+user.getPoints() );
        userRepository.save(user);
        List<Task> task = taskRepository.findByNumber(taskRepository.findById(id).get().getNumber());
        model.addAttribute("resolving", user.getTasks().size());
        model.addAttribute("all", taskRepository.findByNumber(taskRepository.findById(id).get().getNumber()).size());


        if (userService.notResolvingTask(task, user) != null) {
            model.addAttribute("task", userService.notResolvingTask(task, user));
            return "practice";
        }

        return "practice";

    }

    private Integer findSizeByNumberOfTask(User user, Integer number) {
        List<Task> foundTask = new LinkedList<>();
        for (Task one : user.getTasks()) {
            if (one.getNumber().equals(number)) {
                foundTask.add(one);
            }
        }
        return foundTask.size();
    }
}
