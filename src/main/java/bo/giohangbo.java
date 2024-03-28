package bo;

import java.util.ArrayList;

import bean.giohangbean;
import bean.sachbean;

public class giohangbo {
	
	//viết hàm thêm/xóa/tổng tiền vào giỏ:ds
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	
	public void Themhang(String masach, String tensach, String tacgia, long soluong, long gia,
			String anh) throws Exception{
		for (giohangbean i : ds) {
			if (i.getMasach().equals(masach)) {
				i.setSoluong(i.getSoluong()+1);
				return;
			}
			
			
		}
		ds.add(new giohangbean(masach, tensach, tacgia, soluong, gia, anh));
	}
	public ArrayList<giohangbean> getDS(){
		return ds;
	}
	public void Xoahang(String masach) throws Exception{
		for (giohangbean i : ds) {
			if(i.getMasach().equals(masach)) {
				ds.remove(i);
				break;
			}
		}
	}
	public void XoaALL() {
		ds.clear();
	}
	
	public Long Tongtien() throws Exception{
		Long tong=(long) 0;
		for (giohangbean gh : ds) {
			tong+= gh.getThanhtien();
		}
		return tong;
	}
	public void Cong(String masach) throws Exception{
		for (giohangbean i : ds) {
			if(i.getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				i.setSoluong(i.getSoluong()+1);
				i.setThanhtien(i.getGia()*i.getSoluong());
			}
		}
	}
	public void tru(String masach) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				if(a>0) {
					ds.get(i).setSoluong(a-1);
					ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
					break;
				}else { 
					Xoahang(masach);
					
				}
			}
		}
	}
}
