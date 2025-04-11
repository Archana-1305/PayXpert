package com.java.util;

import java.sql.Connection;

import com.java.exception.DatabaseConnectionException;

public class DatabaseContext {
	public static Connection getConnection() throws DatabaseConnectionException {
		Connection connection = DBConnUtil.getDBConn();
		if (connection == null) {
			throw new DatabaseConnectionException("Failed to connect with Database.");
		}
		return connection;
		
	}

}
