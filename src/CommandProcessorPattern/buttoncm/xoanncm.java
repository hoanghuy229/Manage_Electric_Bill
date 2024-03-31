package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import domainlayer.nuocngoaiservice;

public class xoanncm implements Command{
	private nuocngoaiservice nnsv;
	private int nuocngoaiid;
	
	public xoanncm(nuocngoaiservice nnsv, int nuocngoaiid) {
		this.nnsv = nnsv;
		this.nuocngoaiid = nuocngoaiid;
	}

	@Override
	public void execute() {
		nnsv.deletekhachhang(nuocngoaiid);
	}
	

}
