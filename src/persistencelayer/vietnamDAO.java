	package persistencelayer;

import java.util.List;

import DTO.vnDTO;
import Observerpattern.vnsubcriber;
import domainlayer.Model.khachhangvn;

public interface vietnamDAO {
	void addkhachhang(vnDTO vietnam);
	void deletekhachhang(int vietnamid);
	void updatekhachhang(vnDTO vietnam);
	List<vnDTO> getbyid(int vietnamid);
	List<vnDTO> getallvn();
	List<vnDTO> getthang(int thang,int nam);
	void add(vnsubcriber o);
	void remove(vnsubcriber o);
}
