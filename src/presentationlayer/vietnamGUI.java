package presentationlayer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CommandProcessorPattern.*;
import CommandProcessorPattern.menucm.*;
import CommandProcessorPattern.buttoncm.*;
import DTO.nnDTO;
import DTO.vnDTO;
import Observerpattern.vnsubcriber;
import domainlayer.vietnamservice;
import domainlayer.vietnamserviceimpl;
import domainlayer.Model.khachhangvn;

public class vietnamGUI extends JFrame implements vnsubcriber{
	private Commandprocessor cmp;
	private vietnamGUI vngui;
	private nuocngoaiGUI nngui;
	private vietnamservice vs;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tablevnmodel;
	private JTextField matxt;
	private JTextField dmtxt;
	private JTextField tentxt;
	private JTextField sltxt;
	private JTextField dgtxt;
	private JTextField timtxt;
	private JTextField tongsltxt;
	private JTextField tttxt;
	private JMenuBar menuBar;
	private JMenuItem nn,exit;
	private JScrollPane scrollPane;
	private JComboBox comboBoxdtkh,comboBoxthang,comboBoxngay,comboBoxnam1,comboBoxxuatthang,comboBoxnam2;
	private JButton thembtm,xoabtm,suabtm,tinhtongbtm,xuatbtm,refreshbtm;
	private JLabel 	lblNewLabel,lblHTn,lbliTngKhch,lblNgyRaHa,lblSLng,lblnGi,lblnhMc,lblXutHan,lblTmKim,lblTngSLng,lblThnhTin;
	
