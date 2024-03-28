package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import bean.khachhangbean;
import connection.DBConnect;

public class khachhangdao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public khachhangbean login(String tendn, String pass) {
		String sql="select * from KhachHang where tendn=? and pass=?";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, tendn);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new khachhangbean(rs.getInt("makh"), 
												rs.getString("hoten"), 
												rs.getString("diachi"), 
												rs.getString("sodt"), 
												rs.getString("email"), 
												rs.getString("tendn"), 
												rs.getString("pass"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public khachhangbean checkacc(String tendn) {
		String sql="select * from KhachHang where tendn=?";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, tendn);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new khachhangbean(rs.getInt("makh"), 
												rs.getString("hoten"), 
												rs.getString("diachi"), 
												rs.getString("sodt"), 
												rs.getString("email"), 
												rs.getString("tendn"), 
												rs.getString("pass"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void AddKH(String hoten, String diachi, String sdt, String email, String tendn, String pass) {
		String sql="insert into KhachHang(hoten, diachi, sodt, email, tendn,pass) values(?,?,?,?,?,?)";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, hoten);
			ps.setString(2, diachi);
			ps.setString(3, sdt);
			ps.setString(4, email);
			ps.setString(5, tendn);
			ps.setString(6, pass);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
}
