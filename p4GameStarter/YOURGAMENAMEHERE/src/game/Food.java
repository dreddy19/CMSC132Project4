package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

/**
 * CLASS: Food DESCRIPTION: Represents the food object in the game, extending
 * the Polygon class. Food is generated at random locations within the game
 * board for the snake to consume.
 */

public class Food extends Polygon {
	private static Random random = new Random();
	private static Point p1 = new Point(0, 0);
	private static Point p2 = new Point(10, 0);
	private static Point p3 = new Point(10, 10);
	private static Point p4 = new Point(0, 10);
	private static Point[] p = { p1, p2, p3, p4 };

	/**
	 * Constructs a Food object and places it at a random location on the game
	 * board.
	 */

	public Food() {
		super(p, new Point(0, 0), 0);
		generateFood();

	}

	/**
	 * Draws the food on the game board.
	 * 
	 * @param brush The Graphics object used for drawing.
	 */
	public void paint(Graphics brush) {
		brush.setColor(Color.red);
		brush.fillRect((int) position.getX(), (int) position.getY(), 20, 20);
	}

	/**
	 * Generates food at a new random location within the bounds of the game board.
	 */
	public void generateFood() {

		double x = 490 * random.nextDouble();
		double y = 490 * random.nextDouble();
		this.position.setX(x);
		this.position.setY(y);
	}

}



