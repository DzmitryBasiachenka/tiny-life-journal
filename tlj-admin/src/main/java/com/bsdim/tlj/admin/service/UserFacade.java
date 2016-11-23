package com.bsdim.tlj.admin.service;

import static com.bsdim.tlj.admin.util.InputUtil.*;
import com.bsdim.tlj.domain.user.User;

public class UserFacade {

    public void addUser(){
        User objectUser = new User();

        String dataId = inputData("Enter your id: ");
        String dataName = inputData("Enter your name: ");
        String dataLogin = inputData("Enter your login: ");
        String dataPassword = inputData("Enter your password: ");

        objectUser.setId(dataId);
        objectUser.setName(dataName);
        objectUser.setLogin(dataLogin);
        objectUser.setPassword(dataPassword);

        System.out.println(objectUser.toString());
    }
}