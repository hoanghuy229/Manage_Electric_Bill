package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import DTO.vnDTO;
import domainlayer.vietnamservice;

public class themvncm implements Command{
	private vietnamservice vnsv;
	private vnDTO vietnamdto;

	public themvncm(vietnamservice vnc, vnDTO vietnamdto) {
		this.vnsv = vnc;
		this.vietnamdto = vietnamdto;
	}



	@Override
	public void execute() {
		vnsv.addkhachhang(vietnamdto);
	}

}
