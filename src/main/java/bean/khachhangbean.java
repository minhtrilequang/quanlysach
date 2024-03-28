package bean;

public class khachhangbean {
	private int Makh;
	private String Hoten;
	private String Diachi;
	private String Sodt;
	private String Email;
	private String Tendn;
	private String Pass;
	public khachhangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhangbean(int makh, String hoten, String diachi, String sodt, String email, String tendn, String pass) {
		super();
		Makh = makh;
		Hoten = hoten;
		Diachi = diachi;
		Sodt = sodt;
		Email = email;
		Tendn = tendn;
		Pass = pass;
	}
	public int getMakh() {
		return Makh;
	}
	public void setMakh(int makh) {
		Makh = makh;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getDiachi() {
		return Diachi;
	}
	public void setDiachi(String diachi) {
		Diachi = diachi;
	}
	public String getSodt() {
		return Sodt;
	}
	public void setSodt(String sodt) {
		Sodt = sodt;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTendn() {
		return Tendn;
	}
	public void setTendn(String tendn) {
		Tendn = tendn;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
	
	
}
