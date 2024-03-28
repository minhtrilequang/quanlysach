package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;
import bean.sachbean;
import connection.DBConnect;

public class sachdao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public ArrayList<sachbean> getSach(int index) throws Exception{
		ArrayList<sachbean> list=new ArrayList<sachbean>();
		String sql="exec paging ?,8";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, index);
		rs=ps.executeQuery();
		while(rs.next()) {
			String masach=rs.getString("masach");
			String tensach=rs.getString("tensach"); 
			String tacgia=rs.getString("tacgia"); 
			long soluong=rs.getLong("soluong");
			long gia=rs.getLong("gia");
			String anh=rs.getString("anh");
			String maloai=rs.getString("maloai");
			list.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			
		}
		
		return list;
		
	}
	public int getTongSLSach() throws Exception {
		String sql="select count(*) from sach";
		int total=0;
		
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
	public int getTongSLSachByLoai(String maloai) throws Exception {
		String sql="select count(*) from sach where maloai=?";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, maloai);
		rs=ps.executeQuery();
		while(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
	public ArrayList<sachbean> getSachByLoai(int index,String ml) throws Exception{
		ArrayList<sachbean> list=new ArrayList<sachbean>();
		String sql="exec pagingloai ?,8,?";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, index);
		ps.setString(2, ml);
		rs=ps.executeQuery();
		while(rs.next()) {
			String masach=rs.getString("masach");
			String tensach=rs.getString("tensach"); 
			String tacgia=rs.getString("tacgia"); 
			long soluong=rs.getLong("soluong");
			long gia=rs.getLong("gia");
			String anh=rs.getString("anh");
			String maloai=rs.getString("maloai");
			list.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			
		}
		
		return list;
		
	}
}
