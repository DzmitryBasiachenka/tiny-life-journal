package com.bsdim.tlj.repository;

import com.bsdim.tlj.repository.exception.RepositoryException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public Connection connection;
    private static ConnectionManager instance;
    private static String username = "postgres";
    private static String password = "postgrespass";
    private static String URL = "jdbc:postgresql://localhost:5432/tiny-life-journal";

    private ConnectionManager() {
        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    public static ConnectionManager getInstance() {
        if(instance == null) {
            return instance = new ConnectionManager();
        }
        return instance;
    }
}
