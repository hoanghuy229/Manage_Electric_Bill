package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import domainlayer.vietnamservice;

public class tongslvncm implements Command{
	private vietnamservice vns;
	
	public tongslvncm(vietnamservice vns) {
		this.vns = vns;
	}

	@Override
	public void execute() {
		vns.tongsl();
	}

}
