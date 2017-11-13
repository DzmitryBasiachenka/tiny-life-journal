package com.bsdim.tlj.repository.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.IUserRepository;
import com.bsdim.tlj.repository.connection.ConnectionManager;
import com.bsdim.tlj.repository.exception.RepositoryException;

/**
 * The user repository sql.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class UserRepositorySql implements IUserRepository {
    private static final String CREATE_USER = "insert into \"user\"(name, login, password, id) values(?, ?, ?, ?)";
    private static final String READ_USER = "select id, name, login, password from \"user\" where id = ?";
    private static final String UPDATE_USER = "update \"user\" set  name = ?, login = ?, password = ? where id = ?";
    private static final String DELETE_USER = "delete from \"user\" where id = ?";
    private static final String GET_USERS = "select id, name, login, password from \"user\" order by id";
    private static final String FIND_BY_LOGIN = "select id, name, login, password from \"user\" where login = ?";
    private static final int PARAMETER_INDEX_ONE = 1;
    private static final int PARAMETER_INDEX_TWO = 2;
    private static final int PARAMETER_INDEX_THREE = 3;
    private static final int PARAMETER_INDEX_FOUR = 4;

    private Connection connection = ConnectionManager.getInstance().getConnection();

    @Override
    public void create(User user) {
        addValues(user, CREATE_USER);
    }

    @Override
    public User read(String id) {
        return readData(id, READ_USER);
    }

    @Override
    public void update(User user) {
        addValues(user, UPDATE_USER);
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<User> getUsers() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_USERS);
            List<User> listUsers = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                listUsers.add(user);
            }
            resultSet.close();
            return listUsers;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public User findByLogin(String login) {
        return readData(login, FIND_BY_LOGIN);
    }

    private void addValues(User user, String request) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(PARAMETER_INDEX_ONE, user.getName());
            preparedStatement.setString(PARAMETER_INDEX_TWO, user.getLogin());
            preparedStatement.setString(PARAMETER_INDEX_THREE, user.getPassword());
            preparedStatement.setString(PARAMETER_INDEX_FOUR, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    private User readData(String data, String request) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(PARAMETER_INDEX_ONE, data);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}
