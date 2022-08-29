package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.cloud.persistence.JDBCUtil;

@Repository
public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String LOGIN =
			"SELECT * FROM users WHERE id=? and passwd =?";
	
	public boolean login(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return false;
	}
	
	
	
	
	
	
}
