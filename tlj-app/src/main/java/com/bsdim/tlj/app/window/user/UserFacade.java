package com.bsdim.tlj.app.window.user;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.service.article.ArticleService;
import com.bsdim.tlj.service.user.UserService;

import java.util.List;

public class UserFacade {
    private UserService userService = new UserService();
    private ArticleService articleService = new ArticleService();

    public User getUser (String login, String password) {
        User user = userService.findByLogin(login);
        if ((user != null) && (user.getPassword().equals(password))) {
                return user;
            }
        return null;
    }

    public void addArticle(Article article) {
        articleService.create(article);
    }

    public List<Article> getArticleByUserId(String userId) {
        return articleService.findByUserId(userId);
    }
}