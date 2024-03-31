package persistencelayer;

import java.util.List;

import DTO.vnDTO;
import Observerpattern.vnsubcriber;
import domainlayer.Model.khachhangvn;

public class vietnamDAOimpl implements vietnamDAO{
	private vietnamgateway vngateway;
	
	public vietnamDAOimpl(vietnamgateway vngateway) {
		this.vngateway = vngateway;
	}

	@Override
	public void addkhachhang(vnDTO vietnam) {
		vngateway.addkhachhang(vietnam);
	}

	@Override
	public void deletekhachhang(int vietnamid) {
		vngateway.deletekhachhang(vietnamid);
	}

	@Override
	public void updatekhachhang(vnDTO vietnam) {
		vngateway.updatekhachhang(vietnam);
	}

	@Override
	public List<vnDTO> getbyid(int vietnamid) {
		return vngateway.getbyid(vietnamid);
	}

	@Override
	public List<vnDTO> getallvn() {
		return vngateway.getallvn();
	}

	@Override
	public List<vnDTO> getthang(int thang,int nam) {
		return vngateway.getthang(thang,nam);
	}

	@Override
	public void add(vnsubcriber o) {
		vngateway.add(o);
	}

	@Override
	public void remove(vnsubcriber o) {
		vngateway.remove(o);
	}

}
