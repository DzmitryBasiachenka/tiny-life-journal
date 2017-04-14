package com.bsdim.tlj.repository.connection;

import com.bsdim.tlj.repository.exception.RepositoryException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgrespass";
    private static final String URL = "jdbc:postgresql://localhost:5432/tiny-life-journal";

    private static ConnectionManager instance = new ConnectionManager();

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionManager getInstance() {
        return instance;
    }

    private ConnectionManager() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}
