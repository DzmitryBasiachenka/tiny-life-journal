package com.bsdim.tlj.admin.menu;

import com.bsdim.tlj.admin.AbstractMenu;
import com.bsdim.tlj.admin.service.UserFacade;

public class MainMenu {
    private UserFacade objectUserFacade = new UserFacade();

    public String selectMenu() {
        AbstractMenu userMenu = new UserMenu();
        while (true) {
            int  number = userMenu.performMenu();
            switch (number) {
                case 1:
                    objectUserFacade.addUser();
                    System.out.println("Add user");
                    continue;
                case 2:
                    System.out.println("Show all users");
                    continue;
                case 3:
                    System.out.println("Delete user");
                    continue;
                case 4:
                    System.out.println("Bye-bye");
                    System.exit(0);
                default:
                    System.out.println("Choose again");
                    continue;
            }
        }
    }
}
