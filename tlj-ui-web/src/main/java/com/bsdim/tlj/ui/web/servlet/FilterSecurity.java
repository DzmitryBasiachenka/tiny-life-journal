package com.bsdim.tlj.ui.web.servlet;

import java.io.*;
import javax.servlet.*;

public class FilterSecurity implements Filter {

    public void init (FilterConfig config) throws ServletException {
    }

    public void doFilter (ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
            req.getRequestDispatcher("/WEB-INF/view/authorization_window.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}
