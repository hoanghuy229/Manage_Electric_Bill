package persistencelayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.nnDTO;
import DTO.vnDTO;
import Observerpattern.vnsubcriber;
import Observerpattern.vnpublisher;

import java.util.Calendar;
import domainlayer.Model.khachhangvn;

public class vietnamgatewayimpl implements vietnamgateway,vnpublisher{
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/thicuoiky";
	private static String USERNAME = "root"; 
	private static String PASSWORD = "huy22092003";
	
	 private Connection connection;
	 
	 private List<vnsubcriber> vnobservers = new ArrayList<>();
	 
	 public vietnamgatewayimpl(){}

	 

	@Override
	public void addkhachhang(vnDTO vietnam) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String query = "insert into khachhangvn(ma,hoten,ngayrahd,doituongkh,soluong,dongia,dinhmuc,thanhtien) values(?,?,?,?,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(1,vietnam.getMa());
			ps.setString(2,vietnam.getHoten());
			ps.setDate(3,vietnam.getNgayrahd());
			ps.setString(4,vietnam.getDoituongkh());
			ps.setDouble(5,vietnam.getSoluong());
			ps.setDouble(6,vietnam.getDongia());
			ps.setDouble(7,vietnam.getDinhmuc());
			ps.setDouble(8,vietnam.getthanhtien());
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deletekhachhang(int vietnamid) {
		try {
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String query = "delete from khachhangvn where ma=?";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(1,vietnamid);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatekhachhang(vnDTO vietnam) {
		try {
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String query = "update khachhangvn set hoten=?,ngayrahd=?,doituongkh=?,soluong=?,dongia=?,dinhmuc=?,thanhtien=? where ma=?";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(8,vietnam.getMa());
			ps.setString(1,vietnam.getHoten());
			ps.setDate(2,vietnam.getNgayrahd());
			ps.setString(3,vietnam.getDoituongkh());
			ps.setDouble(4,vietnam.getSoluong());
			ps.setDouble(5,vietnam.getDongia());
			ps.setDouble(6,vietnam.getDinhmuc());
			ps.setDouble(7,vietnam.getthanhtien());
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public List<vnDTO> getbyid(int vietnamid) {
		List<vnDTO> vndto = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM khachhangvn WHERE ma = ?")) {		
			preparedStatement.setInt(1,vietnamid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int ma = resultSet.getInt("ma");
				String ten = resultSet.getString("hoten");
				Date ngayrahd = resultSet.getDate("ngayrahd");
				String doituongkh = resultSet.getString("doituongkh");
				Double soluong = resultSet.getDouble("soluong");
				Double dongia = resultSet.getDouble("dongia");
				Double dinhmuc = resultSet.getDouble("dinhmuc");
				double tt;
				if(soluong <= dinhmuc) {
					  tt = soluong*dongia;
				}
				else {
					double vuotdinhmuc = soluong-dinhmuc;
					  tt = (dinhmuc * dongia) + (vuotdinhmuc * dongia * 2.5);
				}
				vnDTO vietnam = new vnDTO(ma,ten,soluong,dongia,ngayrahd,dinhmuc,doituongkh,tt);
				vndto.add(vietnam);
			}
			notifyobserver();
			return vndto;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		finally {
	        closeConnection();
	    }
	}

	@Override
	public List<vnDTO> getallvn() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM khachhangvn")) {
			List<vnDTO> vndto  = new ArrayList<>();
			while(resultSet.next()) {
				int ma = resultSet.getInt("ma");
				String ten = resultSet.getString("hoten");
				Date ngayrahd = resultSet.getDate("ngayrahd");
				String doituongkh = resultSet.getString("doituongkh");
				Double soluong = resultSet.getDouble("soluong");
				Double dongia = resultSet.getDouble("dongia");
				Double dinhmuc = resultSet.getDouble("dinhmuc");
				double tt;
				if(soluong <= dinhmuc) {
					  tt = soluong*dongia;
				}
				else {
					double vuotdinhmuc = soluong-dinhmuc;
					  tt = (dinhmuc * dongia) + (vuotdinhmuc * dongia * 2.5);
				}
				vnDTO vietnam = new vnDTO(ma,ten,soluong,dongia,ngayrahd,dinhmuc,doituongkh,tt);
				vndto.add(vietnam);
				
			}
			notifyobserver();
			return vndto;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		finally {
	        closeConnection();
	    }
	}


	@Override
	public List<vnDTO> getthang(int thang,int nam) {
		List<vnDTO> vndto = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM khachhangvn WHERE MONTH(ngayrahd) = ? AND YEAR(ngayrahd) = ?")) {		
			preparedStatement.setInt(1,thang);
			preparedStatement.setInt(2,nam);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int ma = resultSet.getInt("ma");
				String ten = resultSet.getString("hoten");
				Date ngayrahd = resultSet.getDate("ngayrahd");
				String doituongkh = resultSet.getString("doituongkh");
				Double soluong = resultSet.getDouble("soluong");
				Double dongia = resultSet.getDouble("dongia");
				Double dinhmuc = resultSet.getDouble("dinhmuc");
				double tt;
				if(soluong <= dinhmuc) {
					  tt = soluong*dongia;
				}
				else {
					double vuotdinhmuc = soluong-dinhmuc;
					  tt = (dinhmuc * dongia) + (vuotdinhmuc * dongia * 2.5);
				}
				vnDTO vietnam = new vnDTO(ma,ten,soluong,dongia,ngayrahd,dinhmuc,doituongkh,tt);
				vndto.add(vietnam);
			}
			notifyobserver();
			return vndto;
			}catch (SQLException e) {
				e.printStackTrace();
				return new ArrayList<>();
			}
		finally {
	        closeConnection();
	    }
	}

	@Override
	public void add(vnsubcriber o) {
		vnobservers.add(o);
	}

	@Override
	public void remove(vnsubcriber o) {
		vnobservers.remove(o);
	}

	@Override
	public void notifyobserver() {
		List<vnDTO> vndto = new ArrayList<>();
		for(vnsubcriber o : vnobservers) {
			o.update(vndto);
		}
	}
	public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
}

