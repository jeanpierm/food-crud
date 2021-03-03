package com.jean.foodapi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
	private static Connection con; 
    final static String CADENECONEXION = "jdbc:mysql://localhost:3306/foodapi2_db";
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String USER = "root";
    final static String PASS = "";
    
    private MyConnection (){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());     
            System.out.println("Driver mysql no encontrada");
        }
        try {
            con = DriverManager.getConnection(CADENECONEXION, USER, PASS);
            if (con != null) {
				System.out.println("Conectado");
			}
        } catch (SQLException e) {
             System.out.println(e.getMessage());  
            System.out.println("error en conexion");
        }
    }
    
    public static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
        	new MyConnection();
        }
       return con;
    }
}
