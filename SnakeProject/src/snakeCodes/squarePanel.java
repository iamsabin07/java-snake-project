package snakeCodes;

import java.awt.Color;
import javax.swing.JPanel;

public class squarePanel extends JPanel{
	
	/**
	 * Assigning a version number to serializable class squarePanel
	 */
	private static final long serialVersionUID = 1L;

	public squarePanel(Color back){
		this.setBackground(back);
	}
	
	public void changeColor(Color back){
		this.setBackground(back);
		this.repaint();
	}
	
}
