package com.bsdim.tlj.app.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.bsdim.tlj.app.LengthRestrictedDocument;
import com.bsdim.tlj.app.user.UserFacade;
import com.bsdim.tlj.app.window.component.ArticlePanel;
import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.domain.user.User;

/**
 * Represents the article window.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class ArticleWindow extends JFrame {
    private static final String TITLE_BORDER = "Title";
    private static final String TEXT_BORDER = "Text";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int COLUMNS = 80;
    private static final int LIMIT = 128;
    private static final int ROWS_GRID_LAYOUT = 1;
    private static final int COLS_GRID_LAYOUT = 4;
    private static final int HGAP_GRID_LAYOUT = 4;
    private static final int VGAP_GRID_LAYOUT = 1;
    private Article article = new Article();
    private JTextArea title;
    private JTextArea text;
    private UserFacade userFacade;
    private User user;

    /**
     * Parametrized constructor.
     *
     * @param user the user.
     * @param userFacade the user facade.
     */
    public ArticleWindow(User user, UserFacade userFacade) {
        super("New article");
        this.user = user;
        this.userFacade = userFacade;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        getContentPane().add(initComponents());
        setVisible(true);
    }

    /**
     * Initializes all components for the article window.
     *
     * @return the window panel.
     */
    public JPanel initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Article"));

        panel.add(initTitleComponent(), BorderLayout.NORTH);
        panel.add(initTextComponent(), BorderLayout.CENTER);
        panel.add(initButtonsComponent(), BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Initializes the title component.
     *
     * @return the title panel.
     */
    public JPanel initTitleComponent() {
        title = initTextArea(2, COLUMNS);
        JPanel titlePanel = new JPanel(new BorderLayout());
        title.setDocument(new LengthRestrictedDocument(LIMIT));
        titlePanel.setBorder(new TitledBorder(TITLE_BORDER));
        titlePanel.add(ArticlePanel.wrapForScroll(title), BorderLayout.NORTH);
        return titlePanel;
    }

    /**
     * Initializes the text component.
     *
     * @return the text panel.
     */
    public JPanel initTextComponent() {
        text = initTextArea();
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(new TitledBorder(TEXT_BORDER));
        textPanel.add(ArticlePanel.wrapForScroll(text), BorderLayout.CENTER);
        return textPanel;
    }

    /**
     * Initializes the button component.
     *
     * @return the button panel.
     */
    public  JPanel initButtonsComponent() {
        JPanel buttonsPanel = new JPanel(new GridLayout(ROWS_GRID_LAYOUT, COLS_GRID_LAYOUT,
                HGAP_GRID_LAYOUT, VGAP_GRID_LAYOUT));
        JButton save = new JButton("Save");
        save.addActionListener(event -> {
            saveArticle();
            JOptionPane.showMessageDialog(null, String.format("Saved"));
            dispose();
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(event -> {
            dispose();
        });
        buttonsPanel.add(new JLabel());
        buttonsPanel.add(new JLabel());
        buttonsPanel.add(save);
        buttonsPanel.add(cancel);
        return buttonsPanel;
    }

    /**
     * Initializes the text area.
     *
     * @param rows the rows for the text area.
     * @param columns the columns for the text area.
     * @return the text area.
     */
    public JTextArea initTextArea(int rows, int columns) {
        JTextArea area = new JTextArea(rows, columns);
        area.setLineWrap(true);
        area.setEditable(true);
        return area;
    }

    /**
     * Initializes the text area.
     *
     * @return the text area.
     */
    public JTextArea initTextArea() {
        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setEditable(true);
        return area;
    }

    /**
     * Saves the articles to the data base.
     */
    public void saveArticle() {
        article.setTitle(title.getText());
        article.setText(text.getText());
        article.setUserId(user.getId());
        article.setId(UUID.randomUUID().toString());
        userFacade.addArticle(article);
    }
}
