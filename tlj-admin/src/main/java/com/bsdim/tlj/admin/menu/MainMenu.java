package com.bsdim.tlj.admin.menu;

import com.bsdim.tlj.admin.AbstractMenu;
import com.bsdim.tlj.service.user.UserService;
import com.bsdim.tlj.domain.user.User;

import java.util.List;

import static com.bsdim.tlj.admin.util.InputUtil.*;

public class MainMenu {
    private UserService service = new UserService();

    public String selectMenu() {
        AbstractMenu userMenu = new UserMenu();

        while (true) {
            int  number = userMenu.performMenu();
            switch (number) {
                case 1:
                    System.out.println("Add user");
                    service.addUser(createDataUser());
                    continue;
                case 2:
                    System.out.println("Show all users");
                    List<User> users = service.getUsers();
                    for(User info : users) {
                        System.out.println(info);
                    }
                    continue;
                case 3:
                    System.out.println("Delete user");
                    service.deleteUser(inputData("Enter your id: "));
                    continue;
                case 4:
                    System.out.println("Search user by login");
                    User user = service.findByLogin(inputData("Enter your login: "));
                    if (user == null) {
                        System.out.println("User not found");
                    } else {
                        System.out.println(user);
                    }
                    continue;
                case 5:
                    System.out.println("Search user by id");
                    user = service.findById(inputData("Enter your id: "));
                    if (user == null) {
                        System.out.println("User not found");
                    } else {
                        System.out.println(user);
                    }
                    continue;
                case 6:
                    System.out.println("Bye-bye");
                    System.exit(0);
                default:
                    System.out.println("Choose again");
                    continue;
            }
        }
    }
}
