package domainlayer.Model;

import java.sql.Date;

public class khachhangnn extends khachhang {
private String quoctich;
	
	
	public khachhangnn() {
		super();
	}
	public khachhangnn(int ma, String hoten, double soluong, double dongia, Date ngayrahd,String quoctich,double thanhtien) {
		super(ma,hoten,soluong,dongia,ngayrahd);
		this.quoctich = quoctich;
	}
	

	public String getQuoctich() {
		return quoctich;
	}
	public void setQuoctich(String quoctich) {
		this.quoctich = quoctich;
	}
	
	@Override
	public double thanhtien() {
		return getSoluong()*getDongia();
	}


}
