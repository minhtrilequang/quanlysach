package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;
import connection.DBConnect;

public class loaidao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> list=new ArrayList<loaibean>();
		String sql="select * from loai";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while (rs.next()) {
			String maloai=rs.getString("maloai");
			String tenloai=rs.getString("tenloai");
			list.add(new loaibean(maloai, tenloai));
			
		}
		return list;
		
	}
	
}
