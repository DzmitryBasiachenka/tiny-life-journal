package com.bsdim.tlj.ui.web.menu;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.repository.IArticleRepository;
import com.bsdim.tlj.repository.sql.ArticleRepositorySql;
import com.bsdim.tlj.ui.web.servlet.Action;
import com.bsdim.tlj.ui.web.session.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MainAction implements Action {
    private static final String MAIN_JSP_NAME = "main.jsp";
    private IArticleRepository repository = new ArticleRepositorySql();

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("articles", getListArticle(req));

        return MAIN_JSP_NAME;
    }

    private List<Article> getListArticle(HttpServletRequest req) {
        HttpSession session = req.getSession();
        UserSession user = (UserSession)session.getAttribute("userSession");

        return  repository.findByUserId(user.getId());
    }
}
