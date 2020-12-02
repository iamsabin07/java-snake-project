/**
 * This class is the primary class that controls all the action of the game
 */
package snakeCodes;

import java.util.ArrayList;


import javax.swing.JOptionPane;

public class gameAction extends Thread {
	
	//initializing ArrayList
	 ArrayList<ArrayList<square>> squares;
	 
	 snake snakeHeadPosition;
	
	 //assigning the size of the snake.
	 int snakeSize;
	 
	 //assigning the speed of the snake.
	 long snakeSpeed;
	 
	 
	 //to store the direction of snake.
	 public static int snakeDirection ;
	 
	 //to store the score
	 public static int score = 0;
	 
	 //to store the highest score
	 public static int highest=0;

	 public static boolean restart =false;
	 //creating an array to store the position of snake and food
	 ArrayList<snake> positions;
	 
	 snake foodPosition, positionChange;
 
	 gameAction(snake positionChanger){
		 	positionChange = positionChanger;
		 	initializeGame();
	 }
		
	 //starts the game
	 void initializeGame() {
		
	 	squares = new ArrayList<ArrayList<square>>();
	    squares = window.gameArena;
		
	    snakeSize = 3;
	    snakeSpeed = 140;
	    
	    positions = new ArrayList<snake>();
	    
		snakeHeadPosition = new snake(positionChange.x,positionChange.y);
		snakeDirection = 1;

		//The position of head (x and y coordinates in the grid)
		snake headPosition = new snake(snakeHeadPosition.getX(),snakeHeadPosition.getY());
		positions.add(headPosition);
		
		foodPosition= new snake(window.height-1,window.width-1);
		newFood(foodPosition);

	 }
	 //restarts the game
	 void restart(){
		 //stores new high score
		 if (score>highest)
			highest = score;
	 	 if(restart)
	 		 score = 0;
	 		for(int i = 0; i< squares.size();i++){
               for(int j = 0;j < squares.get(0).size();j++){
                   squares.get(i).get(j).elementColor(2);
               } 
	 		}
             initializeGame();
	  }
	 
	 //run action overrides in thread 
	 public void run() {
		 while(true){
			 moveInternal(snakeDirection);
			 checkCollision();
			 moveExternal();
			 shortenTail();
			 pauseMethod();
		 }
	 }
	 
	 //pause the game
	 private void pauseMethod(){
		 try {
				sleep(snakeSpeed);
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	 }
	 
	 //Checking if the snake bites itself or is eating
	 private void checkCollision() {
		 snake positionCritic = positions.get(positions.size()-1);
		 for(int i = 0;i<=positions.size()-2;i++){
			 boolean headBitesTail = positionCritic.getX()==positions.get(i).getX() && positionCritic.getY()==positions.get(i).getY();
			 if(headBitesTail){
				 
				 System.out.println();
				 int response = JOptionPane.showConfirmDialog(null, "Game Over. You scored " + score + " points. \n Do you want to restart?");
				 
				 if(response == 0) {
					 restart = true;
					 restart();
					 
				 }
				 else {
					 if(!restart) {
						 JOptionPane.showMessageDialog(null, "Thank you for playing. \n Highest Score: " + score +" points.");
					     System.exit(0);	
					 }
					 else if(highest>score) {
						 JOptionPane.showMessageDialog(null, "Thank you for playing. \n Highest Score: " + highest +" points.");
						 System.exit(0);
					 }
						 else {
							 JOptionPane.showMessageDialog(null, "Thank you for playing. \n Highest Score: " + score +" points.");
						     System.exit(0);
						 }
				}
						 
			}
		}
		 
		 boolean eatFood = positionCritic.getX()==foodPosition.y && positionCritic.getY()==foodPosition.x;
		 if(eatFood){
			 
			 score++;			 
			 snakeSpeed-=5;
			 snakeSize++;
			 foodPosition = noSnake();
			 newFood(foodPosition);	
		 }
	 }
		 

	 //Put food in a position and displays it
	 private void newFood(snake foodPositionCoords){
		 	squares.get(foodPositionCoords.x).get(foodPositionCoords.y).elementColor(1);
	 }
	 
	 //return all position without snake
	 private snake noSnake(){
		 snake s ;
		 int ranX= 0 + (int)(Math.random()*19); 
		 int ranY= 0 + (int)(Math.random()*19); 
		 s=new snake(ranX,ranY);
		 for(int index = 0;index<=positions.size()-1;index++){
			 if(s.getY()==positions.get(index).getX() && s.getX()==positions.get(index).getY()){
				 ranX= 0 + (int)(Math.random()*19); 
				 ranY= 0 + (int)(Math.random()*19); 
				 s=new snake(ranX,ranY);
				 index=0;
			 }
		 }
		 return s;
	 }
	 
	 /**
	  * moves the snake
	  * @param direction
	  * 1:right 
	  * 2: left
	  * 3: top
	  * 4: bottom
	  */
	 
	 private void moveInternal(int direction){
		 switch(direction){
		 case 1:
			 snakeHeadPosition.changeData(Math.abs(snakeHeadPosition.x+1)%20,snakeHeadPosition.y);
			 positions.add(new snake(snakeHeadPosition.x,snakeHeadPosition.y));
	 		 break;
		 case 2:
	 		 if(snakeHeadPosition.x-1<0){
	 			 snakeHeadPosition.changeData(19,snakeHeadPosition.y);
	 		 }
	 		 else{
	 			 snakeHeadPosition.changeData(Math.abs(snakeHeadPosition.x-1)%20,snakeHeadPosition.y);
	 		 } 
	 		positions.add(new snake(snakeHeadPosition.x,snakeHeadPosition.y));

	 		break;	
		 case 3:
		 		if(snakeHeadPosition.y-1<0){
		 			 snakeHeadPosition.changeData(snakeHeadPosition.x,19);
		 		 }
		 		else{
				 snakeHeadPosition.changeData(snakeHeadPosition.x,Math.abs(snakeHeadPosition.y-1)%20);
		 		}
				 positions.add(new snake(snakeHeadPosition.x,snakeHeadPosition.y));
		 		break;
		 	
		 case 4:
			 
				 snakeHeadPosition.changeData(snakeHeadPosition.x,(snakeHeadPosition.y+1)%20);
				 positions.add(new snake(snakeHeadPosition.x,snakeHeadPosition.y));
		 		break;		 	
		}
	 }
	 
	 //Refreshing the grid squares
	 private void moveExternal(){
		 for(snake p : positions){
			 int y = p.getX();
			 int x = p.getY();
			 squares.get(x).get(y).elementColor(0);
			 
		 }
	 }
	 /**
	  * Refreshing the tail of the snake
	  * removes the redundant data in the array list
	  */
	 private void shortenTail(){
		 int size = snakeSize;
		 for(int index = positions.size()-1;index>=0;index--){
			 if(size==0){
				 snake t = positions.get(index);
				 squares.get(t.y).get(t.x).elementColor(2);
			 }
			 else{
				size--;
			 }
		 }
		 size = snakeSize;
		 for(int index = positions.size()-1;index>=0;index--){
			 if(size==0){
				 positions.remove(index);
			 }
			 else{
				size--;
			 }
		 }
	 }
}
