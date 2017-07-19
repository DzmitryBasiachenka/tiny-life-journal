package com.bsdim.tlj.ui.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String jspName = "main.jsp";

        if(requestURI.startsWith(contextPath + "/news")){
            jspName = "news.jsp";
        } else if (requestURI.startsWith(contextPath + "/communication")) {
            jspName = "communication.jsp";
        } else if (requestURI.startsWith(contextPath + "/info")) {
            jspName = "info.jsp";
        }

        req.getRequestDispatcher("/WEB-INF/view/" + jspName).forward(req, resp);
    }
}
