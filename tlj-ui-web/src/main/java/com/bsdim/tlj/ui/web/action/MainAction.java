package com.bsdim.tlj.ui.web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.service.article.ArticleService;
import com.bsdim.tlj.ui.web.servlet.Action;
import com.bsdim.tlj.ui.web.session.UserSession;

/**
 * The main action.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class MainAction implements Action {
    private static final String MAIN_JSP_NAME = "main.jsp";
    private static final String USER_SESSION = "userSession";
    private static final String ARTICLES = "articles";

    private ArticleService service = new ArticleService();

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(ARTICLES, getListArticle(req));
        return MAIN_JSP_NAME;
    }

    private List<Article> getListArticle(HttpServletRequest req) {
        HttpSession session = req.getSession();
        UserSession user = (UserSession) session.getAttribute(USER_SESSION);
        return  service.findByUserId(user.getId());
    }
}
