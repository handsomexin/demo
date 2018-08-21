package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.jdbc.ConPool;
import com.pojo.User;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.regexp.internal.recompile;




public class UserDao {


	
	//登录
	public static User queryUserByLogin(User user) {
		String sqlStr = "select id,account,password from user where account=?";
		Connection conn = null;
		
		try {
			conn=ConPool.getConnection();
			if(conn==null){
				  System.out.println(conn);
				}
			PreparedStatement pst;
			pst=conn.prepareStatement(sqlStr);
			pst.setString(1, user.getAccount());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				if (rs.getString("password").equals(user.getPassword())) {
					rs.close();
					ConPool.returnConnect(conn);
					return user;
				}
				
			}else
				user=null;
			
			
//			
//			while (rs.next()) {
//				user = new User();
//				user.setId(rs.getInt("id"));
//				user.setAccount(rs.getString("account"));
//				user.setPassword(rs.getString("password"));
//		
//			}
			rs.close();
			ConPool.returnConnect(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//查询
	public static User JdbcSearchTest(User user) {
		int key =0;
		Connection con = null ;
		PreparedStatement stmt = null;
		ResultSet rs = null ;
		try {
			con = ConPool.getConnection();
			
			String sql= "select id,account,password from user where account="+user.getAccount()+";";
			stmt= con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			con.commit();
			
			
			while(rs.next()) {
				key=1;
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("account"));
				System.out.println(rs.getString("password"));
				System.out.println("--------------------");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				
				stmt.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (key==0) {
			return user;
		}else {
			return null;
		}
		
	
	}
	
	

	//增
	public static User JdbcAddTest(User user) {
		Connection con = null ;
		PreparedStatement pst=null;
		
		
		try {
			con = ConPool.getConnection();
			
			String sql= "insert into user(account,password,jueseid) values (?,?,?);";
			// 测试 String sql= "insert into user(id,account,password,jueseid) values(3,'123','456',789)";
			pst= con.prepareStatement(sql);
			
			pst.setString(1, user.getAccount());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getJueseid());
			
			pst.execute();
			con.commit();
			if (user.getJueseid().equals("1")) {
				//创建角色relativesID
				
			}else if (user.getJueseid().equals("2")) {
				//创建角色serviceID
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pst.close();
				con.close();
				System.out.println("ok");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return user;
	
	}
	
	//删
	public void JdbcDeleteTest(int account) {
		Connection con = null ;
		PreparedStatement pst = null;
		
		try {
			con = ConPool.getConnection();
			String sql= "delete from user where id = "+account;
			pst= con.prepareStatement(sql);
			pst.execute();
			con.commit();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pst.close();
				con.close();
				System.out.println("ok");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	//改
	public void JdbcUpdateTest(User user,String account) {
		Connection con = null ;
		PreparedStatement pst = null;
		
		  
		try {
			con = ConPool.getConnection();
			String sql= "update user set account=?,password=?,jueseid=? where account=?";
			pst= con.prepareStatement(sql);
			pst.setString(1, user.getAccount());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getJueseid());
			pst.setString(4, user.getAccount());
			
			
			pst.execute();
			con.commit();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pst.close();
				con.close();
				System.out.println("ok");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}

}
