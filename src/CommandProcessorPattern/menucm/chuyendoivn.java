package CommandProcessorPattern.menucm;

import CommandProcessorPattern.Command;
import presentationlayer.nuocngoaiGUI;
import presentationlayer.vietnamGUI;

public class chuyendoivn implements Command{
	private vietnamGUI vngui;
	private nuocngoaiGUI nngui;

	public chuyendoivn(vietnamGUI vngui, nuocngoaiGUI nngui) {
		this.vngui = vngui;
		this.nngui = nngui;
	}
	
	@Override
	public void execute() {	
		vngui.setVisible(false);
		try {
			nngui = new nuocngoaiGUI();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		nngui.setVisible(true);
	}
}

