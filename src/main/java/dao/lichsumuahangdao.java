package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsumuahangbean;
import connection.DBConnect;

public class lichsumuahangdao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public ArrayList<lichsumuahangbean> HienThilsmh(long Makh) throws Exception{
		String sql="select*from Vlichsu where makh=?";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setLong(1, Makh);
		rs=ps.executeQuery();
		
		ArrayList<lichsumuahangbean> ds=new ArrayList<lichsumuahangbean>();
		while(rs.next()) {
			ds.add(new lichsumuahangbean(rs.getString("masach"), rs.getString("tensach"), rs.getLong("soluong"), rs.getLong("thanhtien"), rs.getDate("NgayMua")));
			
		}
		rs.close();
		conn.close();
		return ds;
		
	}
}
