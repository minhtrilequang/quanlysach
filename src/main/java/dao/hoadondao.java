package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import connection.DBConnect;

public class hoadondao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public int ThemHD(int makh) throws Exception {
		String sql="insert into hoadon(makh,NgayMua,damua) values(?,?,0)";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setLong(1, makh);
		Date n1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String tam=sdf.format(n1);
		Date n2=sdf.parse(tam);
		ps.setDate(2, new java.sql.Date(n2.getTime()));
		int kq=ps.executeUpdate();
		conn.close();
		ps.close();
		return kq;
	}
	public long maxhd() throws Exception {
		String sql="select max(hoadon.MaHoaDon) as maxhd from hoadon";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		long max=0;
		if(rs.next()) {
			max=rs.getLong("maxhd");
		}
		rs.close();
		ps.close();
		conn.close();
		return max;
	}
}
