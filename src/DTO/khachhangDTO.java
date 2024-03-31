package DTO;

import java.sql.Date;

public abstract class khachhangDTO {
	private int ma;
	private String hoten;
	private double soluong;
	private double dongia;
	private Date ngayrahd;
	
	
	//constructor
	public khachhangDTO() {
	}
	public khachhangDTO(int ma, String hoten, double soluong, double dongia, Date ngayrahd) {
		this.ma = ma;
		this.hoten = hoten;
		this.soluong = soluong;
		this.dongia = dongia;
		this.ngayrahd = ngayrahd;
	}

	//getter setter
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public double getSoluong() {
		return soluong;
	}
	public void setSoluong(double soluong) {
		this.soluong = soluong;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public Date getNgayrahd() {
		return ngayrahd;
	}
	public void setNgayrahd(Date ngayrahd) {
		this.ngayrahd = ngayrahd;
	}
	
}
