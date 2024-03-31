package DTO;

import java.sql.Date;

public class vnDTO extends khachhangDTO{
	private double dinhmuc;
	private String doituongkh;
	private double thanhtien;

	//constructor
	public vnDTO() {
		super();
	}
	public vnDTO(int ma, String hoten, double soluong, double dongia, Date ngayrahd,double dinhmuc, String doituongkh,double thanhtien) {
		super(ma,hoten,soluong,dongia,ngayrahd);
		this.dinhmuc = dinhmuc;
		this.doituongkh = doituongkh;
		this.thanhtien = thanhtien;
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
	public double getthanhtien() {
		return thanhtien;
	}
	public void setthanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
}
