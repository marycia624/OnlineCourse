package com.avdeeva.web.application.onlinecourse.controller;


import com.avdeeva.web.application.onlinecourse.domain.Comment;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.JoinColumn;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentsRepo;

    @RequestMapping(value = "/one-news", method = RequestMethod.GET)
    public String oneNews (Map<String, Object> model) {
        Iterable<Comment> allComments = commentsRepo.findAll();
        model.put("comments", allComments);
        return "one-news";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment (@RequestParam String message, @AuthenticationPrincipal User user, Map<String, Object> model) {
        Comment comment = new Comment(message, user);
        commentsRepo.save(comment);

        Iterable<Comment> allComments = commentsRepo.findAll();

        model.put("comments", allComments);

        return "one-news";
    }
}
