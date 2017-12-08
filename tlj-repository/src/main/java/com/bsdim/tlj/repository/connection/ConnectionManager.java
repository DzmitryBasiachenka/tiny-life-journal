package com.bsdim.tlj.repository.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.bsdim.tlj.repository.exception.RepositoryException;
import com.bsdim.tlj.repository.exception.SystemException;

/**
 * The connection manager.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public final class ConnectionManager {
    private static ConnectionManager sInstance = new ConnectionManager();

    private String file = System.getProperty("my.property");
    private Connection connection;
    private Properties properties;
    private FileInputStream fileInputStream;

    private ConnectionManager() {
        try {
            loadProperties();
            connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user.name"), properties.getProperty("db.password"));
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public String getFile() {
        return file;
    }

    public static ConnectionManager getInstance() {
        return sInstance;
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
