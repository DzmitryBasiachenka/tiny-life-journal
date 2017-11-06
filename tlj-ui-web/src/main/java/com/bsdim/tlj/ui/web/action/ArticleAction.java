package com.bsdim.tlj.ui.web.action;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.service.article.ArticleService;
import com.bsdim.tlj.ui.web.servlet.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleAction implements Action {
    private static final String ARTICLE_JSP_NAME = "article.jsp";
    private static final String ARTICLE = "article";
    private static final char SLASH = '/';

    private ArticleService service = new ArticleService();

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        String servletPath = req.getServletPath();

        int index = servletPath.lastIndexOf(SLASH, servletPath.length());
        String articleId = servletPath.substring(index + 1);
        Article article = service.read(articleId);

        req.setAttribute(ARTICLE, article);

        return ARTICLE_JSP_NAME;
    }
}
