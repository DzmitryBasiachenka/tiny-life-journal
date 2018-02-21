package com.bsdim.tlj.repository.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;

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
    private static final int CAPACITY = 10;

    private static ConnectionManager sInstance = new ConnectionManager();

    private Properties properties;
    private ArrayBlockingQueue<Connection> usedConnectionsQueue = new ArrayBlockingQueue<>(CAPACITY);
    private ArrayBlockingQueue<Connection> freeConnectionsQueue = new ArrayBlockingQueue<>(CAPACITY);

    private ConnectionManager() {
        try {
            loadDbConfigProperties();
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RepositoryException(e);
        }
    }

    private void loadDbConfigProperties() {
        try {
            properties = new Properties();
            properties.load(getDbConfig());
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

    /**
     * Gets the connection.
     *
     * @return the connection.
     */
    public Connection getConnection() {
        try {
            Connection connection = usedConnectionsQueue.poll();
            if (connection == null) {
                if (freeConnectionsQueue.remainingCapacity() > usedConnectionsQueue.size()) {
                    connection = DriverManager.getConnection(properties.getProperty(DB_URL),
                            properties.getProperty(DB_USER_NAME), properties.getProperty(DB_PASSWORD));
                } else {
                    connection = usedConnectionsQueue.take();
                }
            }
            freeConnectionsQueue.put(connection);
            return connection;
        } catch (InterruptedException | SQLException e) {
            throw new RepositoryException(e);
        }
    }

    /**
     * Puts the connection.
     *
     * @param connection the connection.
     */
    public void putConnection(Connection connection) {
        try {
            usedConnectionsQueue.put(connection);
            freeConnectionsQueue.remove(connection);
        } catch (InterruptedException e) {
            throw new RepositoryException(e);
        }

    }

    public static ConnectionManager getInstance() {
        return sInstance;
    }
}
