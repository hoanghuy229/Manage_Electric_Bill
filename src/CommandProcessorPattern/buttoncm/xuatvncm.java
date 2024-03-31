package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import domainlayer.vietnamservice;

public class xuatvncm implements Command{
	private vietnamservice vns;
	private int thang;
	private int nam;
	
	public xuatvncm(vietnamservice vns, int thang, int nam) {
		this.vns = vns;
		this.thang = thang;
		this.nam = nam;
	}

	@Override
	public void execute() {
		vns.getthang(thang, nam);
	}


}
