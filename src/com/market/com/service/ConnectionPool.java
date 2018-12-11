package com.market.com.service;

import java.sql.Connection;

public class ConnectionPool {
	private final static ConnectionPool INSTANCE = new ConnectionPool();

	private ConnectionPool() {}

	public static ConnectionPool getInstance() {
		return INSTANCE;
	}

	public void getConnection() {

	}

	public Connection returnConnection(Connection connection) {
		return connection;
	}

	public void closeAllConnections() {

	}
}
