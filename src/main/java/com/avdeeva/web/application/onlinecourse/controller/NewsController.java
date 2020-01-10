package com.avdeeva.web.application.onlinecourse.controller;

import com.avdeeva.web.application.onlinecourse.domain.Comment;
import com.avdeeva.web.application.onlinecourse.domain.News;
import com.avdeeva.web.application.onlinecourse.domain.Role;
import com.avdeeva.web.application.onlinecourse.domain.User;
import com.avdeeva.web.application.onlinecourse.repos.CommentRepository;
import com.avdeeva.web.application.onlinecourse.repos.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/addNewNews")
    public String addNews (@RequestParam("editor") String text, ModelMap model) {

       /* if (text == null) {
            model.addAttribute("message", "Статья не может быть пустой!");
            return new ModelAndView("addNews", model);
        }*/

        News news = new News();
        news.setText(text);
        newsRepository.save(news);

        return "redirect:/one-news/" + news.getId();
    }

    @GetMapping("one-news/{id}")
    private String showNews (@AuthenticationPrincipal User user, @PathVariable BigInteger id, Model model) {
        if (user == null) {
            model.addAttribute("roleHost", true);
            model.addAttribute("error", "Авторизуйтесь, чтобы оставлять комментарии!");
        } else {

            Set<Role> roles = user.getRoles();

            for (Role role : user.getRoles()) {
                if (role.name().equals("ADMIN")) {
                    model.addAttribute("roleAdmin", true);
                }
            }

            model.addAttribute("roleUser", true);
        }

        News news = newsRepository.findById(id).get();

        model.addAttribute("news", news);

        model.addAttribute("comments", commentRepository.findDistinctByNews(news));
        return "one-news";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getNewsPage(@AuthenticationPrincipal User user, Model model) {
        if (user == null) {
            model.addAttribute("roleHost", true);
        } else {

            Set<Role> roles = user.getRoles();

            for (Role role : user.getRoles()) {
                if (role.name().equals("ADMIN")) {
                    model.addAttribute("roleAdmin", true);
                }
            }

            model.addAttribute("roleUser", true);
        }
        String example = newsRepository.findById(BigInteger.valueOf(3)).get().getImage();

        model.addAttribute("nnews", newsRepository.findAll());
        return "news";
    }

    @GetMapping("editNews/{id}")
    private String editNews (@PathVariable BigInteger id, Model model) {
        News news = newsRepository.findById(id).get();
        model.addAttribute("what", "/editNews/"+news.getId());
        model.addAttribute("news", news);
        return "addNews";
    }

    @GetMapping("deleteNews/{id}")
    private String deleteNews (@PathVariable BigInteger id, Model model) {
        News news = newsRepository.findById(id).get();
        newsRepository.delete(news);
        return "redirect:/news";
    }

    @PostMapping("editNews/{id}")
    private String refreshNews (@PathVariable BigInteger id, Model model, @RequestParam("editor") String text) {


        News news = newsRepository.findById(id).get();
        news.setText(text);
        newsRepository.save(news);
        return "redirect:/one-news/" + news.getId();
    }


}
