package com.epam.library.connections;

import com.epam.configurations.Configuration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPoolProvider {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        Properties applicationProperties = Configuration.getApplicationProperties();
        config.setJdbcUrl(applicationProperties.getProperty("jdbc.url"));
        config.setUsername(applicationProperties.getProperty("jdbc.name"));
        config.setPassword(applicationProperties.getProperty("jdbc.password"));
        config.setMaximumPoolSize(5);//max count of allowed connections
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    private ConnectionPoolProvider(){

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }





}
