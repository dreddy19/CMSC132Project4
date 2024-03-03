package game;

/**
 * CLASS: SnakeGame
 * DESCRIPTION: The main class for the Snake game, handling game initialization,
 *  input, and main game loop. This class sets up the game window, initializes 
 *  game entities (snake, food, wall), and handles game logic including movement
 *   and collision detection. The game speeds up over time and ends when the snake 
 *   collides with a wall. It also includes a custom end game screen with a score display.
 */

import java.awt.*;
import java.awt.event.*;

class SnakeGame extends Game {
	private Snake snake;
	private Food food;
	private Wall wall;
	private EndFrame endFrame;
	private boolean end;
	private int count = 0;

	/**
	 * Constructs a new SnakeGame, setting up the game window, initializing game
	 * entities, and starting the game loop.
	 */

	public SnakeGame() {
		super("Snake Game", 600, 600);
		snake = new Snake();
		food = new Food();
		wall = new Wall();
		end = false;

		KeyListener KeyboardEvent = new KeyListener() {

			/**
			 * Initializes and sets up the key listener for snake direction control. It
			 * detects key presses and adjusts the snake's direction accordingly. Supported
			 * directions include up, down, left, and right.
			 * 
			 * @param KeyEvent object used to identify keys used
			 */

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				keyPressed(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_UP:
					snake.setDirection(3);
					break;
				case KeyEvent.VK_DOWN:
					snake.setDirection(1);
					break;
				case KeyEvent.VK_RIGHT:
					snake.setDirection(0);
					break;
				case KeyEvent.VK_LEFT:
					snake.setDirection(2);
					break;
				default:
					break;
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

		final int[] sleepTime = { 100 }; // Start with 100ms sleep time
		final int speedIncrease = 3;

		new Thread(() -> {

			long lastTime = System.currentTimeMillis();
			while (!end) {
				try {
					long currentTime = System.currentTimeMillis();
					long elapsedTime = currentTime - lastTime;

					if (elapsedTime >= 1000) { // Every second
						sleepTime[0] = Math.max(10, sleepTime[0] - speedIncrease); 
						// Decrease sleep time but don't go
						// below 10ms
						lastTime = currentTime; // Reset the last time
					}

					if (snake.collision(food)) {
						// Replace food with a new food object
						food = new Food();
						// Optionally increase score or snake size here
						count++;
					}

					if (wall.check(snake)) {

						end = true;
						break;

					}

					Thread.sleep(sleepTime[0]);  
					// Control the speed of the snake based on the current sleep time
					snake.move(); // Move the snake in its current direction
					repaint(); // Repaint the game to reflect the updated state
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void paint(Graphics brush) {
		if (!end) {
			brush.setColor(Color.black);
			brush.fillRect(0, 0, width, height);

			brush.setColor(Color.green);
			brush.fillRect((int) snake.position.getX(), (int) snake.position.getY(), 25, 25);

			brush.setColor(Color.red);
			brush.fillRect((int) food.position.getX(), (int) food.position.getY(), 20, 20);

			brush.setColor(Color.white);

			wall.paint(brush);
		} else {
			if (endFrame == null) {
				endFrame = new EndFrame();
			}
			endFrame.paint(brush);
		}

	}

	/**
	 * Inner class for displaying the end game screen and calculating the score.
	 */

	private class EndFrame {
		private String endText;

		/**
		 * Draws the end game screen, including a "GAME OVER" message and the final
		 * score.
		 * 
		 * @param brush Graphics object used for drawing.
		 */

		private void paint(Graphics brush) {
			brush.setColor(Color.black);
			brush.fillRect(0, 0, width, height);
			brush.setColor(Color.white);
			CalculateScore calculate = (score) -> score * 10;
			int points = calculate.calcScore(count);
			endText = "GAME OVER! Your Score was: " + points;
			brush.drawString(endText, 10, 10);
		}
	}

	/**
	 * Main method to start the Snake game.
	 * 
	 * @param args Command line arguments (not used).
	 */

	public static void main(String[] args) {
		SnakeGame a = new SnakeGame();
		a.repaint();
	}
}
