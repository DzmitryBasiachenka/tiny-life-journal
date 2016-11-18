package com.bsdim.tlj.admin.service;

import com.bsdim.tlj.domain.user.User;

import java.util.Scanner;

public class UserFacade {
    private Scanner in = new Scanner(System.in);

    public void addUser(){
        User objectUser = new User();
        System.out.print("Enter your id: ");
        String dataId = in.nextLine();
        System.out.print("Enter your name: ");
        String dataName = in.nextLine();
        System.out.print("Enter your login: ");
        String dataLogin = in.nextLine();
        System.out.print("Enter your password: ");
        String dataPassword = in.nextLine();

        objectUser.setId(dataId);
        objectUser.setName(dataName);
        objectUser.setLogin(dataLogin);
        objectUser.setPassword(dataPassword);

        System.out.println("id: " + objectUser.getId());
        System.out.println("name: " + objectUser.getName());
        System.out.println("login: " + objectUser.getLogin());
        System.out.println("password: " + objectUser.getPassword());
    }
}