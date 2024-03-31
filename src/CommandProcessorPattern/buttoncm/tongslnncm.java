package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import domainlayer.nuocngoaiservice;

public class tongslnncm implements Command{
	private nuocngoaiservice nns;
	
	public tongslnncm(nuocngoaiservice nns) {
		this.nns = nns;
	}

	@Override
	public void execute() {
		nns.tongsl();
	}
}
