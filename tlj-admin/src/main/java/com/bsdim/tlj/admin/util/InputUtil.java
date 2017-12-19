package com.bsdim.tlj.admin.util;

import java.util.Scanner;
import java.util.logging.Logger;

import com.bsdim.tlj.domain.user.User;
import org.apache.commons.lang3.StringUtils;

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
        String data;
        do {
            sLogger.info(message);
            data = sScanner.nextLine();
        } while (StringUtils.isBlank(data));
        return data;
    }

    /**
     * Creates the user data.
     *
     * @return the user.
     */
    public static User createDataUser() {
        User user = new User();

        String userId = inputData("Enter your id: ");
        String name = inputData("Enter your name: ");
        String login = inputData("Enter your login: ");
        String password = inputData("Enter your password: ");

        user.setId(userId);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);

        return user;
    }

    /**
     * The method updates the user data.
     *
     * @param user the user.
     * @return the user which was updated.
     */
    public static User updateDataUser(User user) {
        String name = inputData("Enter your name: ");
        String login = inputData("Enter your login: ");
        String password = inputData("Enter your password: ");

        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);

        return user;
    }
}
