package com.bsdim.tlj.ui.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsdim.tlj.ui.web.servlet.Action;

/**
 * The news action.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class NewsAction implements Action {
    private static final String NEWS_JSP_NAME = "news.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        return NEWS_JSP_NAME;
    }
}
