package persistencelayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DTO.nnDTO;
import DTO.vnDTO;
import Observerpattern.nnsubcriber;
import Observerpattern.nnpublisher;
import Observerpattern.vnsubcriber;

import java.util.ArrayList;
import java.util.Calendar;


import domainlayer.Model.khachhangnn;
import domainlayer.Model.khachhangvn;

public class nuocngoaigatewayimpl implements nuocngoaigateway,nnpublisher{
    private Connection connection;
	private List<nnsubcriber> nnobservers = new ArrayList<>();
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/thicuoiky";
	private final String USERNAME = "root"; 
	private final String PASSWORD = "huy22092003";

    
    public nuocngoaigatewayimpl(){}

	@Override
	public void addkhachhang(nnDTO nuocngoai) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String query = "insert into khachhangnuocngoai(ma,hoten,ngayrahd,quoctich,soluong,dongia,thanhtien) values(?,?,?,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(1,nuocngoai.getMa());
			ps.setString(2,nuocngoai.getHoten());
			ps.setDate(3,nuocngoai.getNgayrahd());
			ps.setString(4,nuocngoai.getQuoctich());
			ps.setDouble(5,nuocngoai.getSoluong());
			ps.setDouble(6,nuocngoai.getDongia());
			ps.setDouble(7,nuocngoai.getthanhtien());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deletekhachhang(int nuocngoaiid) {
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String query = "delete from khachhangnuocngoai where ma=?";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(1,nuocngoaiid);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatekhachhang(nnDTO nuocngoai) {
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String query = "update khachhangnuocngoai set hoten=?,ngayrahd=?,quoctich=?,soluong=?,dongia=?,thanhtien=? where ma=?";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(7,nuocngoai.getMa());
			ps.setString(1,nuocngoai.getHoten());
			ps.setDate(2,nuocngoai.getNgayrahd());
			ps.setString(3,nuocngoai.getQuoctich());
			ps.setDouble(4,nuocngoai.getSoluong());
			ps.setDouble(5,nuocngoai.getDongia());
			ps.setDouble(6,nuocngoai.getthanhtien());
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public List<nnDTO> getbyid(int nuocngoaiid) {
		List<nnDTO> nndto = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM khachhangnuocngoai WHERE ma = ?")) {		
			preparedStatement.setInt(1,nuocngoaiid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int ma = resultSet.getInt("ma");
				String ten = resultSet.getString("hoten");
				Date ngayrahd = resultSet.getDate("ngayrahd");
				String quoctich = resultSet.getString("quoctich");
				Double soluong = resultSet.getDouble("soluong");
				Double dongia = resultSet.getDouble("dongia");
				double tt =dongia*soluong;
				nnDTO nuocngoai = new nnDTO(ma,ten,soluong,dongia,ngayrahd,quoctich,tt);
				nndto.add(nuocngoai);
			}
			notifyobserver();
			return nndto;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		finally {
	        closeConnection();
	    }
	}

	@Override
	public List<nnDTO> getallnn() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM khachhangnuocngoai")) {
			List<nnDTO> nndto = new ArrayList<>();
			while(resultSet.next()) {
				int ma = resultSet.getInt("ma");
				String ten = resultSet.getString("hoten");
				Date ngayrahd = resultSet.getDate("ngayrahd");
				String quoctich = resultSet.getString("quoctich");
				Double soluong = resultSet.getDouble("soluong");
				Double dongia = resultSet.getDouble("dongia");
				double tt =dongia*soluong;
				nnDTO nuocngoai = new nnDTO(ma,ten,soluong,dongia,ngayrahd,quoctich,tt);
				nndto.add(nuocngoai);
			}
			notifyobserver();
			return nndto;
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
	public List<nnDTO> getthang(int thang,int nam) {
		List<nnDTO> nndto = new ArrayList<>();
		
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM khachhangnuocngoai WHERE MONTH(ngayrahd) = ? AND YEAR(ngayrahd) = ?")) {		
			preparedStatement.setInt(1,thang);
			preparedStatement.setInt(2,nam);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int ma = resultSet.getInt("ma");
				String ten = resultSet.getString("hoten");
				Date ngayrahd = resultSet.getDate("ngayrahd");
				String quoctich = resultSet.getString("quoctich");
				Double soluong = resultSet.getDouble("soluong");
				Double dongia = resultSet.getDouble("dongia");
				double tt =dongia*soluong;
				nnDTO nuocngoai = new nnDTO(ma,ten,soluong,dongia,ngayrahd,quoctich,tt);
				nndto.add(nuocngoai);
			}
			notifyobserver();
			return nndto;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		finally {
	        closeConnection();
	    }
	}

	@Override
	public void add(nnsubcriber o) {
		nnobservers.add(o);
	}

	@Override
	public void remove(nnsubcriber o) {
		nnobservers.remove(o);
	}

	@Override
	public void notifyobserver() {
		List<nnDTO> nndto = new ArrayList<>();
		for(nnsubcriber o : nnobservers) {
			o.update(nndto);
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
