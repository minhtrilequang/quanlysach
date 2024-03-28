package bean;

public class giohangbean {
	private String masach;
	private String tensach;
	private String tacgia;
	private Long soluong;
	private Long gia;
	private String anh;
	private Long thanhtien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String masach, String tensach, String tacgia, Long soluong, Long gia, String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia =tacgia;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.thanhtien = soluong*gia;
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
	
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Long getThanhtien() {
		return soluong*gia;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}
