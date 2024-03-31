package domainlayer;

import java.util.List;

import DTO.nnDTO;
import DTO.vnDTO;
import Observerpattern.vnsubcriber;
import domainlayer.Model.khachhangvn;
import persistencelayer.*;


public class vietnamserviceimpl implements vietnamservice {
	private vietnamDAO vietnamdao;
	
	public vietnamserviceimpl() throws ClassNotFoundException {
		vietnamdao = new vietnamDAOimpl(new vietnamgatewayimpl());
	}
	
	@Override
	public void addkhachhang(vnDTO vietnam) {		
		vietnamdao.addkhachhang(vietnam);
	}

	@Override
	public void deletekhachhang(int vietnamid) {		
		vietnamdao.deletekhachhang(vietnamid);
	}

	@Override
	public void updatekhachhang(vnDTO vietnam) {		
		vietnamdao.updatekhachhang(vietnam);
	}

	@Override
	public List<vnDTO> getbyid(int vietnamid) {
		return vietnamdao.getbyid(vietnamid);
	}

	@Override
	public List<vnDTO> getallvn() {
		return vietnamdao.getallvn();
	}

	@Override
	public List<vnDTO> getthang(int thang,int nam) {
		return vietnamdao.getthang(thang,nam);
	}

	@Override
	public double tongsl() {
		List<vnDTO> vndto = getallvn();
		double tongsl = 0;
		for(vnDTO vietnam:vndto) {
				tongsl += vietnam.getSoluong();
		}
		return tongsl;
	}

	@Override
	public void add(vnsubcriber o) {
		vietnamdao.add(o);
	}

	@Override
	public void remove(vnsubcriber o) {
		vietnamdao.remove(o);
	}

}
