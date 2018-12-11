package com.market.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBobject {
	void save() throws SQLException;
	void getByID() throws SQLException;
	
}
