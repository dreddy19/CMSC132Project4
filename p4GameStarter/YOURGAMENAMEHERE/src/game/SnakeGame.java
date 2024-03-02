package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class SnakeGame extends Game {
    private Snake snake;
    private Food food;
    private Wall wall;

  public SnakeGame() {
    super("Snake Game",500,500);
    snake = new Snake();
    food = new Food();
    wall = new Wall();
        KeyListener KeyboardEvent = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			keyPressed(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
		    int key = e.getKeyCode();
		    switch (key) {
		        case KeyEvent.VK_UP: snake.setDirection(3); break;
		        case KeyEvent.VK_DOWN: snake.setDirection(1); break;
		        case KeyEvent.VK_RIGHT: snake.setDirection(0); break;
		        case KeyEvent.VK_LEFT: snake.setDirection(2); break;
		        default: break;
		    }   
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			keyPressed(e);
		}
		
    	
    };
    
    this.addKeyListener(KeyboardEvent);
    this.setFocusable(true);
	this.requestFocus();
	//startGameLoop();
	
	final int[] sleepTime = {100}; // Start with 100ms sleep time
    final int speedIncrease = 2;
    
	new Thread(() -> {
        long lastTime = System.currentTimeMillis();
        while (true) {
            try {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - lastTime;
                
                if (elapsedTime >= 1000) { // Every second
                    sleepTime[0] = Math.max(10, sleepTime[0] - speedIncrease); // Decrease sleep time but don't go below 10ms
                    lastTime = currentTime; // Reset the last time
                }
                
                Thread.sleep(sleepTime[0]); // Control the speed of the snake based on the current sleep time
                snake.move(); // Move the snake in its current direction
                repaint(); // Repaint the game to reflect the updated state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
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
    	
    	brush.setColor(Color.white);
    	brush.drawString("Counter is " ,10,10);
    	wall.paint(brush);
  }
  
	public static void main (String[] args) {
   		SnakeGame a = new SnakeGame();
		a.repaint();
  }
}
