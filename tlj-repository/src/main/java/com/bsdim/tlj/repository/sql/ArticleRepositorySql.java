package com.bsdim.tlj.repository.sql;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.repository.connection.ConnectionManager;
import com.bsdim.tlj.repository.IArticleRepository;
import com.bsdim.tlj.repository.exception.RepositoryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepositorySql implements IArticleRepository {
    private static final String CREATE_ARTICLE = "insert into article(title, text, userId, id) values(?, ?, ?, ?)";
    private static final String READ_ARTICLE = "select id, title, text, userId from article where id = ?";
    private static final String UPDATE_ARTICLE = "update article set title = ?, text = ? where id = ?";
    private static final String DELETE_ARTICLE = "delete from article where id = ?";
    private static final String FIND_BY_USERID = "select id, title, text, userId from article where userId = ?";

    private Connection connection = ConnectionManager.getInstance().getConnection();

    @Override
    public void create(Article article) {
        addValues(article, CREATE_ARTICLE);
    }

    @Override
    public Article read(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ARTICLE);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Article article = new Article();
            while (resultSet.next()) {
                article.setId(resultSet.getString("id"));
                article.setTitle(resultSet.getString("title"));
                article.setText(resultSet.getString("text"));
                article.setUserId(resultSet.getString("userId"));
            }
            return article;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void update(Article article) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ARTICLE);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getText());
            preparedStatement.setString(3, article.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ARTICLE);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<Article> findByUserId(String userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERID);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Article> listArticles = new ArrayList<>();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getString("id"));
                article.setTitle(resultSet.getString("title"));
                article.setText(resultSet.getString("text"));
                article.setUserId(resultSet.getString("userId"));
                listArticles.add(article);
            }
            return listArticles;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    private void addValues(Article article, String request) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getText());
            preparedStatement.setString(3, article.getUserId());
            preparedStatement.setString(4, article.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}