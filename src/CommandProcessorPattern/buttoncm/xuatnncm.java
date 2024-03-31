package CommandProcessorPattern.buttoncm;

import CommandProcessorPattern.Command;
import domainlayer.nuocngoaiservice;

public class xuatnncm implements Command{
	private nuocngoaiservice nvs;
	private int thang;
	private int nam;
	
	public xuatnncm(nuocngoaiservice nvs, int thang, int nam) {
		this.nvs = nvs;
		this.thang = thang;
		this.nam = nam;
	}

	@Override
	public void execute() {
		nvs.getthang(thang, nam);
	}

}
