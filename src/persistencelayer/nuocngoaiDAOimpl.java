package persistencelayer;

import java.util.List;

import DTO.nnDTO;
import Observerpattern.nnsubcriber;
import domainlayer.Model.khachhangnn;

public class nuocngoaiDAOimpl implements nuocngoaiDAO{
	private nuocngoaigateway nngateway;

	public nuocngoaiDAOimpl(nuocngoaigateway nngateway) {
		this.nngateway = nngateway;
	}

	@Override
	public void addkhachhang(nnDTO nuocngoai) {
		nngateway.addkhachhang(nuocngoai);
	}

	@Override
	public void deletekhachhang(int nuocngoaiid) {
		nngateway.deletekhachhang(nuocngoaiid);
	}

	@Override
	public void updatekhachhang(nnDTO nuocngoai) {
		nngateway.updatekhachhang(nuocngoai);
	}

	@Override
	public List<nnDTO> getbyid(int nuocngoaiid) {
		return nngateway.getbyid(nuocngoaiid);
	}

	@Override
	public List<nnDTO> getallnn() {
		return nngateway.getallnn();
	}

	@Override
	public List<nnDTO> getthang(int thang,int nam) {
		return nngateway.getthang(thang,nam);
	}

	@Override
	public void add(nnsubcriber o) {
	    nngateway.add(o);
	}

	@Override
	public void remove(nnsubcriber o) {
		nngateway.remove(o);
	}

}
