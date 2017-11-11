package com.bsdim.tlj.ui.web.action;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.service.article.ArticleService;
import com.bsdim.tlj.ui.web.servlet.Action;
import com.bsdim.tlj.ui.web.session.UserSession;
import com.bsdim.tlj.ui.web.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

public class SaveArticleAction implements Action {
    private static final String USER_SESSION = "userSession";
    private static final String TITLE = "title";
    private static final String TEXT = "text";
    private static final String EMPRY_ARTICLE = "emptyArticle";
    private static final String MESSAGE_EMPTY_ARTICLE = "The all fields of article form should not be empty";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter(TITLE);
        String text = req.getParameter(TEXT);

        addArticle(title, text, req);

        return new MainAction().perform(req, resp);
    }

    private static void addArticle(String title, String text, HttpServletRequest req) {
        if (WebUtil.compareParameters(title, text)) {
            HttpSession session = req.getSession();
            UserSession user = (UserSession) session.getAttribute(USER_SESSION);

            Article article = new Article();
            article.setTitle(title);
            article.setText(text);
            article.setUserId(user.getId());
            article.setId(UUID.randomUUID().toString());

            ArticleService articleService = new ArticleService();
            articleService.create(article);
        } else {
            req.setAttribute(EMPRY_ARTICLE, MESSAGE_EMPTY_ARTICLE);
        }
    }
}
