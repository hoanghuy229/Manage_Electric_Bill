package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import DTO.nnDTO;
import domainlayer.nuocngoaiservice;

public class themnncm implements Command{
	private nuocngoaiservice nnsv;
	private nnDTO nuocngoaidto;
	
	public themnncm(nuocngoaiservice nvc, nnDTO nuocngoaidto) {
		this.nnsv = nvc;
		this.nuocngoaidto = nuocngoaidto;
	}

	@Override
	public void execute() {	
		nnsv.addkhachhang(nuocngoaidto);
	}

}
