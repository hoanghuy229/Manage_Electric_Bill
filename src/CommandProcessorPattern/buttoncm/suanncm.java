package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import DTO.nnDTO;
import domainlayer.nuocngoaiservice;

public class suanncm implements Command{
	private nuocngoaiservice nnsv;
	private nnDTO nuocngoaidto;
	
	public suanncm(nuocngoaiservice nvc, nnDTO nuocngoaidto) {
		this.nnsv = nvc;
		this.nuocngoaidto = nuocngoaidto;
	}

	@Override
	public void execute() {	
		nnsv.updatekhachhang(nuocngoaidto);
	}

}
