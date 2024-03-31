package persistencelayer;

import java.util.List;

import DTO.nnDTO;
import Observerpattern.nnsubcriber;
import domainlayer.Model.khachhangnn;

public interface nuocngoaigateway {
	void addkhachhang(nnDTO nuocngoai);
	void deletekhachhang(int nuocngoaiid);
	void updatekhachhang(nnDTO nuocngoai);
	List<nnDTO> getbyid(int nuocngoaiid);
	List<nnDTO> getallnn();
	List<nnDTO> getthang(int thang,int nam);
	void add(nnsubcriber o);
	void remove(nnsubcriber o);

}
