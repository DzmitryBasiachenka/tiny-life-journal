package com.bsdim.tlj.service.article;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.repository.article.ArticleRepository;

import java.util.List;

public class ArticleService {
    private ArticleRepository repository = new ArticleRepository();

    public void create(Article article) {
        repository.create(article);
    }

    public Article read(String id) {
        return repository.read(id);
    }

    public void update(Article article) {
        repository.update(article);
    }

    public void delete(String id) {
        repository.delete(id);
    }

    public List<Article> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
