package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConexion {
    
    public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bd_adinelsa";
			String usr = "root";
			String psw = "";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException ex) {
			System.out.println("Error >> de conexión con la BD");
		}
		return con;
	}
}
