package com.bsdim.tlj.ui.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        req.setAttribute("blocks", addImageInfo());

        req.getRequestDispatcher("/WEB-INF/view/" + jspName).forward(req, resp);
    }

    public List<InfoBlock> addImageInfo() {
        List<InfoBlock> list = new ArrayList<>();

        InfoBlock info1 = new InfoBlock();
        InfoBlock info2 = new InfoBlock();
        InfoBlock info3 = new InfoBlock();

        info1.setImageUrl("programmer");
        info1.setTitle("programmer");

        info2.setImageUrl("sun");
        info2.setTitle("sun");

        info3.setImageUrl("moon");
        info3.setTitle("moon");

        list.add(info1);
        list.add(info2);
        list.add(info3);

        return list;
    }
}
