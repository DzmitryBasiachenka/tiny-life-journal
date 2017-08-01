package com.bsdim.tlj.ui.web.menu;

import com.bsdim.tlj.ui.web.servlet.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {
    private String jspName = "main.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        return jspName;
    }
}
