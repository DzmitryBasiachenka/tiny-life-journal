package com.bsdim.tlj.admin.menu;

import com.bsdim.tlj.admin.AbstractMenu;
import com.bsdim.tlj.admin.FileProcessing;
import com.bsdim.tlj.admin.service.UserFacade;
import com.bsdim.tlj.domain.user.User;

import java.util.List;

public class MainMenu {
    private UserFacade objectUserFacade = new UserFacade();

    public String selectMenu() {
        AbstractMenu userMenu = new UserMenu();
        FileProcessing objectReadFile = new FileProcessing();

        while (true) {
            int  number = userMenu.performMenu();
            switch (number) {
                case 1:
                    System.out.println("Add user");
                    objectUserFacade.addUser();
                    continue;
                case 2:
                    System.out.println("Show all users");
                    List<User> newCollection = objectReadFile.readFile();
                    for(User info : newCollection){
                        System.out.println(info);
                    }
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
