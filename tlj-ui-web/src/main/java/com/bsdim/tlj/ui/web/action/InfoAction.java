package com.bsdim.tlj.ui.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsdim.tlj.ui.web.servlet.Action;

/**
 * The info action.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class InfoAction implements Action {
    private static final String INFO_JSP_NAME = "info.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("blocks", new CommunicationAction().addImageInfo());
        return INFO_JSP_NAME;
    }
}
