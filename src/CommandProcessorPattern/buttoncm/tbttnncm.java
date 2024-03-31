package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import domainlayer.nuocngoaiservice;
import presentationlayer.nuocngoaiGUI;

public class tbttnncm implements Command{
	private nuocngoaiservice nns;
	
	public tbttnncm(nuocngoaiservice nns) {
		this.nns = nns;
	}

	@Override
	public void execute() {
		nns.tbtt();
	}

}
