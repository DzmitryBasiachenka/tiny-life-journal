package com.bsdim.tlj.app;

import javax.swing.JFrame;

import com.bsdim.tlj.app.window.LoginWindow;

/**
 * The application starter.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public final class AppStarter {
    private AppStarter() {}

    /**
     * It is a point of input to the application.
     *
     * @param args the string array.
     */
    public static void main(String[] args) {
        JFrame loginWindow = new LoginWindow();
    }
}
