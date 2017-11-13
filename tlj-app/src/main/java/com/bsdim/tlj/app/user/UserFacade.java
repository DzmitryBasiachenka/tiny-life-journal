package com.bsdim.tlj.app.user;

import java.util.List;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.service.article.ArticleService;
import com.bsdim.tlj.service.user.UserService;

/**
 * The user facade.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class UserFacade {
    private UserService userService = new UserService();
    private ArticleService articleService = new ArticleService();

    /**
     * Gets user.
     *
     * @param login the login.
     * @param password the password.
     * @return the user object.
     */
    public User getUser(String login, String password) {
        User user = userService.findByLogin(login);
        if ((user != null) && (user.getPassword().equals(password))) {
            return user;
        }
        return null;
    }

    /**
     * Adds article.
     *
     * @param article the article object.
     */
    public void addArticle(Article article) {
        articleService.create(article);
    }

    /**
     * Gets article by user id.
     *
     * @param userId the user id.
     * @return the list of articles.
     */
    public List<Article> getArticleByUserId(String userId) {
        return articleService.findByUserId(userId);
    }
}
