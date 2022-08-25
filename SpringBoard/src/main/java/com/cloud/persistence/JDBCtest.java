package com.cloud.persistence;

import java.sql.Connection;

public class JDBCtest {

	public static void main(String[] args) {
		Connection conn = JDBCUtil.getConnection();
		
		System.out.println(conn);

	}

}
