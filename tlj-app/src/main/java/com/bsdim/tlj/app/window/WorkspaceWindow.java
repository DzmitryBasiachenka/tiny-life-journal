package com.bsdim.tlj.app.window;

import com.bsdim.tlj.domain.user.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WorkspaceWindow extends JFrame {
    public WorkspaceWindow(User userData) {
        super("Workspace window");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initTabsComponent(userData);
        setVisible(true);
    }

    public void initTabsComponent(User user) {
        JTabbedPane tabsPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        tabsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        initUserTabComponent(user, tabsPanel);
        getContentPane().add(tabsPanel);
    }

    public void initUserTabComponent(User user,JTabbedPane tabsPanel) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel userPanel = new JPanel(new GridLayout(3, 3, 3, 5));

        initLoginComponent(userPanel, user);
        initNameComponent(userPanel, user);
        initMailComponent(userPanel, user);

        mainPanel.add(userPanel, BorderLayout.NORTH);
        tabsPanel.add("User", mainPanel);
    }

    public void initLoginComponent(JPanel panel, User user) {
        JLabel login = new JLabel("Login: ");
        JTextField textLogin = new JTextField(user.getLogin());
        textLogin.setEditable(false);
        panel.add(login);
        panel.add(textLogin);
        panel.add(new JLabel());
    }

    public void initNameComponent(JPanel panel, User user) {
        JLabel name = new JLabel("Name: ");
        JTextField textName = new JTextField(user.getName());
        textName.setEditable(false);
        panel.add(name);
        panel.add(textName);
        panel.add(new JLabel());
    }

    public void initMailComponent(JPanel panel, User user) {
        JLabel mail = new JLabel("Mail: ");
        JTextField textMail = new JTextField("Mail");
        textMail.setEditable(false);
        panel.add(mail);
        panel.add(textMail);
        panel.add(new JLabel());
    }
}
