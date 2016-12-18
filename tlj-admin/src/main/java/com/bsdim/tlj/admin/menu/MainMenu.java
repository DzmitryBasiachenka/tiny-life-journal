package com.bsdim.tlj.admin.menu;

import com.bsdim.tlj.admin.AbstractMenu;
import com.bsdim.tlj.admin.service.UserFacade;
import com.bsdim.tlj.domain.user.User;

import java.util.List;


public class MainMenu {
    private UserFacade objectUserFacade = new UserFacade();

    public String selectMenu() {
        AbstractMenu userMenu = new UserMenu();

        while (true) {
            int  number = userMenu.performMenu();
            switch (number) {
                case 1:
                    System.out.println("Add user");
                    objectUserFacade.addUser();
                    continue;
                case 2:
                    System.out.println("Show all users");
                    List<User> users = objectUserFacade.getUsers();
                    for(User info : users){
                        System.out.println(info);
                    }
                    continue;
                case 3:
                    System.out.println("Delete user");
                    objectUserFacade.deleteUser();
                    continue;
                case 4:
                    User user = objectUserFacade.searchUser();
                    if (user == null){
                        System.out.println("User not found");
                    }else {
                        System.out.println(user);
                    }
                    continue;
                case 5:
                    System.out.println("Bye-bye");
                    System.exit(0);
                default:
                    System.out.println("Choose again");
                    continue;
            }
        }
    }
}
