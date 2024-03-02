package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class YourGameName extends Game {
    private Snake snake;
    private Food food;

  public SnakeGame() {
    super("Snake Game",500,500);
    snake = new Snake();
    food = new Food();
    this.setFocusable(true);
	this.requestFocus();
	//startGameLoop();
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
   
    	brush.setColor(Color.green);
    	brush.fillRect((int)snake.position.getX(), (int)snake.position.getY(), 25, 25);
    	
    	brush.setColor(Color.red);
    	brush.fillRect((int)food.position.getX(), (int)food.position.getY(), 20, 20);
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	brush.setColor(Color.white);
    	brush.drawString("Counter is " + counter,10,10);
  }
  
	public static void main (String[] args) {
   		SnakeGame a = new SnakeGame();
		a.repaint();
  }
}
