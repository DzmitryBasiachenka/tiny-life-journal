package com.bsdim.tlj.repository;

import com.bsdim.tlj.domain.article.Article;

import java.util.List;

public interface IArticleRepository extends ICrud<String, Article> {
    List<Article> findByUserId(String userId);
}
