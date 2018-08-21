	package com.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import com.jdbc.ConPool;
	import com.pojo.Relative;

public class RelativeDao {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			RelativeDao jdbcDemo= new RelativeDao();
			
//			jdbcDemo.JdbcDeleteTest("leixin");
			
//			jdbcDemo.JdbcSearchTest("123");
			Relative relative =new Relative();
			relative.setAccount("leixin");
			relative.setName("abc");
//			jdbcDemo.JdbcAddTest(relative);
//			jdbcDemo.queryRelativeByLogin(Relative);
			jdbcDemo.JdbcUpdateTest(relative ,"leixin");
			
			
			
		}
		
		//登录
		public Relative queryRelativeByLogin(Relative Relative) {
			String sqlStr = "select id,account,name,phone,birthday,remarks,oldman from relative where account=? and password=?";
			Connection conn = ConPool.getConnection();
			PreparedStatement pst;
			try {
				pst = conn.prepareStatement(sqlStr);
				pst.setString(1, Relative.getAccount());
				pst.setString(2, Relative.getName());
				pst.setInt(2, Relative.getPhone());
				pst.setDate(2, Relative.getDate());
				pst.setString(2, Relative.getRemarks());
				pst.setString(2, Relative.getOldman());
				
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					Relative = new Relative();
					Relative.setId(rs.getInt("id"));
					Relative.setAccount(rs.getString("account"));
					Relative.setName(rs.getString("name"));
					Relative.setPhone(rs.getInt("phone"));
					Relative.setDate(rs.getDate("date"));
					Relative.setRemarks(rs.getString("remarks"));
					Relative.setOldman(rs.getString("oldman"));
					
					
				}
				rs.close();
				ConPool.returnConnect(conn);
				return Relative;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//查询
		public void JdbcSearchTest(String account) {
			Connection con = null ;
			PreparedStatement stmt = null;
			ResultSet rs = null ;
			try {
				con = ConPool.getConnection();
				
				String sql= "select id,account,name,phone,birthday,remarks,oldman from Relative where account="+account+";";
				stmt= con.prepareStatement(sql);
				rs = stmt.executeQuery(sql);
				con.commit();
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("account"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getInt("phone"));
					System.out.println(rs.getDate("date"));
					System.out.println(rs.getString("remarks"));
					System.out.println(rs.getString("oldman"));
					
					System.out.println("--------------------");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}
		
		

		//增
		public void JdbcAddTest(Relative relative) {
			Connection con = null ;
			PreparedStatement stmt = null;
			
			try {
				con = ConPool.getConnection();
				
				String sql= "insert into Relative(account,name,phone,birthday,remarks,oldman) values(?,?,?,?,?,?)";
				// 测试 String sql= "insert into Relative(id,account,password,jueseid) values(3,'123','456',789)";
				stmt= con.prepareStatement(sql);
				stmt.setString(1, relative.getAccount());
				stmt.setString(2, relative.getName());
				stmt.setInt(3, relative.getPhone());
				stmt.setDate(4, relative.getDate());
				stmt.setString(5, relative.getRemarks());
				stmt.setString(6, relative.getOldman());
				stmt.execute();
				con.commit();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					
					stmt.close();
					con.close();
					System.out.println("ok");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}
		
		//删
		public void JdbcDeleteTest(String account) {
			Connection con = null ;
			PreparedStatement stmt = null;
			
			try {
				con = ConPool.getConnection();
				
				String sql= "delete from relative where account = ?";
				stmt= con.prepareStatement(sql);
				stmt.setString(1, account);
				stmt.execute();
				con.commit();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					
					stmt.close();
					con.close();
					System.out.println("ok");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}
		
		//改
		public void JdbcUpdateTest(Relative relative,String account) {
			Connection con = null ;
			PreparedStatement stmt = null;
			
			  
			try {
				con = ConPool.getConnection();
				
				String sql= "update Relative set account=?,name=?,phone=?,birthday=?,remarks=?,oldman=? where account=?";
				stmt=  con.prepareStatement(sql);
				stmt.setString(1, relative.getAccount());
				stmt.setString(2, relative.getName());
				stmt.setInt(3, relative.getPhone());
				stmt.setDate(4, relative.getDate());
				stmt.setString(5, relative.getRemarks());
				stmt.setString(6, relative.getOldman());
				stmt.setString(6, account);
				
				stmt.execute();
				con.commit();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					
					stmt.close();
					con.close();
					System.out.println("ok");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}

	
}
