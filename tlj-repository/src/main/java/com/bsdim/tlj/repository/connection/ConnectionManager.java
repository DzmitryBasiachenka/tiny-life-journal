package com.bsdim.tlj.repository.connection;

import com.bsdim.tlj.repository.exception.RepositoryException;
import com.bsdim.tlj.repository.exception.SystemException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static ConnectionManager instance = new ConnectionManager();

    private String file = System.getProperty("my.property");
    private Connection connection;
    private Properties properties;
    private FileInputStream fileInputStream;

    public Connection getConnection() {
        return connection;
    }

    public String getFile() {
        return file;
    }

    public static ConnectionManager getInstance() {
        return instance;
    }

    private ConnectionManager() {
        try {
            loadProperties();
            connection = DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.user.name"), properties.getProperty("db.password"));
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    private void loadProperties() {
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new SystemException(e);
        }
    }
}
