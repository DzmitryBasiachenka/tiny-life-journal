package com.bsdim.tlj.admin.menu;

import java.util.logging.Logger;

import com.bsdim.tlj.admin.AbstractMenu;

/**
 * The user menu.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class UserMenu extends AbstractMenu {
    private static final String SELECT_ITEM = "Select a menu item";
    private static final String ADD_USER = "1)Add user";
    private static final String SEARCH_USER_BY_ID = "2)Search user by id";
    private static final String UPDATE_USER = "3)Update user";
    private static final String DELETE_USER = "4)Delete user";
    private static final String DISPLAY_USERS = "5)Display all users";
    private static final String SEARCH_USER_BY_LOGIN = "6)Search user by login";
    private static final String EXIT_FROM_MENU = "7)Exit";
    private static Logger sLogger = Logger.getLogger(UserMenu.class.getName());
    @Override
    protected void showMenu() {
        sLogger.info("\n\n");
        sLogger.info(SELECT_ITEM);
        sLogger.info(ADD_USER);
        sLogger.info(SEARCH_USER_BY_ID);
        sLogger.info(UPDATE_USER);
        sLogger.info(DELETE_USER);
        sLogger.info(DISPLAY_USERS);
        sLogger.info(SEARCH_USER_BY_LOGIN);
        sLogger.info(EXIT_FROM_MENU);
    }
}
