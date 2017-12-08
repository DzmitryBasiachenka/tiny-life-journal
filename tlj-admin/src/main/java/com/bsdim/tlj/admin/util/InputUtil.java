package com.bsdim.tlj.admin.util;

import java.util.Scanner;
import java.util.logging.Logger;

import com.bsdim.tlj.domain.user.User;

/**
 * The input of data.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public final class InputUtil {
    private static Scanner sScanner = new Scanner(System.in);
    private static Logger sLogger = Logger.getLogger(InputUtil.class.getName());

    private InputUtil() {}
    public static Scanner getScanner() {
        return sScanner;
    }

    /**
     * Inputs data.
     *
     * @param message the message.
     * @return inputed data.
     */
    public static String inputData(String message) {
        sLogger.info(message);
        return sScanner.nextLine();
    }

    /**
     * Creates the user data.
     *
     * @return the user.
     */
    public static User createDataUser() {
        User user = new User();

        user.setId(inputData("Enter your id: "));
        user.setName(inputData("Enter your name: "));
        user.setLogin(inputData("Enter your login: "));
        user.setPassword(inputData("Enter your password: "));

        return user;
    }

    /**
     * The method updates the user data.
     *
     * @param user the user.
     * @return the user which was updated.
     */
    public static User updateDataUser(User user) {
        user.setName(inputData("Enter your name: "));
        user.setLogin(inputData("Enter your login: "));
        user.setPassword(inputData("Enter your password: "));

        return user;
    }
}
