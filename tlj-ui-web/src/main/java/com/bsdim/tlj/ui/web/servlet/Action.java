package com.bsdim.tlj.ui.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    String perform(HttpServletRequest req, HttpServletResponse resp);
}
