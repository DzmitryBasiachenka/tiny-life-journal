package com.bsdim.tlj.ui.web.servlet;

import com.bsdim.tlj.ui.web.menu.CommunicationAction;
import com.bsdim.tlj.ui.web.menu.InfoAction;
import com.bsdim.tlj.ui.web.menu.MainAction;
import com.bsdim.tlj.ui.web.menu.NewsAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    private static final String ERROR_404 = "404.jsp";

    private Map<String, Action> map;

    @Override
    public void init() throws ServletException {
        initMenuMap();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        Action action = map.get(servletPath);

        String jspName = ERROR_404;
        if(action != null) {
            jspName = action.perform(req, resp);
        }

        req.getRequestDispatcher("/WEB-INF/view/" + jspName).forward(req, resp);
    }

    public void initMenuMap() {
        map = new HashMap<>();
        map.put("/", new MainAction());
        map.put("/news", new NewsAction());
        map.put("/communication", new CommunicationAction());
        map.put("/info", new InfoAction());
    }
}
