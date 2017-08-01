package com.bsdim.tlj.ui.web.menu;

import com.bsdim.tlj.ui.web.servlet.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {
    private static final String MAIN_JSP_NAME = "main.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        return MAIN_JSP_NAME;
    }
}
