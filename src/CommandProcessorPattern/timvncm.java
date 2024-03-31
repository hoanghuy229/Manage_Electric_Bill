package CommandProcessorPattern;

import CommandProcessorPattern.Command;
import domainlayer.vietnamservice;

public class timvncm implements Command{
	private vietnamservice vns;
	private int vietnamid;
	
	public timvncm(vietnamservice vns, int vietnamid) {
		this.vns = vns;
		this.vietnamid = vietnamid;
	}

	@Override
	public void execute() {
		vns.getbyid(vietnamid);
	}

}
