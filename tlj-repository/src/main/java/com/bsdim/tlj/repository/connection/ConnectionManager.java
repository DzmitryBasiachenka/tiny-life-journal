package com.bsdim.tlj.repository.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "db.url";
    private static final String DB_USER_NAME = "db.user.name";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_CONFIG_PATH = "db.config.path";
    private static final String DB_CONFIG_PROPERTIES = "/dbConfig.properties";
    private static ConnectionManager sInstance = new ConnectionManager();

    private Connection connection;

    private ConnectionManager() {
        try {
            Properties properties = loadDbConfigProperties();
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(properties.getProperty(DB_URL),
                    properties.getProperty(DB_USER_NAME), properties.getProperty(DB_PASSWORD));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public static ConnectionManager getInstance() {
        return sInstance;
    }
    private Properties loadDbConfigProperties() {
        try {
            Properties properties = new Properties();
            properties.load(getDbConfig());
            return properties;
        } catch (IOException e) {
            throw new SystemException(e);
        }
    }

    private InputStream getDbConfig() {
        try {
            String configPropertiesPath = System.getProperty(DB_CONFIG_PATH);
            if (configPropertiesPath != null) {
                return new FileInputStream(configPropertiesPath);
            }
            return getClass().getResourceAsStream(DB_CONFIG_PROPERTIES);
        } catch (IOException e) {
            throw new SystemException(e);
        }
    }
}
