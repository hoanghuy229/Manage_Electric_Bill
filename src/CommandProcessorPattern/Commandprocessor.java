package CommandProcessorPattern;

public class Commandprocessor {
	private Command cm;
	
	public void setCommand(Command cm) {
		this.cm = cm;
	}
	public void processcommands() {
			cm.execute();
		}
	}
