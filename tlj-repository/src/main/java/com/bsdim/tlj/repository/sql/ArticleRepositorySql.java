package com.bsdim.tlj.repository.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.repository.IArticleRepository;
import com.bsdim.tlj.repository.connection.ConnectionManager;
import com.bsdim.tlj.repository.exception.RepositoryException;

/**
 * The article repository sql.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class ArticleRepositorySql implements IArticleRepository {
    private static final String CREATE_ARTICLE = "insert into article(title, text, user_id, id) values(?, ?, ?, ?)";
    private static final String READ_ARTICLE = "select id, title, text, user_id from article where id = ?";
    private static final String UPDATE_ARTICLE = "update article set title = ?, text = ? where id = ?";
    private static final String DELETE_ARTICLE = "delete from article where id = ?";
    private static final String FIND_BY_USERID = "select id, title, text, user_id from article where user_id = ?";
    private static final int PARAMETER_INDEX_ONE = 1;
    private static final int PARAMETER_INDEX_TWO = 2;
    private static final int PARAMETER_INDEX_THREE = 3;
    private static final int PARAMETER_INDEX_FOUR = 4;

    private Connection connection = ConnectionManager.getInstance().getConnection();

    @Override
    public void create(Article article) {
        addValues(article, CREATE_ARTICLE);
    }

    @Override
    public Article read(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ARTICLE);
            preparedStatement.setString(PARAMETER_INDEX_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Article article = new Article();
            while (resultSet.next()) {
                article.setId(resultSet.getString("id"));
                article.setTitle(resultSet.getString("title"));
                article.setText(resultSet.getString("text"));
                article.setUserId(resultSet.getString("user_id"));
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
            preparedStatement.setString(PARAMETER_INDEX_ONE, article.getTitle());
            preparedStatement.setString(PARAMETER_INDEX_TWO, article.getText());
            preparedStatement.setString(PARAMETER_INDEX_THREE, article.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ARTICLE);
            preparedStatement.setString(PARAMETER_INDEX_ONE, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<Article> findByUserId(String userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERID);
            preparedStatement.setString(PARAMETER_INDEX_ONE, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Article> listArticles = new ArrayList<>();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getString("id"));
                article.setTitle(resultSet.getString("title"));
                article.setText(resultSet.getString("text"));
                article.setUserId(resultSet.getString("user_id"));
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
            preparedStatement.setString(PARAMETER_INDEX_ONE, article.getTitle());
            preparedStatement.setString(PARAMETER_INDEX_TWO, article.getText());
            preparedStatement.setString(PARAMETER_INDEX_THREE, article.getUserId());
            preparedStatement.setString(PARAMETER_INDEX_FOUR, article.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}
