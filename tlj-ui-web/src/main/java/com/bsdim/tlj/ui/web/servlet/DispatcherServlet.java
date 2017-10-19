package com.bsdim.tlj.ui.web.servlet;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.ui.web.menu.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    private static final String ERROR_404 = "404.jsp";
    private static final char SLASH = '/';

    private Map<String, Action> mapGet;
    private Map<String, Action> mapPost;

    @Override
    public void init() throws ServletException {
        initMapGet();
        initMapPost();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp, mapGet);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp, mapPost);
    }

    private void initMapGet() {
        mapGet = new HashMap<>();
        mapGet.put("/", new MainAction());
        mapGet.put("/news", new NewsAction());
        mapGet.put("/communication", new CommunicationAction());
        mapGet.put("/info", new InfoAction());
        mapGet.put("/article", new ArticleAction());
    }

    private void initMapPost() {
        mapPost = new HashMap<>();
        mapPost.put("/processingForm", mapGet.get("/"));
    }

    private void process(HttpServletRequest req, HttpServletResponse resp, Map<String, Action> map) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        Action action = findAction(servletPath, map);
        String jspName = ERROR_404;

        if(action != null) {
            jspName = action.perform(req, resp);
        }

        req.getRequestDispatcher("/WEB-INF/view/" + jspName).forward(req, resp);
    }

    private Action findAction(String servletPath, Map<String, Action> map) {
        while(!servletPath.isEmpty()) {
            Action action = map.get(servletPath);
            if(action == null) {
                int index = servletPath.lastIndexOf(SLASH, servletPath.length());
                servletPath = servletPath.substring(0, index);
            } else {
                return action;
            }
        }
        return null;
    }
}
