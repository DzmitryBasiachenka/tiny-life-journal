package com.bsdim.tlj.repository;

import java.util.List;

import com.bsdim.tlj.domain.article.Article;

/**
 * The article repository.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public interface IArticleRepository extends ICrud<String, Article> {
    /**
     * Finds the list of articles by user id.
     *
     * @param userId the user id.
     * @return the list of articles.
     */
    List<Article> findByUserId(String userId);
}
