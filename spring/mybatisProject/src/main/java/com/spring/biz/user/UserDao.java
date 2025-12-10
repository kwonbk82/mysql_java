package com.spring.biz.user;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;

@Repository("userDao")
public class UserDao {
	private Connection conn=null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private final String USER_GET = "select * from users where id=? and password=?";
	
	public UserDto getUser(UserDto dto) {
		UserDto user = null;
		
		try {
			System.out.println("===> JDBC로 getUser() 처리");
			conn=JDBCUtil.getConnection();
			
			psmt = conn.prepareStatement(USER_GET);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPassword());

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new UserDto();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		
		return user;
	}
}
