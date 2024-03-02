package game;

import java.util.*;

public class Food extends Polygon{
    private static Random random = new Random();
	private static Point p1 = new Point(0, 0);
	private static Point p2 = new Point(10, 0);
	private static Point p3 = new Point(10, 10);
	private static Point p4 = new Point(0, 10);
    private static Point[] p = {p1, p2, p3, p4};
    
    public Food() {
        super(p, new Point(0, 0), 0);
        generateFood();

    }
    
    public void generateFood() {
        // Generate food at a random location within the game board
    	double x = 490 * random.nextDouble();
    	double y = 490 * random.nextDouble();
        this.position.setX(x);
        this.position.setY(y);
    }
	
}



