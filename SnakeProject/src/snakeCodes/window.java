/**
 * This class personalizes the window where the game is to be played.
 */
package snakeCodes;


import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


	class window extends JFrame{
		
		private static final long serialVersionUID = 123456789L;
		public static ArrayList<ArrayList<square>> gameArena;
		public static int width = 20;
		public static int height = 20;
		
		public window(){		
			// Creating the array list that stores all the thread.
			gameArena = new ArrayList<ArrayList<square>>();
			ArrayList<square> values;
			
			// Creating values and adding its data to the array list.
			for(int widthIndex=0;widthIndex<width;widthIndex++){
				values= new ArrayList<square>();
				for(int heightIndex=0;heightIndex<height;heightIndex++){
					square c = new square(2);
					values.add(c);
				}
				gameArena.add(values);
			}
			
			// To set up the layout of the panel
			getContentPane().setLayout(new GridLayout(20,20,0,0));
			
			// adding every square of each value to the panel
			for(int widthIndex=0; widthIndex<width; widthIndex++){
				for(int heightIndex=0; heightIndex<height; heightIndex++){
					getContentPane().add(gameArena.get(widthIndex).get(heightIndex).square);
				}
			}
			
			// initial position of the snake
			snake position = new snake(0,0);
			// passing this value to the controller
			gameAction c = new gameAction(position);
			//starting the game
			c.start();
	
			// This allows the user to control the snake.
			this.addKeyListener((KeyListener) new keyboardListener());
	
			
	}
}
