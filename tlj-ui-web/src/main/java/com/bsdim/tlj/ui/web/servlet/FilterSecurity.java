package com.bsdim.tlj.ui.web.servlet;

import java.io.*;
import javax.servlet.*;

public class FilterSecurity implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if((login != null) && (password != null)) {
            chain.doFilter(request, response);
            return;
        }

        request.getRequestDispatcher("/WEB-INF/view/login_page.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}
