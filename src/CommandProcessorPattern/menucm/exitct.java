package CommandProcessorPattern.menucm;

import CommandProcessorPattern.Command;
import presentationlayer.nuocngoaiGUI;
import presentationlayer.vietnamGUI;

public class exitct implements Command{
	private vietnamGUI vngui;
	private nuocngoaiGUI nngui;

	public exitct(vietnamGUI vngui, nuocngoaiGUI nngui) {
		this.vngui = vngui;
		this.nngui = nngui;
	}

	@Override
	public void execute() {
		System.exit(0);
	}

}
