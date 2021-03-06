package com.bsdim.tlj.domain.user;

import java.io.Serializable;

/**
 * The user.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String login;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Converts user to string.
     *
     * @return the data of user.
     */
    public String toString() {
        return new StringBuilder("id: ")
                .append(id)
                .append(" name: ")
                .append(name)
                .append(" login: ")
                .append(login)
                .append(" password: ")
                .append(password)
                .toString();
    }
}
