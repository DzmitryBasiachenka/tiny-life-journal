package com.bsdim.tlj.admin.service;

import com.bsdim.tlj.admin.InputUtil;
import com.bsdim.tlj.domain.user.User;

public class UserFacade {

    public void addUser(){
        User objectUser = new User();

        String dataId = InputUtil.inputData("Enter your id: ");
        String dataName = InputUtil.inputData("Enter your name: ");
        String dataLogin = InputUtil.inputData("Enter your login: ");
        String dataPassword = InputUtil.inputData("Enter your password: ");

        objectUser.setId(dataId);
        objectUser.setName(dataName);
        objectUser.setLogin(dataLogin);
        objectUser.setPassword(dataPassword);

        System.out.println(objectUser.toString());
    }
}