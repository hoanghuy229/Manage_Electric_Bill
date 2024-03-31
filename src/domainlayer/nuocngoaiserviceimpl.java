package domainlayer;

import java.util.List;

import DTO.nnDTO;
import Observerpattern.nnsubcriber;
import domainlayer.Model.khachhangnn;
import persistencelayer.*;

public class nuocngoaiserviceimpl implements nuocngoaiservice {
	private nuocngoaiDAO nuocngoaidao;
	
	public nuocngoaiserviceimpl() throws ClassNotFoundException {
		nuocngoaidao = new nuocngoaiDAOimpl(new nuocngoaigatewayimpl());
	}

	@Override
	public void addkhachhang(nnDTO nuocngoai) {	
		nuocngoaidao.addkhachhang(nuocngoai);
	}

	@Override
	public void deletekhachhang(int nuocngoaiid) {	
		nuocngoaidao.deletekhachhang(nuocngoaiid);
	}

	@Override
	public void updatekhachhang(nnDTO nuocngoai) {		
		nuocngoaidao.updatekhachhang(nuocngoai);
	}

	@Override
	public List<nnDTO> getbyid(int nuocngoaiid) {
		return nuocngoaidao.getbyid(nuocngoaiid);
	}

	@Override
	public List<nnDTO> getallnn() {
		return nuocngoaidao.getallnn();
	}

	@Override
	public List<nnDTO> getthang(int thang,int nam) {
		return nuocngoaidao.getthang(thang,nam);
	}

	@Override
	public double tongsl() {
		List<nnDTO> nndto = getallnn();
		double tongsl = 0;
		for(nnDTO nuocngoai:nndto) {
				tongsl += nuocngoai.getSoluong();
		}
		return tongsl;
	}

	@Override
	public double tbtt() {
		List<nnDTO> nndto = getallnn();
		double tong = 0;
		int slkhnn = 0;
		for(nnDTO nuocngoai:nndto) {
		tong += nuocngoai.getthanhtien();
		slkhnn++;
		   }
		if (slkhnn > 0) {
		    return tong / slkhnn;
		    } else {
		       return 0;
		       
		   }
	}

	@Override
	public void add(nnsubcriber o) {
		nuocngoaidao.add(o);
	}

	@Override
	public void remove(nnsubcriber o) {
		nuocngoaidao.remove(o);
	}
	

}
