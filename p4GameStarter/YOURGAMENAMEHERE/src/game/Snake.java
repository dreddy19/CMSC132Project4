package game;

class Snake extends Polygon {
  // Current direction of the snake (0 - right, 1 - down, 2 - left, 3 - up)
	private int direction;
	private int speed;
	private static Point p1 = new Point(0, 0);
	private static Point p2 = new Point(25, 0);
	private static Point p3 = new Point(25, 25);
	private static Point p4 = new Point(0, 25);
	private static Point[] p = {p1, p2, p3, p4};
	
	public Snake() {
		super(p, new Point(240, 200), 0);
        this.direction = 0; 
        this.speed = 10;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void move() {
		double x = this.position.getX();
		double y = this.position.getY();
		switch (direction) {
			case 0: this.position.setX(x + speed);
					this.rotate(270);
					break;
			case 1: this.position.setY(y - speed);
					break;
			case 2: this.position.setX(x - speed);
					this.rotate(90);
					break;
			case 3: this.position.setY(y + speed);
		}
}
