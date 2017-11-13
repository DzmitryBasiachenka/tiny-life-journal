package com.bsdim.tlj.admin;

import com.bsdim.tlj.admin.menu.MainMenu;

/**
 * The admin starter.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public final class AdminStarter {
    private AdminStarter() {}

    /**
     * It is a point of input to the admin.
     *
     * @param args the string array.
     */
    public static void main(String[] args) {
        new MainMenu().selectMenu();
    }
}
