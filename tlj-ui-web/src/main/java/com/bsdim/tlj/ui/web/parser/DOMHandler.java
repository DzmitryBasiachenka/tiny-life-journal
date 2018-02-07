package com.bsdim.tlj.ui.web.parser;

import com.bsdim.tlj.domain.article.Article;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * The DOM handler.
 * <p>
 * Date: 2018-01-06
 *
 * @author Dzmitry Basiachenka
 */
public class DOMHandler {
    private static final String ARTICLE_TAG_NAME = "article";
    private static final String TITLE_TAG_NAME = "title";
    private static final String TEXT_TAG_NAME = "text";

    /**
     * Processes the document.
     *
     * @param document the document.
     * @return the article.
     */
    public Article process(Document document) {
        Article article = new Article();
        NodeList node = document.getElementsByTagName(ARTICLE_TAG_NAME);
        Element element = (Element) node.item(0);
        article.setTitle(element.getElementsByTagName(TITLE_TAG_NAME).item(0).getTextContent());
        article.setText(element.getElementsByTagName(TEXT_TAG_NAME).item(0).getTextContent());
        return article;
    }
}
