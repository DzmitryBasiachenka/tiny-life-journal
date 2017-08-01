package com.bsdim.tlj.ui.web.menu;

import com.bsdim.tlj.ui.web.servlet.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoAction implements Action {
    private static final String INFO_JSP_NAME = "info.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("blocks", new CommunicationAction().addImageInfo());
        return INFO_JSP_NAME;
    }
}
