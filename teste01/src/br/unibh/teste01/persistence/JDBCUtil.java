package br.unibh.teste01.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static Connection con;

	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibh", "unibh", "1234");
			//System.out.println("Conex�o bem sucedida!");
		}
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}		
}