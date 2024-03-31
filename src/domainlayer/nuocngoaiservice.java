package domainlayer;

import java.util.List;

import DTO.nnDTO;
import Observerpattern.nnsubcriber;
import Observerpattern.vnsubcriber;

public interface nuocngoaiservice {
	void addkhachhang(nnDTO nuocngoai);
	void deletekhachhang(int nuocngoaiid);
	void updatekhachhang(nnDTO nuocngoai);
	List<nnDTO> getbyid(int nuocngoaiid);
	List<nnDTO> getallnn();
	List<nnDTO> getthang(int thang,int nam);
	double tongsl();
	double tbtt();
	void add(nnsubcriber o);
	void remove(nnsubcriber o);
}
