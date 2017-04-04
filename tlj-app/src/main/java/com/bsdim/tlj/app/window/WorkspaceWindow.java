package com.bsdim.tlj.app.window;

import com.bsdim.tlj.app.window.component.ArticlePanel;
import com.bsdim.tlj.app.window.component.UserPanel;
import com.bsdim.tlj.app.user.UserFacade;
import com.bsdim.tlj.domain.user.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class WorkspaceWindow extends JFrame {
    private static final String USER_PANEL_CAPTION = "User";
    private static final String ARTICLE_PANEL_CAPTION = "Article";

    private UserFacade userFacade;

    public WorkspaceWindow(User userData, UserFacade userFacade) {
        super("Workspace window");
        this.userFacade = userFacade;
        initTabsComponent(userData);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initTabsComponent(User user) {
        JTabbedPane tabsPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        tabsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        tabsPanel.add(USER_PANEL_CAPTION, new UserPanel(user));
        tabsPanel.add(ARTICLE_PANEL_CAPTION, new ArticlePanel(user, userFacade));
        getContentPane().add(tabsPanel);
    }
}
