package game;

import java.awt.Color;
import java.awt.Graphics;

import game.Wall.InnerWall;

public class Wall extends Polygon {
    // Outer wall constructor
    public Wall() {
        super(new Point[]{
                new Point(0, 0), // Top-left
                new Point(500, 0), // Top-right
                new Point(500, 500), // Bottom-right
                new Point(0, 500) // Bottom-left
            },
            new Point(0, 0), // Position (offset) - not really needed but required by constructor
            0 // Rotation - not needed for a border
        );
    }

    // Method to draw the outer wall
    public void paint(Graphics brush) {
        brush.setColor(Color.WHITE); // Set the brush color to white for the outer wall
        drawPolygon(brush);
        InnerWall innerWall = new InnerWall();
		innerWall.paint(brush);
    }
    
    // Helper method to draw the polygon based on its points
    private void drawPolygon(Graphics brush) {
        Point[] points = this.getPoints(); // Get the transformed points

        int[] xPoints = new int[points.length];
        int[] yPoints = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xPoints[i] = (int) points[i].x;
            yPoints[i] = (int) points[i].y;
        }

        brush.drawPolygon(xPoints, yPoints, points.length); // Draw (not fill) the polygon with the brush
    }

    // Inner class for the inner wall
    public class InnerWall extends Polygon {
        public InnerWall() {
            super(new Point[]{
                    new Point(1, 1), // Top-left, 1 pixel inside
                    new Point(499, 1), // Top-right, 1 pixel inside
                    new Point(499, 499), // Bottom-right, 1 pixel inside
                    new Point(1, 499) // Bottom-left, 1 pixel inside
                },
                new Point(0, 0), // Position (offset) - not really needed
                0 // Rotation - not needed for a border
            );
        }

        // Method to draw the inner wall
        
        public void paint(Graphics brush) {
            brush.setColor(Color.WHITE); // Set the brush color to white for the inner wall
            drawPolygon(brush); // Use the outer class's method to draw the inner wall
        }
    }
}
