package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import DTO.vnDTO;
import domainlayer.vietnamservice;

public class suavncm implements Command{
	private vietnamservice vnsv;
	private vnDTO vietnamdto;
	
	public suavncm(vietnamservice vnc, vnDTO vietnamdto) {
		this.vnsv = vnc;
		this.vietnamdto = vietnamdto;
	}

	@Override
	public void execute() {
		vnsv.updatekhachhang(vietnamdto);
	}

}
