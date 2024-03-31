package test;

import javax.swing.SwingUtilities;

import presentationlayer.nuocngoaiGUI;
import presentationlayer.vietnamGUI;

public abstract class test {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try {
						new vietnamGUI().setVisible(true);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
	            }
	        });
	}

}
