package com.bsdim.tlj.admin.util;

import com.bsdim.tlj.domain.user.User;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static String inputData(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static User createDataUser() {
        User user = new User();

        user.setId(inputData("Enter your id: "));
        user.setName(inputData("Enter your name: "));
        user.setLogin(inputData("Enter your login: "));
        user.setPassword(inputData("Enter your password: "));

        return user;
    }
}