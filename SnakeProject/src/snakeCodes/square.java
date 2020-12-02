package snakeCodes;
import java.util.ArrayList;
import java.awt.Color;
public class square {
	
		
		//creating an arraylist to store the colors
		ArrayList<Color> colorList =new ArrayList<Color>();
		/**
		 * element: Snake, Food
		 * 2: for Snake
		 * 1: for Food
		 */
		int colorCode; 
		squarePanel square;
		public square(int colInt){
			
			//storing colors to the arraylist
			colorList.add(Color.WHITE); 
			colorList.add(Color.ORANGE);
			colorList.add(Color.BLACK);
			colorCode=colInt;
			square = new squarePanel(colorList.get(colorCode));
		}
		public void elementColor(int c){
			square.changeColor(colorList.get(c));
		}
	}

