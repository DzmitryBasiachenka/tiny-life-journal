package com.bsdim.tlj.ui.web.filter;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.service.user.UserService;
import com.bsdim.tlj.ui.web.session.UserSession;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FilterSecurity implements Filter {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER_SESSION = "userSession";
    private static final String LOGIN_PAGE = "/WEB-INF/view/login_page.jsp";
    private static final String WRONG_USER = "Wrong login or password. Please, input correct data.";
    private static final String WRONG_USER_MESSAGE = "wrongUserMessage";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession(true);

        if (session.getAttribute(USER_SESSION) == null ) {
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);

            if((login == null) || (password == null)) {
                forwardLoginForm(request, response);
                return;
            }

            UserService service = new UserService();
            User user = service.findByLogin(login);

            if ((user != null) && (user.getPassword().equals(password))) {
                UserSession userSession = fillSession(session, user);
                session.setAttribute(USER_SESSION, userSession);
            } else {
                request.setAttribute(WRONG_USER_MESSAGE, WRONG_USER);
                forwardLoginForm(request, response);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private UserSession fillSession(HttpSession session, User user) {
        UserSession userSession = new UserSession();
        userSession.setId(user.getId());
        userSession.setLogin(user.getLogin());
        userSession.setName(user.getName());
        return userSession;
    }

    private void forwardLoginForm(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }

    @Override
    public void destroy() {
    }
}