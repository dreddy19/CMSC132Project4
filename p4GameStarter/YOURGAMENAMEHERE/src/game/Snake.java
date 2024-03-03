package game;

/**
 * CLASS: Snake DESCRIPTION: Represents the snake in the game, handling its
 * movement and direction. The snake moves within the game area, with its
 * movement controlled by setting its direction. The snake can move in four
 * directions: right, down, left, and up.
 */
class Snake extends Polygon {

	private int direction;
	private int speed;
	private static Point p1 = new Point(0, 0);
	private static Point p2 = new Point(25, 0);
	private static Point p3 = new Point(25, 25);
	private static Point p4 = new Point(0, 25);
	private static Point[] p = { p1, p2, p3, p4 };

	/**
	 * Constructs a new Snake instance at a default position with a specified size
	 * and initial direction facing right.
	 */
	public Snake() {
		super(p, new Point(240, 200), 0);
		this.direction = 0;
		this.speed = 10;
	}

	/**
	 * Sets the direction of the snake.
	 * 
	 * @param direction The new direction of the snake (0 - right, 1 - down, 2 -
	 *                  left, 3 - up).
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Moves the snake in the current direction. Adjusts the snake's position based
	 * on its speed and the current direction.
	 */
	public void move() {
		double x = this.position.getX();
		double y = this.position.getY();
		switch (direction) {
		case 0:
			this.position.setX(x + speed);
			this.rotate(270);
			break;
		case 1:
			this.position.setY(y - speed);
			break;
		case 2:
			this.position.setX(x - speed);
			this.rotate(90);
			break;
		case 3:
			this.position.setY(y + speed);
		}
	}
}
