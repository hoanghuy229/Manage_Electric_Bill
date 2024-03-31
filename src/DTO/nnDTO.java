package DTO;

import java.sql.Date;

public class nnDTO extends khachhangDTO {
private String quoctich;
private double thanhtien;
	
	
	public nnDTO() {
		super();
	}
	public nnDTO(int ma, String hoten, double soluong, double dongia, Date ngayrahd,String quoctich,double thanhtien) {
		super(ma,hoten,soluong,dongia,ngayrahd);
		this.quoctich = quoctich;
		this.thanhtien = thanhtien;
	}
	

	public String getQuoctich() {
		return quoctich;
	}
	public void setQuoctich(String quoctich) {
		this.quoctich = quoctich;
	}
	
	public double getthanhtien() {
		return thanhtien;
	}
	public void setthanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}
