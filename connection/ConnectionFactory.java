package com.hotwax.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
	Connection getConnForHotWax() throws SQLException;
	
}
