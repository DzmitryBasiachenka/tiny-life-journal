package com.bsdim.tlj.ui.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Represents interface for actions.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public interface Action {

    /**
     * Performs the action.
     *
     * @param req the servlet request.
     * @param resp the servlet reponce.
     * @return the action name.
     */
    String perform(HttpServletRequest req, HttpServletResponse resp);
}
