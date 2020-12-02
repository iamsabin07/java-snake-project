/**
 * This class gives the attributes to the direction and position of snake
 */
package snakeCodes;

public class snake { 
	  public  int x; 
	  public  int y; 
	  
	  // x and y represent the x and y plane along which the snake moves
	  public snake(int x, int y) { 
	    this.x = x; 
	    this.y = y; 
	  } 
	  public void changeData(int x, int y){
		    this.x = x; 
		    this.y = y; 
	  }
	  public int getX(){
		  return x;
	  }
	  public int getY(){
		  return y;
	  }
	
		  
} 
