package com.bsdim.tlj.app.window;

import com.bsdim.tlj.app.window.user.UserFacade;
import com.bsdim.tlj.domain.user.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;

public class LoginWindow extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;
    private UserFacade user = new UserFacade();

    public LoginWindow(){
        super("Authorization manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));

        JLabel loginLabel = new JLabel("Login:");
        mainBox.add(initLoginComponent(loginLabel));
        mainBox.add(Box.createVerticalStrut(12));

        JLabel passwordLabel = new JLabel("Password:");
        mainBox.add(initPasswordComponent(passwordLabel));
        mainBox.add(Box.createVerticalStrut(17));

        mainBox.add(initButtonsComponent());

        setContentPane(mainBox);
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        setResizable(false);
        pack();
    }

    public Box initLoginComponent(JLabel loginLabel) {
        Box login = Box.createHorizontalBox();
        loginField = new JTextField(15);
        login.add(loginLabel);
        login.add(Box.createHorizontalStrut(6));
        login.add(loginField);
        return login;
    }

    public Box initPasswordComponent(JLabel passwordLabel) {
        Box password = Box.createHorizontalBox();
        passwordField = new JPasswordField(15);
        password.add(passwordLabel);
        password.add(Box.createHorizontalStrut(6));
        password.add(passwordField);
        return password;
    }

    public Box initButtonsComponent() {
        Box buttons = Box.createHorizontalBox();
        JButton ok = new JButton("OK");
        ok.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User userData = user.getUser(loginField.getText(), new String(passwordField.getPassword()));
                if (userData == null) {
                    JOptionPane.showMessageDialog(null, String.format("Sorry, user %1$s not found.", loginField.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, String.format("Welcome %1$s!", userData.getName()));
                    new WorkspaceWindow(userData);
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttons.add(Box.createHorizontalGlue());
        buttons.add(ok);
        buttons.add(Box.createHorizontalStrut(12));
        buttons.add(cancel);
        return buttons;
    }
}
