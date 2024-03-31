package CommandProcessorPattern;

import CommandProcessorPattern.Command;
import domainlayer.nuocngoaiservice;

public class timnncm implements Command{
	private nuocngoaiservice nns;
	private int nuocngoaiid;
	
	public timnncm(nuocngoaiservice nns, int nuocngoaiid) {
		this.nns = nns;
		this.nuocngoaiid = nuocngoaiid;
	}

	@Override
	public void execute() {
		nns.getbyid(nuocngoaiid);
	}

}
