/**
 * This class stores the key pressed and executes the direction in the game.
 */
package snakeCodes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class keyboardListener extends KeyAdapter{
 	
 		public void keyPressed(KeyEvent e){
 			/**
 			 * to store the key pressed
 			 * 65: Left (when A is pressed)
 			 * 68: Right (When D is pressed)
 			 * 83: Bottom (when S is pressed)
 			 * 87: Top (when W is pressed)
 			 */
 			int keyMap = e.getKeyCode();
 		    switch(keyMap){
 		    case 65: 	
 		    	//conditional statement to execute if the direction is not opposite.
				if(gameAction.snakeDirection!=1)
				gameAction.snakeDirection=2;
				break;
			case 68:	
				//conditional statement to execute if the direction is not opposite.
				if(gameAction.snakeDirection!=2) 
				gameAction.snakeDirection=1;
				break;
			case 83:	
				//conditional statement to execute if the direction is not opposite.
				if(gameAction.snakeDirection!=3)
				gameAction.snakeDirection=4;
				break;
			case 87:	
				//conditional statement to execute if the direction is not opposite.
				if(gameAction.snakeDirection!=4) 
				gameAction.snakeDirection=3;
				break;
			default: 
				break;
			}
		}	
 }