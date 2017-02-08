package com.bsdim.tlj.repository.article;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.repository.FileRepository;
import com.bsdim.tlj.repository.ICrud;

import java.util.List;

public class ArticleRepository extends FileRepository<Article> implements ICrud<String, Article> {
    public ArticleRepository() {
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
}
