package com.bsdim.tlj.app.window.user;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.service.user.UserService;

public class UserFacade {
    private UserService service = new UserService();

    public User getUser (String login, String password) {
        User user = service.findByLogin(login);
        if ((user != null) && (user.getPassword().equals(password))) {
                return user;
            }
        return null;
    }
}
