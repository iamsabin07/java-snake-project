package snakeCodes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {

		/**
		 * This function creates a window to play game
		 */
		JOptionPane.showMessageDialog(null, "Controls. \n A = Left \n D = Right \n W = Top \n S = Bottom");
		
		window gameWindow= new window();
		
		//personalizing the window settings
		gameWindow.setTitle("Welcome to the snake game.");
		gameWindow.setSize(1000,1000);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

	}
}