package presentationlayer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
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
import Observerpattern.nnsubcriber;
import domainlayer.nuocngoaiservice;
import domainlayer.nuocngoaiserviceimpl;
import domainlayer.Model.khachhangnn;
import domainlayer.Model.khachhangvn;

public class nuocngoaiGUI extends JFrame implements nnsubcriber{
	private Commandprocessor cmp;
	private vietnamGUI vngui;
	private nuocngoaiGUI nngui;
	private nuocngoaiservice ns;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tablennmodel;
	private JTextField manntxt;
	private JTextField tennntxt;
	private JTextField slnntxt;
	private JTextField dgnntxt;
	private JTextField timnntxt;
	private JTextField tongslnntxt;
	private JTextField qtnntext;
	private JTextField tbttnntext;
	private JTextField ttnntxt;
	private JMenuItem vn,exit;
	private JMenuBar menuBar;
	private JScrollPane scrollPane;
	private JButton xoabtmnn,suabtmnn,thembtmnn,tongbtmnn,tinhtbbtmnn,xuathdbtm,btnRefresh;
	private JComboBox comboBoxthangnn,comboBoxngaynn,comboBoxnamnn1,comboBoxnamnn2,comboBoxxuatthangnn;
	private JLabel lblNewLabel,lblHTn,lblNgyRaHa,lblSLng,lblnGi,lblXutHan,lblTmKim,lblTngSLng,lblQucTch,lblTrungBnhThnh,lblThnhTin;
	
	
	public nuocngoaiGUI() throws ClassNotFoundException {
		cmp = new Commandprocessor();
		
		ns = new nuocngoaiserviceimpl();
		ns.add(this);
		
		this.setTitle("khách hàng nước ngoài");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 919, 22);
		contentPane.add(menuBar);
		
		vn = new JMenuItem("bảng khách hàng Việt Nam");
		menuBar.add(vn);
		
		exit = new JMenuItem("exit");		
		menuBar.add(exit);
				
