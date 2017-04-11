package com.bsdim.tlj.repository.sql;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.ConnectionManager;
import com.bsdim.tlj.repository.IUserRepository;
import com.bsdim.tlj.repository.exception.RepositoryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositorySql implements IUserRepository {
    private static final String CREATE_USER = "insert into \"user\"(name, login, password, id) values(?, ?, ?, ?)";
    private static final String READ_USER = "select id, name, login, password from \"user\" where id = ?";
    private static final String UPDATE_USER = "update \"user\" set  name = ?, login = ?, password = ? where id = ?";
    private static final String DELETE_USER = "delete from \"user\" where id = ?";
    private static final String GET_USERS = "select id, name, login, password from \"user\" order by id";
    private static final String FIND_BY_LOGIN = "select id, name, login, password from \"user\" where login = ?";

    public ConnectionManager instance = ConnectionManager.getInstance();
    public Connection connection = instance.connection;

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
            while(resultSet.next()) {
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
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    private User readData(String data, String request) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, data);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}
