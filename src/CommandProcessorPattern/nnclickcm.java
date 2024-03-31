package CommandProcessorPattern;

import javax.swing.JTextField;

import presentationlayer.nuocngoaiGUI;

public class nnclickcm implements Command{

	private String ma;
	private String ten;
	private String ngayRaHD;
	private String quocTich;
	private String soLuong;
	private String donGia;
	private String thanhTien;    
	private nuocngoaiGUI nngui;
	
	public nnclickcm(String ma, String ten, String ngayRaHD, String quocTich, String soLuong, String donGia, String thanhTien, nuocngoaiGUI nngui) {
        this.ma = ma;
        this.ten = ten;
        this.ngayRaHD = ngayRaHD;
        this.quocTich = quocTich;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.nngui = nngui;
    }

	@Override
	public void execute() {

		nngui.getma().setText(ma);
        nngui.getten().setText(ten);
        nngui.getqtnntext().setText(quocTich);
        nngui.getslnntxt().setText(soLuong);
        nngui.getdgnntxt().setText(donGia);
        nngui.getttnntxt().setText(thanhTien);

		nngui.getcomboBoxngaynn().setSelectedItem(String.valueOf(ngayRaHD.substring(8, 10)));
        nngui.getcomboBoxthangnn().setSelectedItem(String.valueOf(ngayRaHD.substring(5, 7)));
        nngui.getcomboBoxnamnn1().setSelectedItem(String.valueOf(ngayRaHD.substring(0, 4)));
		

	}

}
