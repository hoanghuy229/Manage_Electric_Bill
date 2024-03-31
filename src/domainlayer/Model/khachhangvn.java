package domainlayer.Model;

import java.sql.Date;

public class khachhangvn extends khachhang{
	private double dinhmuc;
	private String doituongkh;

	//constructor
	public khachhangvn() {
		super();
	}
	public khachhangvn(int ma, String hoten, double soluong, double dongia, Date ngayrahd,double dinhmuc, String doituongkh,double thanhtien) {
		super(ma,hoten,soluong,dongia,ngayrahd);
		this.dinhmuc = dinhmuc;
		this.doituongkh = doituongkh;
	}
	

	public double getDinhmuc() {
		return dinhmuc;
	}
	public void setDinhmuc(double dinhmuc) {
		this.dinhmuc = dinhmuc;
	}
	public String getDoituongkh() {
		return doituongkh;
	}
	public void setDoituongkh(String doituongkh) {
		this.doituongkh = doituongkh;
	}
	
	
	@Override
	public double thanhtien() {	
		double tt;
		
		if(getSoluong() <= dinhmuc) {
			 tt = getSoluong()*getDongia();
		}
		else {
			double vuotdinhmuc = getSoluong()-dinhmuc;
			 tt = (dinhmuc * getDongia()) + (vuotdinhmuc * getDongia() * 2.5);
		}
		return tt;
	}


}
