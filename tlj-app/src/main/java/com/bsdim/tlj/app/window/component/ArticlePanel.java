package com.bsdim.tlj.app.window.component;

import com.bsdim.tlj.app.window.ArticleWindow;
import com.bsdim.tlj.app.window.user.UserFacade;
import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.domain.user.User;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ArticlePanel extends JPanel {
    private static final String LIST_TITLE = "List articles";
    private static final String TEXT_TITLE = "Text article";
    private static final String NEW_ARTICLE_CAPTION = "New article";
    private static final String EMPTY_STRING = "";
    private JList<Article> listTitles = new JList<>();
    private JTextField title = new JTextField();;
    private JTextArea text = new JTextArea();
    private JButton newArticle;
    private UserFacade userFacade;
    private User user;

    public ArticlePanel(User user, UserFacade userFacade) {
        this.user = user;
        this.userFacade = userFacade;

        setLayout(new BorderLayout(2, 2));

        JPanel panel = new JPanel(new BorderLayout(4, 4));
        panel.add(initListComponent(), BorderLayout.WEST);
        panel.add(initTextComponent(), BorderLayout.CENTER);

        newArticle = new JButton(NEW_ARTICLE_CAPTION);
        newArticle.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame articleWindow = new ArticleWindow(user, userFacade);
                articleWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        refreshData();
                    }
                });
            }
        });
        add(panel, BorderLayout.CENTER);
        add(newArticle, BorderLayout.SOUTH);
    }

    public JComponent initListComponent() {
        listTitles.setPreferredSize(new Dimension(238, 0));
        refreshData();
        listTitles.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList<Article> list = (JList<Article>)e.getSource();
                Article article = list.getSelectedValue();
                if(article != null){
                    title.setText(article.getTitle());
                    text.setText(article.getText());
                }
            }
        });
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(new TitledBorder(LIST_TITLE));
        listPanel.setPreferredSize(new Dimension(250, 0));
        listPanel.add(wrapForScroll(listTitles), BorderLayout.WEST);
        return listPanel;
    }

    public JComponent initTextComponent() {
        text.setLineWrap(true);

        JPanel textPanel = new JPanel(new BorderLayout(4,4));
        textPanel.setBorder(new TitledBorder(TEXT_TITLE));
        textPanel.add(title, BorderLayout.NORTH);
        textPanel.add(wrapForScroll(text), BorderLayout.CENTER);
        return textPanel;
    }

    public static JComponent wrapForScroll(JComponent component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

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

   private class ArticleCellRenderer extends JLabel implements ListCellRenderer {
       private ArticleCellRenderer() {
           setOpaque(true);
       }
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            Article article = (Article) value;
            setText(article.getTitle());
            if(isSelected) {
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