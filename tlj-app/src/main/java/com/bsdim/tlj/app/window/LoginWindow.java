package com.bsdim.tlj.app.window;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bsdim.tlj.app.user.UserFacade;
import com.bsdim.tlj.domain.user.User;

/**
 * Represents the login window.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class LoginWindow extends JFrame {
    private static final int EMPTY_BORDER_PARAMETER = 12;
    private static final int HEIGHT_VERTICAL_STRUT_LOGIN = 12;
    private static final int HEIGHT_VERTICAL_STRUT_PASSWORD = 17;
    private static final int COLUMNS_TEXT_FIELD = 15;
    private static final int WIDTH_HORIZONTAL_STRUT_LOGIN = 6;
    private static final int COLUMNS_PASSWORD_FIELD = 15;
    private static final int WIDTH_HORIZONTAL_STRUT_PASSWORD = 6;
    private static final int WIDTH_HORIZONTAL_STRUT_BUTTONS = 12;
    private JTextField loginField;
    private JPasswordField passwordField;
    private UserFacade userFacade = new UserFacade();

    /**
     * The constructor.
     */
    public LoginWindow() {
        super("Authorization manager");
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inits the components.
     */
    public void initComponents() {
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(EMPTY_BORDER_PARAMETER, EMPTY_BORDER_PARAMETER,
                EMPTY_BORDER_PARAMETER, EMPTY_BORDER_PARAMETER));

        JLabel loginLabel = new JLabel("Login:");
        mainBox.add(initLoginComponent(loginLabel));
        mainBox.add(Box.createVerticalStrut(HEIGHT_VERTICAL_STRUT_LOGIN));

        JLabel passwordLabel = new JLabel("Password:");
        mainBox.add(initPasswordComponent(passwordLabel));
        mainBox.add(Box.createVerticalStrut(HEIGHT_VERTICAL_STRUT_PASSWORD));

        mainBox.add(initButtonsComponent());

        setContentPane(mainBox);
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        setResizable(false);
        pack();
    }

    /**
     * Inits the login component.
     *
     * @param loginLabel the login label.
     * @return the box.
     */
    public Box initLoginComponent(JLabel loginLabel) {
        Box login = Box.createHorizontalBox();
        loginField = new JTextField(COLUMNS_TEXT_FIELD);
        login.add(loginLabel);
        login.add(Box.createHorizontalStrut(WIDTH_HORIZONTAL_STRUT_LOGIN));
        login.add(loginField);
        return login;
    }

    /**
     * Inits the password component.
     *
     * @param passwordLabel the password label.
     * @return the box.
     */
    public Box initPasswordComponent(JLabel passwordLabel) {
        Box password = Box.createHorizontalBox();
        passwordField = new JPasswordField(COLUMNS_PASSWORD_FIELD);
        password.add(passwordLabel);
        password.add(Box.createHorizontalStrut(WIDTH_HORIZONTAL_STRUT_PASSWORD));
        password.add(passwordField);
        return password;
    }

    /**
     * Inits the button component.
     *
     * @return the box.
     */
    public Box initButtonsComponent() {
        Box buttons = Box.createHorizontalBox();
        JButton buttonOk = new JButton("OK");
        buttonOk.addActionListener(event -> {
            User userData = userFacade.getUser(loginField.getText(), new String(passwordField.getPassword()));
            if (userData == null) {
                JOptionPane.showMessageDialog(null,
                        String.format("Sorry, user %1$s not found.", loginField.getText()));
            } else {
                JOptionPane.showMessageDialog(null, String.format("Welcome %1$s!", userData.getName()));
                new WorkspaceWindow(userData, userFacade);
                dispose();
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(event -> {
            dispose(); });

        buttons.add(Box.createHorizontalGlue());
        buttons.add(buttonOk);
        buttons.add(Box.createHorizontalStrut(WIDTH_HORIZONTAL_STRUT_BUTTONS));
        buttons.add(cancel);
        return buttons;
    }
}