	public vietnamGUI() throws ClassNotFoundException  {
		
		cmp = new Commandprocessor();
		
		vs = new vietnamserviceimpl();	
		
		
		vs.add(this);
		
		this.setTitle("khách hàng việt nam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 919, 22);
		contentPane.add(menuBar);
		
		nn = new JMenuItem("bảng khách hàng nước ngoài");
		menuBar.add(nn);
		
		exit = new JMenuItem("exit");
		menuBar.add(exit);
		
		
		tablevnmodel = new DefaultTableModel();
		tablevnmodel.addColumn("ma");
		tablevnmodel.addColumn("họ tên");
		tablevnmodel.addColumn("ngày ra hđ");
		tablevnmodel.addColumn("đối tượng kh");
		tablevnmodel.addColumn("số lượng");
		tablevnmodel.addColumn("đơn giá");
		tablevnmodel.addColumn("định mức ");
		tablevnmodel.addColumn("thành tiền");
		table = new JTable(tablevnmodel);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 25, 909, 174);
		contentPane.add(scrollPane);

		
		matxt = new JTextField();
		matxt.setBounds(110, 220, 134, 30);
		contentPane.add(matxt);
		matxt.setColumns(10);
		
		dmtxt = new JTextField();
		dmtxt.setColumns(10);
		dmtxt.setBounds(110, 300, 134, 30);
		contentPane.add(dmtxt);
		
		tentxt = new JTextField();
		tentxt.setColumns(10);
		tentxt.setBounds(110, 260, 134, 30);
		contentPane.add(tentxt);
		
		sltxt = new JTextField();
		sltxt.setColumns(10);
		sltxt.setBounds(428, 220, 134, 30);
		contentPane.add(sltxt);
		
		dgtxt = new JTextField();
		dgtxt.setColumns(10);
		dgtxt.setBounds(428, 260, 134, 30);
		contentPane.add(dgtxt);
		
		comboBoxdtkh = new JComboBox();
		comboBoxdtkh.setModel(new DefaultComboBoxModel(new String[] {"sinh hoạt", "kinh doanh", "sản xuất"}));
		comboBoxdtkh.setBounds(528, 300, 91, 21);
		contentPane.add(comboBoxdtkh);
		
		comboBoxthang = new JComboBox();
		comboBoxthang.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxthang.setBounds(100, 374, 42, 21);
		contentPane.add(comboBoxthang);
		
		comboBoxngay = new JComboBox();
		comboBoxngay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxngay.setBounds(50, 374, 41, 21);
		contentPane.add(comboBoxngay);
		
		comboBoxnam1 = new JComboBox();
		comboBoxnam1.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
		comboBoxnam1.setBounds(150, 374, 70, 21);
		contentPane.add(comboBoxnam1);
		
		
		thembtm = new JButton("th\u00EAm");
		thembtm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thembtm.setBounds(150, 410, 100, 30);
		contentPane.add(thembtm);
		
		xoabtm = new JButton("x\u00F3a");
		xoabtm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		xoabtm.setBounds(414, 410, 100, 30);
		contentPane.add(xoabtm);
		
		suabtm = new JButton("s\u1EEDa");
		suabtm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		suabtm.setBounds(280, 410, 100, 30);
		contentPane.add(suabtm);
		
		timtxt = new JTextField();
		timtxt.setColumns(10);
		timtxt.setBounds(734, 220, 134, 30);
		contentPane.add(timtxt);
		
		tongsltxt = new JTextField();
		tongsltxt.setColumns(10);
		tongsltxt.setBounds(734, 260, 134, 30);
		contentPane.add(tongsltxt);
		
		comboBoxxuatthang = new JComboBox();
		comboBoxxuatthang.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxxuatthang.setBounds(705, 331, 62, 21);
		contentPane.add(comboBoxxuatthang);
		
		lblNewLabel = new JLabel("m\u00E3:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 220, 62, 22);
		contentPane.add(lblNewLabel);
		
		lblHTn = new JLabel("h\u1ECD t\u00EAn:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHTn.setBounds(20, 260, 91, 22);
		contentPane.add(lblHTn);
		
		lbliTngKhch = new JLabel("\u0111\u1ED1i t\u01B0\u1EE3ng kh\u00E1ch h\u00E0ng:");
		lbliTngKhch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbliTngKhch.setBounds(320, 300, 235, 22);
		contentPane.add(lbliTngKhch);
		
		lblNgyRaHa = new JLabel("ng\u00E0y ra h\u00F3a \u0111\u01A1n:");
		lblNgyRaHa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgyRaHa.setBounds(30, 340, 167, 22);
		contentPane.add(lblNgyRaHa);
		
		lblSLng = new JLabel("s\u1ED1 l\u01B0\u1EE3ng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSLng.setBounds(320, 220, 110, 22);
		contentPane.add(lblSLng);
		
		lblnGi = new JLabel("\u0111\u01A1n gi\u00E1:");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnGi.setBounds(320, 260, 101, 22);
		contentPane.add(lblnGi);
		
		lblnhMc = new JLabel("\u0111\u1ECBnh m\u1EE9c:");
		lblnhMc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnhMc.setBounds(15, 300, 101, 22);
		contentPane.add(lblnhMc);
		
		lblXutHan = new JLabel("xu\u1EA5t h\u00F3a \u0111\u01A1n th\u00E1ng:");
		lblXutHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXutHan.setBounds(680, 299, 215, 22);
		contentPane.add(lblXutHan);
		
		lblTmKim = new JLabel("t\u00ECm ki\u1EBFm:");
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTmKim.setBounds(620, 220, 110, 22);
		contentPane.add(lblTmKim);
		
		lblTngSLng = new JLabel("t\u1ED5ng s\u1ED1 l\u01B0\u1EE3ng:");
		lblTngSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngSLng.setBounds(590, 260, 134, 22);
		contentPane.add(lblTngSLng);
		
		comboBoxnam2 = new JComboBox();
		comboBoxnam2.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
		comboBoxnam2.setBounds(777, 330, 70, 21);
		contentPane.add(comboBoxnam2);
		lblThnhTin = new JLabel("thành tiền:");
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThnhTin.setBounds(320, 340, 110, 22);
		contentPane.add(lblThnhTin);
		
		tttxt = new JTextField();
		tttxt.setColumns(10);
		tttxt.setBounds(428, 341, 134, 30);
		contentPane.add(tttxt);
		
		tinhtongbtm = new JButton("tính tổng");
		tinhtongbtm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tinhtongbtm.setBounds(545, 410, 127, 30);
		contentPane.add(tinhtongbtm);
		
		xuatbtm = new JButton("xuất hđ");
		xuatbtm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		xuatbtm.setBounds(705, 410, 127, 30);
		contentPane.add(xuatbtm);
		refreshbtm = new JButton("refresh");
		refreshbtm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		refreshbtm.setBounds(30, 410, 100, 30);
		contentPane.add(refreshbtm);
		
		timtxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				tim();
			}
		});
		refreshbtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
		xuatbtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuathd();
			}
		});
		
		xoabtm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xoa();
			};
		});
		suabtm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sua();
                
			};
		});
		tinhtongbtm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tongsl();
			};
		});
		thembtm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				them();
			};
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			};
		});
		nn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chuyen();
			};
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				chondong();
			}
		});
		
		List<vnDTO> listvn = vs.getallvn();
		update(listvn);

	}

	@Override
	public void update(List<vnDTO> listvn) {
		tablevnmodel.setRowCount(0);
		for(vnDTO vietnam : listvn) {
			Object[] rowdata = {vietnam.getMa(),vietnam.getHoten(),vietnam.getNgayrahd(),vietnam.getDoituongkh(),
					vietnam.getSoluong(),vietnam.getDongia(),vietnam.getDinhmuc(),vietnam.getthanhtien()};
			tablevnmodel.addRow(rowdata);
		}
		}
	public void clear() {
		matxt.setText("");
		dmtxt.setText("");
		tentxt.setText("");
		sltxt.setText("");
		dgtxt.setText("");
		timtxt.setText("");
		tongsltxt.setText("");
		tttxt.setText("");
		comboBoxdtkh.setSelectedItem("sinh hoạt");
		comboBoxthang.setSelectedItem("01");
		comboBoxngay.setSelectedItem("01");
		comboBoxnam1.setSelectedItem("2023");
		comboBoxxuatthang.setSelectedItem("01");
		comboBoxnam2.setSelectedItem("2023");
	}
	public JTextField getmatxt() {
		return matxt;
	}
	public JTextField gettentxt() {
		return tentxt;
	}
	public JTextField getsltxt() {
		return sltxt;
	}
	public JTextField getdgtxt() {
		return dgtxt;
	}
	public JTextField getmtttxt() {
		return tttxt;
	}
	public JTextField getdmtxt() {
		return dmtxt;
	}
	public JComboBox getcomboBoxdtkh() {
		return comboBoxdtkh;
	}
	public JComboBox getcomboBoxthang() {
		return comboBoxthang;
	}
	public JComboBox getcomboBoxngay() {
		return comboBoxngay;
	}
	public JComboBox getcomboBoxnam1() {
		return comboBoxnam1;
	}
	public JTable gettable() {
		return table;
	}
	private boolean isMaKhachHangExisted(int ma) {
	    List<vnDTO> listvn = vs.getallvn();

	    for(vnDTO vietnam : listvn) {
	        if (Integer.valueOf(vietnam.getMa()).equals(ma)) {
	            return true; // Mã đã tồn tại
	        }
	    }

	    return false; // Mã không tồn tại
	}
    private boolean isValidNumberFormat(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDoubleFormat(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void refresh() {
    	List<vnDTO> listvn = vs.getallvn();
		update(listvn);
		clear();
    }
    
    
    
    
    public void tim() {
    	 String timkiem = timtxt.getText();
		 if(!isValidNumberFormat(timkiem)) {
			 List<vnDTO> listvn = vs.getallvn();
			 update(listvn);
             return; 
		 }
		if(!timtxt.getText().equals("")) {
			int id = Integer.parseInt(timtxt.getText());
			Command tim = new timvncm(vs,id);
			cmp.setCommand(tim);
			cmp.processcommands();
			List<vnDTO> listvn = vs.getbyid(id);
			update(listvn);
		}
    }
    public void chondong() {
		int r = table.getSelectedRow();
		if(r>=0) {
			 String ma = table.getValueAt(r, 0).toString();
             String ten = table.getValueAt(r, 1).toString();
             String ngayRaHD = table.getValueAt(r, 2).toString();
             String doiTuong = table.getValueAt(r, 3).toString();
             String soLuong = table.getValueAt(r, 4).toString();
             String donGia = table.getValueAt(r, 5).toString();
             String dinhMuc = table.getValueAt(r, 6).toString();
             String thanhTien = table.getValueAt(r, 7).toString();
             vnclickcm updateCommand = new vnclickcm(ma, ten, ngayRaHD, doiTuong, soLuong, donGia, dinhMuc, thanhTien,vietnamGUI.this);
             cmp.setCommand(updateCommand);
             cmp.processcommands();
		}
    }
    public void them() {
    	String maKhachHangStr = matxt.getText();
        String soLuongStr = sltxt.getText();
        String donGiaStr = dgtxt.getText();
        String dinhmucStr = dmtxt.getText();
        if (!isValidNumberFormat(maKhachHangStr)) {
            JOptionPane.showMessageDialog(vietnamGUI.this, "Mã khách hàng không hợp lệ!");
            return;
        }
        int maKhachHang = Integer.parseInt(maKhachHangStr);
        
        if (isMaKhachHangExisted(maKhachHang)) {
            JOptionPane.showMessageDialog(vietnamGUI.this, "Mã khách hàng đã tồn tại!");
            List<vnDTO> listvn = vs.getallvn();
			update(listvn);
            return; 
        }
        if (!isValidNumberFormat(soLuongStr)) {
            JOptionPane.showMessageDialog(vietnamGUI.this, "Số lượng không hợp lệ!");
            List<vnDTO> listvn = vs.getallvn();
			update(listvn);
            return;
        }
        int soLuong = Integer.parseInt(soLuongStr);

        if (!isValidDoubleFormat(donGiaStr)) {
            JOptionPane.showMessageDialog(vietnamGUI.this, "Đơn giá không hợp lệ!");
            List<vnDTO> listvn = vs.getallvn();
			update(listvn);
            return; 
        }
        double donGia = Double.parseDouble(donGiaStr);
        
        if (!isValidDoubleFormat(dinhmucStr)) {
            JOptionPane.showMessageDialog(vietnamGUI.this, "định mức không hợp lệ!");
            List<vnDTO> listvn = vs.getallvn();
			update(listvn);
            return; 
        }
        double dinhmuc = Double.parseDouble(dinhmucStr);
        
        
		String day = comboBoxngay.getSelectedItem().toString();
		String month = comboBoxthang.getSelectedItem().toString();
		String year = comboBoxnam1.getSelectedItem().toString();
		String birth = year+"-"+month+"-"+day;
		String hoten = tentxt.getText();
		Date ngayrahd = Date.valueOf(birth);
		String doituong = comboBoxdtkh.getSelectedItem().toString();
		double tt ;
		if(soLuong <= dinhmuc) {
			 tt = soLuong*donGia;
		}
		else {
			double vuotdinhmuc = soLuong-dinhmuc;
			 tt = (dinhmuc * donGia) + (vuotdinhmuc * donGia * 2.5);
		}
 
		vnDTO vietnam = new vnDTO(maKhachHang,hoten,soLuong,donGia,ngayrahd,dinhmuc,doituong,tt);
		
		Command them = new themvncm(vs,vietnam);
		cmp.setCommand(them);
		cmp.processcommands();
		clear();
		List<vnDTO> listvn = vs.getallvn();
		update(listvn);
    }
    public void xoa() {
    	int r = table.getSelectedRow();
		if(r == -1) {
			JOptionPane.showMessageDialog(vietnamGUI.this,"chưa chọn khách hàng");

			return;
		}
		int vietnamid = (int) table.getValueAt(r,0);
		Command xoa = new xoavncm(vs,vietnamid);
		cmp.setCommand(xoa);
		cmp.processcommands();
		List<vnDTO> listvn = vs.getallvn();
		update(listvn);
		clear();
    }
    public void sua() {
    	int r = table.getSelectedRow();
		if(r == -1) {
			JOptionPane.showMessageDialog(vietnamGUI.this,"chưa chọn khách hàng");
			return;
		}
		
		int id = Integer.parseInt(table.getValueAt(r,0).toString());
		String maKhachHangStr = matxt.getText();
        String soLuongStr = sltxt.getText();
        String donGiaStr = dgtxt.getText();
        String dinhmucStr = dmtxt.getText();
        
        
        if (!isValidNumberFormat(maKhachHangStr) || !isValidNumberFormat(soLuongStr) || !isValidDoubleFormat(donGiaStr) || !isValidDoubleFormat(dinhmucStr) ) {
            JOptionPane.showMessageDialog(vietnamGUI.this, "không đúng định dạng!");
            return; 
        }
        if(Integer.valueOf(maKhachHangStr) != id) {
			JOptionPane.showMessageDialog(vietnamGUI.this,"mã không thay đổi được");
			return;
		}
        
        int soLuong = Integer.parseInt(soLuongStr);
        double donGia = Double.parseDouble(donGiaStr);
        double dinhmuc = Double.parseDouble(dinhmucStr);
        String day = comboBoxngay.getSelectedItem().toString();
		String month = comboBoxthang.getSelectedItem().toString();
		String year = comboBoxnam1.getSelectedItem().toString();
		String birth = year+"-"+month+"-"+day;
		String hoten = tentxt.getText();
		Date ngayrahd = Date.valueOf(birth);
		String doituong = comboBoxdtkh.getSelectedItem().toString();
		int maKhachHang = Integer.parseInt(maKhachHangStr);
		double tt ;
		if(soLuong <= dinhmuc) {
			 tt = soLuong*donGia;
		}
		else {
			double vuotdinhmuc = soLuong-dinhmuc;
			 tt = (dinhmuc * donGia) + (vuotdinhmuc * donGia * 2.5);
		}
 
		vnDTO vietnam = new vnDTO(maKhachHang,hoten,soLuong,donGia,ngayrahd,dinhmuc,doituong,tt);
		
		Command sua = new suavncm(vs, vietnam);
		cmp.setCommand(sua);
		cmp.processcommands();
		clear();
		List<vnDTO> listvn = vs.getallvn();
		update(listvn);
    }
    public void exit() {
    	Command thoatct = new exitct(vietnamGUI.this,null);
    	cmp.setCommand(thoatct);
		cmp.processcommands();
    }
    public void chuyen() {
    	Command chd = new chuyendoivn(vietnamGUI.this,null);
    	cmp.setCommand(chd);
		cmp.processcommands();
    }
    public void xuathd() {
    	int thang = Integer.parseInt(comboBoxxuatthang.getSelectedItem().toString());
		int nam = Integer.parseInt(comboBoxnam2.getSelectedItem().toString());
		
		Command xuat = new xuatvncm(vs,thang,nam);
		cmp.setCommand(xuat);
		cmp.processcommands();
		List<vnDTO> list = vs.getthang(thang, nam);
		update(list);
    }
    public void tongsl() {
    	Command tong = new tongslvncm(vs);
    	cmp.setCommand(tong);
    	cmp.processcommands();
    	double kq = vs.tongsl();
    	tongsltxt.setText(String.valueOf(kq));
    	List<vnDTO> listvn = vs.getallvn();
		update(listvn);
    }
}

