package com.avdeeva.web.application.onlinecourse.controller;


import com.avdeeva.web.application.onlinecourse.domain.Comment;
import com.avdeeva.web.application.onlinecourse.domain.News;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.CommentRepository;
import com.avdeeva.web.application.onlinecourse.repos.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigInteger;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentsRepository;

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value = "/comment/news/{id}", method = RequestMethod.POST)
    public String comment (@RequestParam("message") String message, @AuthenticationPrincipal User user, @PathVariable BigInteger id) {

        if (user == null) {
            return "redirect:/one-news/" + id;
        }
        News news = newsRepository.findById(id).get();
        Comment comment = new Comment(message, user, news);
        commentsRepository.save(comment);

        return "redirect:/one-news/" + id;
    }
}
