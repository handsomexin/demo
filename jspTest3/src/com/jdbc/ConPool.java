package com.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConPool {
	private static List<Connection> conList = new ArrayList<>();
	private static String driver = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "123123";
	/**
	 * 重连接池获取一个连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			if (conList.isEmpty()) {
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(URL, user, password);
				if(conn!=null) conn.setAutoCommit(false);
				return conn;
			}else{
				return conList.remove(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 回收连接
	 * @param conn
	 */
	public static void returnConnect(Connection conn){
		try {
			if(conn==null) return;
			conn.commit();
			if(conList.size()<5){	//连接池最多允许5个空闲连接
				conList.add(conn);
			}else{
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
