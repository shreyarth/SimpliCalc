package com.prodid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private Connection con;

	public DBConn() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
		Class.forName("org.h2.Driver");
		con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	}

	public Connection getCon() {
		return con;
	}

}
