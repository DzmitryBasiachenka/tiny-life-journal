package com.bsdim.tlj.admin.service;

import static com.bsdim.tlj.admin.util.InputUtil.*;

import com.bsdim.tlj.admin.FileProcessing;
import com.bsdim.tlj.domain.user.User;
import java.util.ArrayList;

public class UserFacade {
    private FileProcessing objectFileProcessing = new FileProcessing();
    private ArrayList<User> collection = new ArrayList();

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

        collection.add(objectUser);
        objectFileProcessing.writeFile(collection);

        System.out.println(objectUser.toString());
    }
}