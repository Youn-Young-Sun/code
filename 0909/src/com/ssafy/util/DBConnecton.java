package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecton {
public void driverload() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 로딩 성공!!");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
	}
	
}
