package com.bsdim.tlj.app.window.component;

import com.bsdim.tlj.domain.user.User;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    private static final String LOGIN_TITLE = "Login";
    private static final String NAME_TITLE = "Name";
    private static final String MAIL_TITLE = "Mail";

    private JLabel statusLabel;
    private JTextField text;

    public UserPanel(User user) {
        setLayout(new BorderLayout());

        JPanel userPanel = new JPanel(new GridLayout(3, 3, 3, 5));

        initLoginComponent(userPanel, user);
        initNameComponent(userPanel, user);
        initMailComponent(userPanel, user);

        add(userPanel, BorderLayout.NORTH);
    }

    public void initLoginComponent(JPanel panel, User user) {
        statusLabel = new JLabel(LOGIN_TITLE);
        text = new JTextField(user.getLogin());
        text.setEditable(false);
        panel.add(statusLabel);
        panel.add(text);
        panel.add(new JLabel());
    }

    public void initNameComponent(JPanel panel, User user) {
        statusLabel = new JLabel(NAME_TITLE);
        text = new JTextField(user.getName());
        text.setEditable(false);
        panel.add(statusLabel);
        panel.add(text);
        panel.add(new JLabel());
    }

    public void initMailComponent(JPanel panel, User user) {
        statusLabel = new JLabel(MAIL_TITLE);
        text = new JTextField();
        text.setEditable(false);
        panel.add(statusLabel);
        panel.add(text);
        panel.add(new JLabel());
    }
}
