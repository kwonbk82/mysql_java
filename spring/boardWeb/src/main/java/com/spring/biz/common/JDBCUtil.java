package com.spring.biz.common;

import java.sql.*;

public class JDBCUtil {
	private static final String DRIVER_NAME ="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/spring?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection () {
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement psmt, Connection conn) {
		if(psmt != null) {
			try {
				if(!psmt.isClosed())
					psmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				psmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed())
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		if(rs != null) {
			try {
				if(!rs.isClosed())
					rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		
		if(psmt != null) {
			try {
				if(!psmt.isClosed())
					psmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				psmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed())
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
}
