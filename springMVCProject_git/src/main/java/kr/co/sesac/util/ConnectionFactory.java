package kr.co.sesac.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//설정해 두었던 DB접속 util 패키지 그대로 사용
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
}
