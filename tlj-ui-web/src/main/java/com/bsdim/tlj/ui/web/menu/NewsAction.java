package com.bsdim.tlj.ui.web.menu;

import com.bsdim.tlj.ui.web.servlet.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsAction implements Action {
    private static final String NEWS_JSP_NAME = "news.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        return NEWS_JSP_NAME;
    }
}
