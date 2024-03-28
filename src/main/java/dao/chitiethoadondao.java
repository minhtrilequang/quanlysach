package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnect;

public class chitiethoadondao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public int ThemCTHD(String masach, long soluongmua, long mahoadon) throws Exception {
		String sql="insert into ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon, damua) values(?,?,?,0)";
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, masach);
		ps.setLong(2, soluongmua);
		ps.setLong(3, mahoadon);
		int kq=ps.executeUpdate();
		ps.close();
		conn.close();
		return kq;
		
	}
}
