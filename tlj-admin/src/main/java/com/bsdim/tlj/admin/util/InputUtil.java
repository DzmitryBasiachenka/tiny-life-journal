package com.bsdim.tlj.admin.util;

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
}