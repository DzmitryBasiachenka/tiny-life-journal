package com.bsdim.tlj.domain.user;

import java.io.Serializable;

public class User implements Serializable{
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

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("id: ");
        builder.append(id);
        builder.append("name: ");
        builder.append(name);
        builder.append("login: ");
        builder.append(login);
        builder.append("password: ");
        builder.append(password);
        return builder.toString();
    }
}
