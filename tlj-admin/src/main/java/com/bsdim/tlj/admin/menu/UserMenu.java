package com.bsdim.tlj.admin.menu;

import com.bsdim.tlj.admin.AbstractMenu;

public class UserMenu extends AbstractMenu {
    @Override
    protected void showMenu() {
        System.out.println("\n\n\n");
        System.out.println("Select a menu item");
        System.out.println("1)Add user");
        System.out.println("2)Display all users");
        System.out.println("3)Delete user");
        System.out.println("4)Exit");

    }
}
