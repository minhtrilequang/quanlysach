package bean;

import java.util.Date;

public class lichsumuahangbean {
	private String masach;
	private String tensach;
	private long soluong;
	private long thanhtien;
	private Date ngaymua;
	public lichsumuahangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsumuahangbean(String masach, String tensach, long soluong, long thanhtien, Date ngaymua) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
		this.ngaymua = ngaymua;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	
}
