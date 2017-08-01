package com.bsdim.tlj.ui.web.menu;

import com.bsdim.tlj.ui.web.servlet.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsAction implements Action {
    private String jspName = "news.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        return jspName;
    }
}
