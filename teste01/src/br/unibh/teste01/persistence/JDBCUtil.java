package br.unibh.teste01.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	// Identa��o do c�digo = ctrl + shif + f
	
	private static Connection con;

	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibh", "root", "vertrigo");
		//	System.out.println("conectou no banco de dados");
		}
		return con;
	}

	public static void closeConnection() {
		try {

			if (con != null && !con.isClosed()) {
				con.close();
		//		System.out.println("Fechou o banco de dados");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