		tablennmodel = new DefaultTableModel();
		tablennmodel.addColumn("mã");
		tablennmodel.addColumn("họ tên");
		tablennmodel.addColumn("ngày ra hđ");
		tablennmodel.addColumn("quốc tịch");
		tablennmodel.addColumn("số lượng");
		tablennmodel.addColumn("đơn giá");
		tablennmodel.addColumn("thành tiền");
		table = new JTable(tablennmodel);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 25, 909, 174);
		contentPane.add(scrollPane);

		
		manntxt = new JTextField();
		manntxt.setBounds(110, 220, 134, 30);
		contentPane.add(manntxt);
		manntxt.setColumns(10);
		
		tennntxt = new JTextField();
		tennntxt.setColumns(10);
		tennntxt.setBounds(110, 260, 134, 30);
		contentPane.add(tennntxt);
		
		slnntxt = new JTextField();
		slnntxt.setColumns(10);
		slnntxt.setBounds(428, 220, 134, 30);
		contentPane.add(slnntxt);
		
		dgnntxt = new JTextField();
		dgnntxt.setColumns(10);
		dgnntxt.setBounds(428, 260, 134, 30);
		contentPane.add(dgnntxt);
		
		comboBoxthangnn = new JComboBox();
		comboBoxthangnn.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxthangnn.setBounds(100, 330, 42, 21);
		contentPane.add(comboBoxthangnn);
		
		comboBoxngaynn = new JComboBox();
		comboBoxngaynn.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxngaynn.setBounds(50, 330, 41, 21);
		contentPane.add(comboBoxngaynn);
		
		comboBoxnamnn1 = new JComboBox();
		comboBoxnamnn1.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
		comboBoxnamnn1.setBounds(150, 330, 70, 21);
		contentPane.add(comboBoxnamnn1);
		
		thembtmnn = new JButton("th\u00EAm");
		thembtmnn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thembtmnn.setBounds(237, 372, 100, 30);
		contentPane.add(thembtmnn);
		
		xoabtmnn = new JButton("x\u00F3a");
		xoabtmnn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		xoabtmnn.setBounds(330, 372, 100, 30);
		contentPane.add(xoabtmnn);
		
		suabtmnn = new JButton("s\u1EEDa");
		suabtmnn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		suabtmnn.setBounds(428, 372, 100, 30);
		contentPane.add(suabtmnn);
		
		timnntxt = new JTextField();
		timnntxt.setColumns(10);
		timnntxt.setBounds(734, 220, 134, 30);
		contentPane.add(timnntxt);
		
		tongslnntxt = new JTextField();
		tongslnntxt.setColumns(10);
		tongslnntxt.setBounds(734, 260, 134, 30);
		contentPane.add(tongslnntxt);
		
		comboBoxxuatthangnn = new JComboBox();
		comboBoxxuatthangnn.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxxuatthangnn.setBounds(724, 417, 62, 21);
		contentPane.add(comboBoxxuatthangnn);
		
		lblNewLabel = new JLabel("m\u00E3:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 220, 62, 22);
		contentPane.add(lblNewLabel);
		
		lblHTn = new JLabel("h\u1ECD t\u00EAn:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHTn.setBounds(20, 260, 91, 22);
		contentPane.add(lblHTn);
		
		lblNgyRaHa = new JLabel("ng\u00E0y ra h\u00F3a \u0111\u01A1n:");
		lblNgyRaHa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgyRaHa.setBounds(30, 300, 167, 22);
		contentPane.add(lblNgyRaHa);
		
		lblSLng = new JLabel("s\u1ED1 l\u01B0\u1EE3ng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSLng.setBounds(320, 220, 110, 22);
		contentPane.add(lblSLng);
		
		lblnGi = new JLabel("\u0111\u01A1n gi\u00E1:");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnGi.setBounds(320, 260, 101, 22);
		contentPane.add(lblnGi);
		
		lblXutHan = new JLabel("xu\u1EA5t h\u00F3a \u0111\u01A1n th\u00E1ng:");
		lblXutHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXutHan.setBounds(673, 376, 215, 22);
		contentPane.add(lblXutHan);
		
		lblTmKim = new JLabel("t\u00ECm ki\u1EBFm:");
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTmKim.setBounds(620, 220, 110, 22);
		contentPane.add(lblTmKim);
		
		lblTngSLng = new JLabel("t\u1ED5ng s\u1ED1 l\u01B0\u1EE3ng:");
		lblTngSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngSLng.setBounds(590, 260, 134, 22);
		contentPane.add(lblTngSLng);
		
		comboBoxnamnn2 = new JComboBox();
		comboBoxnamnn2.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
		comboBoxnamnn2.setBounds(796, 417, 70, 21);
		contentPane.add(comboBoxnamnn2);
	
		
		lblQucTch = new JLabel("quốc tịch:");
		lblQucTch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQucTch.setBounds(311, 300, 110, 22);
		contentPane.add(lblQucTch);
		
		qtnntext = new JTextField();
		qtnntext.setColumns(10);
		qtnntext.setBounds(428, 300, 134, 30);
		contentPane.add(qtnntext);
		
		lblTrungBnhThnh = new JLabel("trung bình thành tiền :");
		lblTrungBnhThnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrungBnhThnh.setBounds(596, 300, 237, 22);
		contentPane.add(lblTrungBnhThnh);
		
		tbttnntext = new JTextField();
		tbttnntext.setColumns(10);
		tbttnntext.setBounds(711, 332, 157, 30);
		contentPane.add(tbttnntext);
		lblThnhTin = new JLabel("thành tiền:");
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThnhTin.setBounds(20, 361, 110, 22);
		contentPane.add(lblThnhTin);
		
		ttnntxt = new JTextField();
		ttnntxt.setColumns(10);
		ttnntxt.setBounds(20, 393, 157, 30);
		contentPane.add(ttnntxt);
		tongbtmnn = new JButton("tính tổng");
		tongbtmnn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tongbtmnn.setBounds(510, 417, 120, 30);
		contentPane.add(tongbtmnn);
		
		tinhtbbtmnn = new JButton("tính tbtt");
		tinhtbbtmnn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tinhtbbtmnn.setBounds(377, 417, 120, 30);
		contentPane.add(tinhtbbtmnn);
		xuathdbtm = new JButton("xuất hđ");
		xuathdbtm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		xuathdbtm.setBounds(237, 417, 120, 30);
		contentPane.add(xuathdbtm);
		btnRefresh = new JButton("refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRefresh.setBounds(521, 372, 100, 30);
		contentPane.add(btnRefresh);

		
		tongbtmnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tongsl();
			}
		});
		tinhtbbtmnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbtt();
			}
		});	
		xuathdbtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuathd();
			}
		});
		timnntxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				tim();
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		suabtmnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		xoabtmnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		thembtmnn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				them();
				};
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chondong();
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thoat();
			};
		});
		vn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chuyen();
			};
		});
		List<nnDTO> listnn = ns.getallnn();
		update(listnn);
	}

	

	@Override
	public void update(List<nnDTO> listnn) {
		tablennmodel.setRowCount(0);
		for(nnDTO nuocngoai : listnn) {
			Object[] rowdata= {nuocngoai.getMa(),nuocngoai.getHoten(),nuocngoai.getNgayrahd(),nuocngoai.getQuoctich(),
					nuocngoai.getSoluong(),nuocngoai.getDongia(),nuocngoai.getthanhtien()};
			tablennmodel.addRow(rowdata);
		}
	}
	
	public void clear() {
		manntxt.setText("");
		tennntxt.setText("");
		slnntxt.setText("");
		dgnntxt.setText("");
		timnntxt.setText("");
		tongslnntxt.setText("");
		qtnntext.setText("");
		tbttnntext.setText("");
		ttnntxt.setText("");
		comboBoxthangnn.setSelectedItem("01");
		comboBoxngaynn.setSelectedItem("01");
		comboBoxnamnn1.setSelectedItem("2023");
		comboBoxnamnn2.setSelectedItem("2023");
		comboBoxxuatthangnn.setSelectedItem("01");
	}
	
	public JTextField getma() {
		return manntxt;
	}
	public JTextField getten() {
		return tennntxt;
	}
	public JTextField getslnntxt() {
		return slnntxt;
	}
	public JTextField getdgnntxt() {
		return dgnntxt;
	}
	public JTextField getqtnntext() {
		return qtnntext;
	}
	public JTextField getttnntxt() {
		return ttnntxt;
	}
	public JComboBox getcomboBoxthangnn() {
		return comboBoxthangnn;
	}
	public JComboBox getcomboBoxngaynn() {
		return comboBoxngaynn;
	}
	public JComboBox getcomboBoxnamnn1() {
		return comboBoxnamnn1;
	}
	public JTable gettable() {
		return table;
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
	 
	 private boolean isMaKhachHangExisted(int ma) {
	        List<nnDTO> listnn = ns.getallnn();
	        for (nnDTO nuocngoai : listnn) {
	            if (nuocngoai.getMa() == ma) {
	                return true; 
	            }
	        }
	        return false; // Mã không tồn tại 
	    }
	 
	 
	 public void chuyen() {
		 Command chd = new chuyendoinn(null,nuocngoaiGUI.this);
		 cmp.setCommand(chd);
		 cmp.processcommands();
	 }
	 public void them() {
		 String maKhachHangStr = manntxt.getText();
         String soLuongStr = slnntxt.getText();
         String donGiaStr = dgnntxt.getText();

         if (!isValidNumberFormat(maKhachHangStr)) {
             JOptionPane.showMessageDialog(nuocngoaiGUI.this, "Mã khách hàng không hợp lệ!");
             return; 
         }
         int maKhachHang = Integer.parseInt(maKhachHangStr);

         if (isMaKhachHangExisted(maKhachHang)) {
             JOptionPane.showMessageDialog(nuocngoaiGUI.this, "Mã khách hàng đã tồn tại!");
             List<nnDTO> listnn = ns.getallnn();
				update(listnn);
             return; 
         }

         if (!isValidNumberFormat(soLuongStr)) {
             JOptionPane.showMessageDialog(nuocngoaiGUI.this, "Số lượng không hợp lệ!");
             List<nnDTO> listnn = ns.getallnn();
				update(listnn);
             return; 
         }
         int soLuong = Integer.parseInt(soLuongStr);

         if (!isValidDoubleFormat(donGiaStr)) {
             JOptionPane.showMessageDialog(nuocngoaiGUI.this, "Đơn giá không hợp lệ!");
             List<nnDTO> listnn = ns.getallnn();
				update(listnn);
             return; 
         }
         double donGia = Double.parseDouble(donGiaStr);
         
			String day = comboBoxngaynn.getSelectedItem().toString();
			String month = comboBoxthangnn.getSelectedItem().toString();
			String year = comboBoxnamnn1.getSelectedItem().toString();
			String birth = year+"-"+month+"-"+day;
			String hoten = tennntxt.getText();
			String quoctich = qtnntext.getText();
			double thanhtien = soLuong*donGia;
			Date ngayrahd = Date.valueOf(birth);
			
			nnDTO nuocngoai = new nnDTO(maKhachHang,hoten,soLuong,donGia,ngayrahd,quoctich,thanhtien);
			
			Command them = new themnncm(ns,nuocngoai);
			cmp.setCommand(them);
			cmp.processcommands();
			clear();
			List<nnDTO> listnn = ns.getallnn();
			update(listnn);
	 }
	 public void xoa() {
		 int r = table.getSelectedRow();
			if(r == -1) {
				JOptionPane.showMessageDialog(nuocngoaiGUI.this,"chưa chọn khách hàng");

				return;
			}
			int nuocngoaiid = (int) table.getValueAt(r,0);
			
			Command xoa = new xoanncm(ns,nuocngoaiid);
			cmp.setCommand(xoa);
			cmp.processcommands();
			List<nnDTO> listnn = ns.getallnn();
			update(listnn);
			clear();
	 }
	 public void sua() {
		 int r = table.getSelectedRow();
			if(r == -1) {
				JOptionPane.showMessageDialog(nuocngoaiGUI.this,"chưa chọn khách hàng");
				return;
			}
			 
			 int id = Integer.parseInt(table.getValueAt(r,0).toString());
			 String maKhachHangStr = manntxt.getText();
			 String soLuongStr = slnntxt.getText();
          String donGiaStr = dgnntxt.getText();
          
          if (!isValidNumberFormat(maKhachHangStr) || !isValidNumberFormat(soLuongStr) || !isValidDoubleFormat(donGiaStr)) {
                 JOptionPane.showMessageDialog(nuocngoaiGUI.this, "không đúng định dạng!");
                 return; 
             }
          
			 if(Integer.valueOf(maKhachHangStr) != id) {
					JOptionPane.showMessageDialog(nuocngoaiGUI.this,"mã không thay đổi được");
					return;
			 }
	
             int soLuong = Integer.parseInt(soLuongStr);
             double donGia = Double.parseDouble(donGiaStr);
             String day = comboBoxngaynn.getSelectedItem().toString();
				String month = comboBoxthangnn.getSelectedItem().toString();
				String year = comboBoxnamnn1.getSelectedItem().toString();
				String birth = year+"-"+month+"-"+day;
				String hoten = tennntxt.getText();
				String quoctich = qtnntext.getText();
				double thanhtien = soLuong*donGia;
				Date ngayrahd = Date.valueOf(birth);
				int maKhachHang = Integer.parseInt(maKhachHangStr);
				
				nnDTO nuocngoai = new nnDTO(maKhachHang,hoten,soLuong,donGia,ngayrahd,quoctich,thanhtien);
				
				Command sua = new suanncm(ns,nuocngoai);
				cmp.setCommand(sua);
				cmp.processcommands();
				clear();
				List<nnDTO> listnn = ns.getallnn();
				update(listnn);
	 }
	 public void thoat() {
		 Command thoatgd = new exitct(null,nuocngoaiGUI.this);
		 cmp.setCommand(thoatgd);
		 cmp.processcommands();
	 }
	 public void chondong() {
		 int rowIndex = table.getSelectedRow();
         if (rowIndex >= 0) {
             String ma = table.getValueAt(rowIndex, 0).toString();
             String ten = table.getValueAt(rowIndex, 1).toString();
             String ngayRaHD = table.getValueAt(rowIndex, 2).toString();
             String quocTich = table.getValueAt(rowIndex, 3).toString();
             String soLuong = table.getValueAt(rowIndex, 4).toString();
             String donGia = table.getValueAt(rowIndex, 5).toString();
             String thanhTien = table.getValueAt(rowIndex, 6).toString();

             nnclickcm updateCommand = new nnclickcm(ma, ten, ngayRaHD, quocTich, soLuong, donGia, thanhTien,nuocngoaiGUI.this);
             cmp.setCommand(updateCommand);
             cmp.processcommands();
         }
	 }
	 public void tim() {
		 String timkiem = timnntxt.getText();
		 if(!isValidNumberFormat(timkiem)) {
			 List<nnDTO> listnn = ns.getallnn();
				update(listnn);
             return; 
		 }
		 		 
		if(!timnntxt.getText().equals("")) {
			int id = Integer.parseInt(timnntxt.getText());
			Command tim = new timnncm(ns, id);
			cmp.setCommand(tim);
			cmp.processcommands();
			List<nnDTO> listnn1 = ns.getbyid(id);
			update(listnn1);
			}
	 }
	 public void xuathd() {
			int thang = Integer.parseInt(comboBoxxuatthangnn.getSelectedItem().toString());
			int nam = Integer.parseInt(comboBoxnamnn2.getSelectedItem().toString());
			
			Command xuat = new xuatnncm(ns,thang,nam);
			cmp.setCommand(xuat);
			cmp.processcommands();
			List<nnDTO> list = ns.getthang(thang, nam);
			update(list);
	 }
	 public void refresh() {
			List<nnDTO> listnn = ns.getallnn();
			update(listnn);
			clear();
	 }
	 public void tbtt() {
		Command tbtt = new tbttnncm(ns);
		cmp.setCommand(tbtt);
		cmp.processcommands();
		double trungbinh = ns.tbtt();
		tbttnntext.setText(String.valueOf(trungbinh));
		List<nnDTO> listnn = ns.getallnn();
		update(listnn);
		}
	public void tongsl() {

		Command tsl = new tongslnncm(ns);
		cmp.setCommand(tsl);
		cmp.processcommands();
		double tong = ns.tongsl();
		tongslnntxt.setText(String.valueOf(tong));
		List<nnDTO> listnn = ns.getallnn();
		update(listnn);
	}

}
