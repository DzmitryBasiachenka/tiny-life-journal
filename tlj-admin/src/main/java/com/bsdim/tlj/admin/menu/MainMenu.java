package com.bsdim.tlj.admin.menu;

import java.util.List;
import java.util.logging.Logger;

import com.bsdim.tlj.admin.AbstractMenu;
import com.bsdim.tlj.admin.util.InputUtil;
import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.service.user.UserService;

/**
 * Represents main menu.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class MainMenu {
    private static final int CASE_ONE = 1;
    private static final int CASE_TWO = 2;
    private static final int CASE_THREE = 3;
    private static final int CASE_FOUR = 4;
    private static final int CASE_FIVE = 5;
    private static final int CASE_SIX = 6;
    private static final int CASE_SEVEN = 7;
    private static final String ADD_USER = "Add user";
    private static final String SEARCH_USER_BY_ID = "Search user by id";
    private static final String ENTER_ID = "Enter your id: ";
    private static final String USER_NOT_FOUND = "User not found";
    private static final String UPDATE_USER = "Update user";
    private static final String DELETE_USER = "Delete user";
    private static final String SHOW_USERS = "Show all users";
    private static final String SEARCH_USER_BY_LOGIN = "Search user by login";
    private static final String ENTER_LOGIN = "Enter your login: ";
    private static final String GOODBYE = "Goodbye";
    private static final String CHOOSE_AGAIN = "Choose again";
    private static Logger sLogger = Logger.getLogger(MainMenu.class.getName());
    private UserService service = new UserService();

    /**
     * Selects item of the main menu.
     */
    @SuppressWarnings("checkstyle:CyclomaticComplexity")
    public void selectMenu() {
        AbstractMenu userMenu = new UserMenu();

        while (true) {
            int  number = userMenu.performMenu();
            switch (number) {
                case CASE_ONE:
                    sLogger.info(ADD_USER);
                    service.addUser(InputUtil.createDataUser());
                    break;
                case CASE_TWO:
                    sLogger.info(SEARCH_USER_BY_ID);
                    User user = service.findById(InputUtil.inputData(ENTER_ID));
                    if (user == null) {
                        sLogger.info(USER_NOT_FOUND);
                    } else {
                        sLogger.info(user.toString());
                    }
                    break;
                case CASE_THREE:
                    sLogger.info(UPDATE_USER);
                    user = service.findById(InputUtil.inputData(ENTER_ID));
                    service.updateUser(InputUtil.updateDataUser(user));
                    break;
                case CASE_FOUR:
                    sLogger.info(DELETE_USER);
                    service.deleteUser(InputUtil.inputData(ENTER_ID));
                    break;
                case CASE_FIVE:
                    sLogger.info(SHOW_USERS);
                    List<User> users = service.getUsers();
                    for (User info : users) {
                        sLogger.info(info.toString());
                    }
                    break;
                case CASE_SIX:
                    sLogger.info(SEARCH_USER_BY_LOGIN);
                    user = service.findByLogin(InputUtil.inputData(ENTER_LOGIN));
                    if (user == null) {
                        sLogger.info(USER_NOT_FOUND);
                    } else {
                        sLogger.info(user.toString());
                    }
                    break;
                case CASE_SEVEN:
                    sLogger.info(GOODBYE);
                    System.exit(0);
                    break;
                default:
                    sLogger.info(CHOOSE_AGAIN);
                    break;
            }
        }
    }
}
