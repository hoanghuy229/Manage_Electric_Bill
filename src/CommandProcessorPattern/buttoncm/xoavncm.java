package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import domainlayer.vietnamservice;

public class xoavncm implements Command{
	private vietnamservice vnsv;
	private int vietnamid;
	
	public xoavncm(vietnamservice vnc, int vietnamid) {
		this.vnsv = vnc;
		this.vietnamid = vietnamid;
	}

	@Override
	public void execute() {		
		vnsv.deletekhachhang(vietnamid);
	}

}
