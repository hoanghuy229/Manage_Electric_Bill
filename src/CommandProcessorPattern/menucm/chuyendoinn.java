package CommandProcessorPattern.menucm;

import CommandProcessorPattern.Command;
import presentationlayer.nuocngoaiGUI;
import presentationlayer.vietnamGUI;

public class chuyendoinn implements Command{
	private vietnamGUI vngui;
	private nuocngoaiGUI nngui;

	public chuyendoinn(vietnamGUI vngui, nuocngoaiGUI nngui) {
		this.vngui = vngui;
		this.nngui = nngui;
	}

	@Override
	public void execute() {		
		nngui.setVisible(false);
		try {
			vngui = new vietnamGUI();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		vngui.setVisible(true);
	}
}
