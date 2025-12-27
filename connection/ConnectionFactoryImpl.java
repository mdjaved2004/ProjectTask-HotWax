package com.hotwax.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactoryImpl implements ConnectionFactory{

	private static HikariDataSource hotWaxDataSource;

	static {
        try {
            MysqlDataSource ds1 = new MysqlDataSource();
            ds1.setUrl("jdbc:mysql://localhost:3306/hotWax");
            ds1.setUser("root");
            ds1.setPassword("Mdjaved2004");

            HikariConfig hc1 = new HikariConfig();
            hc1.setDataSource(ds1);
            hc1.setMaximumPoolSize(10);

            hotWaxDataSource = new HikariDataSource(hc1);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
    public Connection getConnForHotWax() throws SQLException {
        return hotWaxDataSource.getConnection();
    }

   
}
