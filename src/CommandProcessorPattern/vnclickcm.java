package CommandProcessorPattern;

import presentationlayer.vietnamGUI;

public class vnclickcm implements Command{
	private String ma;
	private String hoten;
	private String soluong;
	private String dinhmuc;
	private String dongia;
	private String thanhtien;
	private String ngayrahd;
	private String doituong;
	private vietnamGUI vngui;
	
	public vnclickcm(String ma, String hoten, String ngayrahd, String doituong, String soluong, String dongia, String dinhmuc, String thanhtien, vietnamGUI vngui) {
		this.ma = ma;
		this.hoten = hoten;
		this.soluong = soluong;
		this.dinhmuc = dinhmuc;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
		this.ngayrahd = ngayrahd;
		this.doituong = doituong;
		this.vngui = vngui;
	}

	@Override
	public void execute() {
		vngui.getmatxt().setText(ma);
		vngui.gettentxt().setText(hoten);
		vngui.getdmtxt().setText(dinhmuc);
		vngui.getsltxt().setText(soluong);
		vngui.getdgtxt().setText(dongia);
		vngui.getmtttxt().setText(thanhtien);

		vngui.getcomboBoxngay().setSelectedItem(String.valueOf(ngayrahd.substring(8, 10)));
		vngui.getcomboBoxthang().setSelectedItem(String.valueOf(ngayrahd.substring(5, 7)));
		vngui.getcomboBoxnam1().setSelectedItem(String.valueOf(ngayrahd.substring(0, 4)));
		vngui.getcomboBoxdtkh().setSelectedItem(doituong);
	}

}
