package com.bsdim.tlj.app.window;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import com.bsdim.tlj.app.user.UserFacade;
import com.bsdim.tlj.app.window.component.ArticlePanel;
import com.bsdim.tlj.app.window.component.UserPanel;
import com.bsdim.tlj.domain.user.User;

/**
 * Represents the workspace window.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class WorkspaceWindow extends JFrame {
    private static final String USER_PANEL_CAPTION = "User";
    private static final String ARTICLE_PANEL_CAPTION = "Article";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER = 5;

    private UserFacade userFacade;

    /**
     * Parametrized constructor.
     *
     * @param userData the user data.
     * @param userFacade the user facade.
     */
    public WorkspaceWindow(User userData, UserFacade userFacade) {
        super("Workspace window");
        this.userFacade = userFacade;
        initTabsComponent(userData);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inits the tabs component.
     *
     * @param user the user.
     */
    public void initTabsComponent(User user) {
        JTabbedPane tabsPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        tabsPanel.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));

        tabsPanel.add(USER_PANEL_CAPTION, new UserPanel(user));
        tabsPanel.add(ARTICLE_PANEL_CAPTION, new ArticlePanel(user, userFacade));
        getContentPane().add(tabsPanel);
    }
}
