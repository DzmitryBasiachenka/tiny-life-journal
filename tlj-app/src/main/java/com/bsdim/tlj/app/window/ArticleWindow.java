package com.bsdim.tlj.app.window;

import com.bsdim.tlj.app.window.component.ArticlePanel;
import com.bsdim.tlj.app.window.user.UserFacade;
import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.domain.user.User;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.UUID;

public class ArticleWindow extends JFrame {
    private final static String TITLE = "Title";
    private final static String TEXT = "Text";
    private Article article = new Article();
    private JTextField title;
    private JTextArea text;
    private UserFacade userFacade;
    private User user;

    public ArticleWindow(User user, UserFacade userFacade) {
        super("New article");
        this.user = user;
        this.userFacade = userFacade;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(initComponents());
        setSize(800, 600);
        setVisible(true);
    }

    public JPanel initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Article"));

        panel.add(initTitleComponent(), BorderLayout.NORTH);
        panel.add(initTextComponent(), BorderLayout.CENTER);
        panel.add(initButtonsComponent(), BorderLayout.SOUTH);
        return panel;
    }

    public JPanel initTitleComponent() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        title = new JTextField();
        title.setDocument(new LengthRestrictedDocument(70));
        titlePanel.setBorder(new TitledBorder(TITLE));
        titlePanel.add(ArticlePanel.wrapForScroll(title), BorderLayout.NORTH);
        return titlePanel;
    }

    public JPanel initTextComponent() {
        JPanel textPanel = new JPanel(new BorderLayout());
        text = initTextArea();
        textPanel.setBorder(new TitledBorder(TEXT));
        textPanel.add(ArticlePanel.wrapForScroll(text), BorderLayout.CENTER);
        return textPanel;
    }

    public  JPanel initButtonsComponent() {
        JPanel buttonsPanel = new JPanel(new GridLayout(1,4,4,1));

        JButton save = new JButton("Save");
        save.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveArticle();
                JOptionPane.showMessageDialog(null, String.format("Saved"));
                dispose();
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonsPanel.add(new JLabel());
        buttonsPanel.add(new JLabel());
        buttonsPanel.add(save);
        buttonsPanel.add(cancel);
        return buttonsPanel;
    }

    public JTextArea initTextArea() {
        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setEditable(true);
        return area;
    }

    public void saveArticle() {
        article.setTitle(title.getText());
        article.setText(text.getText());
        article.setUserId(user.getId());
        article.setId(UUID.randomUUID().toString());
        userFacade.addArticle(article);
    }

    private final class LengthRestrictedDocument extends PlainDocument {
        private final int limit;

        private LengthRestrictedDocument(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (str == null){
                return;
            }
            if ((getLength() + str.length()) <= limit) {
                super.insertString(offs, str, a);
            }
        }
    }
}