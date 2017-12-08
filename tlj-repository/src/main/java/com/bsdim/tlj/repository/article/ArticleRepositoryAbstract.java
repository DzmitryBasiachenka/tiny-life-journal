package com.bsdim.tlj.repository.article;

import java.util.ArrayList;
import java.util.List;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.repository.ICrud;
import com.bsdim.tlj.repository.file.AbstractFileRepository;

/**
 * The article repository abstract.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class ArticleRepositoryAbstract extends AbstractFileRepository<Article> implements ICrud<String, Article> {

    /**
     * The constructor.
     */
    public ArticleRepositoryAbstract() {
        super("articles.dat");
    }

    @Override
    public void create(Article article) {
        List<Article> articles = readData();
        articles.add(article);
        writeData(articles);
    }

    @Override
    public Article read(String id) {
        List<Article> articles = readData();
        for (Article article: articles) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    @Override
    public void update(Article article) {
        List<Article> articles = readData();
        for (int i = 0; i < articles.size(); i++) {
            Article articleId = articles.get(i);
            if (articleId.getId().equals(article.getId())) {
                articles.set(i, article);
                break;
            }
        }
        writeData(articles);
    }

    @Override
    public void delete(String id) {
        List<Article> articles = readData();
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getId().equals(id)) {
                articles.remove(i);
                break;
            }
        }
        writeData(articles);
    }

    /**
     * Finds the list of articles by user id.
     *
     * @param userId the user id.
     * @return the list of articles.
     */
    public List<Article> findByUserId(String userId) {
        List<Article> articles = readData();
        List<Article> articlesUser = new ArrayList<>();
        for (Article article: articles) {
            if (article.getUserId().equals(userId)) {
                articlesUser.add(article);
            }
        }
        return articlesUser;
    }
}
