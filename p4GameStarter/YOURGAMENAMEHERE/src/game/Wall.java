package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * CLASS: Wall DESCRIPTION: Represents the outer and inner walls of the game
 * area. The outer wall is drawn as a rectangle with a specified margin from the
 * frame edge, and the inner wall is drawn within the outer wall with a
 * consistent border width. Snake game will only be terminated when Snake comes
 * in contact with the outer wall(meant to represent the fact that you can ride
 * the wall in the game). The inner wall is what is displayed on screen.
 */

public class Wall extends Polygon {
	/**
	 * Constructs the outer wall with a fixed margin from the edge of a 600x600
	 * frame.
	 */
	public Wall() {

		super(new Point[] { new Point(10, 510), // Top-left
				new Point(510, 10), // Top-right
				new Point(510, 510), // Bottom-right
				new Point(10, 510) // Bottom-left
		}, new Point(0, 0), 0);
	}

	/**
	 * Checks if the snake has collided with the wall.
	 * 
	 * @param snake The snake to check for collisions.
	 * @return true if the snake has collided with the wall, false otherwise.
	 */
	public boolean check(Snake snake) {
		if (snake.position.getX() > 510 || snake.position.getX() < 10 || snake.position.getY() > 510
				|| snake.position.getY() < 10) {

			return true;

		}
		return false;
	}

	/**
	 * Draws the outer and inner walls on the game board.
	 * 
	 * @param brush The graphics object used for drawing.
	 */
	public void paint(Graphics brush) {
		// Drawing outer wall
		brush.setColor(Color.BLACK); // Set the color for the outer wall
		brush.drawRect(10, 10, 510, 510); // Draw the outer wall rectangle

		// Drawing inner wall by creating and painting an InnerWall instance
		InnerWall innerWall = new InnerWall();
		innerWall.paint(brush);
	}

	/**
	 * CLASS: InnerWall DESCRIPTION: Represents the inner walls of the game area.
	 * The inner wall is drawn within the outer wall with a consistent border width.
	 * The inner wall is what is displayed on screen.
	 */
	private class InnerWall extends Polygon {
		/**
		 * Constructs the inner wall centered within the outer wall, maintaining a
		 * consistent border width.
		 */
		private InnerWall() {

			super(new Point[] { new Point(11, 11), new Point(509, 11), new Point(509, 509),
					new Point(11, 509) },
					new Point(0, 0), 0);
		}

		/**
		 * Draws the inner wall on the game board.
		 * 
		 * @param brush The graphics object used for drawing.
		 */
		public void paint(Graphics brush) {
			brush.setColor(Color.WHITE); // Set the brush color to white for the inner wall
			brush.drawRect(15, 15, 505, 505); // Draw the inner wall rectangle
		}
	}
}
