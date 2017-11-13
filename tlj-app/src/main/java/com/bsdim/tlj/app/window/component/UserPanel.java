package com.bsdim.tlj.app.window.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bsdim.tlj.domain.user.User;

/**
 * Represents the user panel.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class UserPanel extends JPanel {
    private static final String LOGIN_TITLE = "Login";
    private static final String NAME_TITLE = "Name";
    private static final String MAIL_TITLE = "Mail";
    private static final int ROWS_PARAMETER = 3;
    private static final int COLS_PARAMETER = 3;
    private static final int HGAP_PARAMETER = 3;
    private static final int VGAP_PARAMETER = 5;

    private JLabel statusLabel;
    private JTextField text;

    /**
     * Parametrized constructor.
     *
     * @param user the user.
     */
    public UserPanel(User user) {
        setLayout(new BorderLayout());

        JPanel userPanel = new JPanel(new GridLayout(ROWS_PARAMETER, COLS_PARAMETER, HGAP_PARAMETER, VGAP_PARAMETER));

        initLoginComponent(userPanel, user);
        initNameComponent(userPanel, user);
        initMailComponent(userPanel, user);

        add(userPanel, BorderLayout.NORTH);
    }

    /**
     * Inits the login component.
     *
     * @param panel the panel.
     * @param user the user.
     */
    public void initLoginComponent(JPanel panel, User user) {
        statusLabel = new JLabel(LOGIN_TITLE);
        text = new JTextField(user.getLogin());
        text.setEditable(false);
        panel.add(statusLabel);
        panel.add(text);
        panel.add(new JLabel());
    }

    /**
     * Inits the name component.
     *
     * @param panel the panel.
     * @param user the user.
     */
    public void initNameComponent(JPanel panel, User user) {
        statusLabel = new JLabel(NAME_TITLE);
        text = new JTextField(user.getName());
        text.setEditable(false);
        panel.add(statusLabel);
        panel.add(text);
        panel.add(new JLabel());
    }

    /**
     * Inits the mail component.
     *
     * @param panel the panel.
     * @param user the user.
     */
    public void initMailComponent(JPanel panel, User user) {
        statusLabel = new JLabel(MAIL_TITLE);
        text = new JTextField();
        text.setEditable(false);
        panel.add(statusLabel);
        panel.add(text);
        panel.add(new JLabel());
    }
}
