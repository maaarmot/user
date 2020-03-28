package com.medical.demo.controller;

import com.medical.demo.model.Article;
import com.medical.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String index(Model model){
        List<Article> allArticles = articleService.getAllArticles();
        model.addAttribute("allArticles",allArticles);
        return "index";
    }
}
