package com.bsdim.tlj.app.window.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import com.bsdim.tlj.app.user.UserFacade;
import com.bsdim.tlj.app.window.ArticleWindow;
import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.domain.user.User;

/**
 * Represents the article panel.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class ArticlePanel extends JPanel {
    private static final String LIST_TITLE = "List articles";
    private static final String TEXT_TITLE = "Article";
    private static final String NEW_ARTICLE_CAPTION = "New article";
    private static final String EMPTY_STRING = "";
    private static final int WIDTH = 238;
    private static final int HEIGHT = 0;
    private static final int HGAP_PARAMETER = 4;
    private static final int VGAP_PARAMETER = 4;

    private JList<Article> listTitles = new JList<>();
    private JLabel title = new JLabel();
    private JTextArea text = new JTextArea();
    private JButton newArticle;
    private UserFacade userFacade;
    private User user;

    /**
     * Parametrized constructor.
     *
     * @param user the user.
     * @param userFacade the user facade.
     */
    public ArticlePanel(User user, UserFacade userFacade) {
        this.user = user;
        this.userFacade = userFacade;

        setLayout(new BorderLayout(HGAP_PARAMETER, VGAP_PARAMETER));

        JPanel panel = new JPanel(new BorderLayout(HGAP_PARAMETER, VGAP_PARAMETER));
        panel.add(initListComponent(), BorderLayout.WEST);
        panel.add(initTextComponent(), BorderLayout.CENTER);

        newArticle = new JButton(NEW_ARTICLE_CAPTION);
        newArticle.addActionListener(e -> {
            JFrame articleWindow = new ArticleWindow(user, userFacade);
            articleWindow.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshData();
                }
            });
        });
        add(panel, BorderLayout.CENTER);
        add(newArticle, BorderLayout.SOUTH);
    }

    /**
     * Inits the list component.
     *
     * @return the list panel.
     */
    public JComponent initListComponent() {
        listTitles.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        refreshData();
        listTitles.addListSelectionListener(e -> {
            JList<Article> list = (JList<Article>) e.getSource();
            Article article = list.getSelectedValue();
            if (article != null) {
                title.setText("<html><p style=\\\"width:390px\\\">" + article.getTitle() + "</p></html>");
                text.setText(article.getText());
                text.setCaretPosition(0);
            }
        });
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(new TitledBorder(LIST_TITLE));
        listPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        listPanel.add(wrapForScroll(listTitles), BorderLayout.WEST);
        return listPanel;
    }

    /**
     * Inits the text component.
     *
     * @return the text panel.
     */
    public JComponent initTextComponent() {
        text.setLineWrap(true);
        text.setEditable(false);

        JPanel textPanel = new JPanel(new BorderLayout(HGAP_PARAMETER, VGAP_PARAMETER));
        textPanel.setBorder(new TitledBorder(TEXT_TITLE));
        textPanel.add(title, BorderLayout.NORTH);
        textPanel.add(wrapForScroll(text), BorderLayout.CENTER);
        return textPanel;
    }

    /**
     * Sets the scroll.
     *
     * @param component the component.
     * @return the scroll panel.
     */
    public static JComponent wrapForScroll(JComponent component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    /**
     * Refreshes data.
     */
    public void refreshData() {
        DefaultListModel<Article> listModel = new DefaultListModel<>();
        List<Article> articles = userFacade.getArticleByUserId(user.getId());
        for (Article article: articles) {
            listModel.addElement(article);
        }
        listTitles.setModel(listModel);
        listTitles.setCellRenderer(new ArticleCellRenderer());
        title.setText(EMPTY_STRING);
        text.setText(EMPTY_STRING);
    }
    private final class ArticleCellRenderer extends JLabel implements ListCellRenderer {
        private ArticleCellRenderer() {
            setOpaque(true);
        }
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            Article article = (Article) value;
            setText(article.getTitle());
            if (isSelected) {
                setBackground(Color.lightGray);
                setForeground(Color.black);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
            return this;
        }
    }
}
