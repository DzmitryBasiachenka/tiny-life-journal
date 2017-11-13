package com.bsdim.tlj.service.article;

import java.util.List;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.repository.IArticleRepository;
import com.bsdim.tlj.repository.sql.ArticleRepositorySql;

/**
 * The article service.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class ArticleService {
    private IArticleRepository repository = new ArticleRepositorySql();

    /**
     * Creates the article.
     *
     * @param article the article.
     */
    public void create(Article article) {
        repository.create(article);
    }

    /**
     * Reads the article.
     *
     * @param id the article id.
     * @return the article.
     */
    public Article read(String id) {
        return repository.read(id);
    }

    /**
     * Updates the article.
     *
     * @param article the article.
     */
    public void update(Article article) {
        repository.update(article);
    }

    /**
     * Deletes the article.
     *
     * @param id the article.
     */
    public void delete(String id) {
        repository.delete(id);
    }

    /**
     * Finds list of articles by user id.
     *
     * @param userId the user id.
     * @return the list of articles.
     */
    public List<Article> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
