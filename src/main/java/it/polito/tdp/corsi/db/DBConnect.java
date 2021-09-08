package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/iscritticorsi?user=root";
		return DriverManager.getConnection(url) ;
	}
}
