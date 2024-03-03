package game;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Polygon {
    // Outer wall constructor
    public Wall() {
        // Adjusted to be 10 pixels from the edge of a 600x600 frame
        super(new Point[]{
                new Point(10, 510), // Top-left
                new Point(510, 10), // Top-right
                new Point(510, 510), // Bottom-right
                new Point(10, 510) // Bottom-left
            },
            new Point(0, 0), 
            0 
        );
    }

    // Method to draw inner wall
    public void paint(Graphics brush) {
        // Drawing outer wall
        brush.setColor(Color.BLACK); // Set the color for the outer wall
        brush.drawRect(10, 10, 510, 510); // Draw the outer wall rectangle
        
        // Drawing inner wall by creating and painting an InnerWall instance
        InnerWall innerWall = new InnerWall();
        innerWall.paint(brush);
    }

  

    // Inner class for the inner wall
    public class InnerWall extends Polygon {
        public InnerWall() {
            // Centered within the outer wall, assuming a consistent border width
            super(new Point[]{
                    new Point(15, 15), // Adjusted for inner wall to be centered
                    new Point(505, 15), // and to maintain a consistent border width
                    new Point(505, 505),
                    new Point(15, 505)
                },
                new Point(0, 0), // Position (offset) - not really needed
                0 // Rotation - not needed for a border
            );
        }

        // Method to draw the inner wall
        public void paint(Graphics brush) {
            brush.setColor(Color.WHITE); // Set the brush color to white for the inner wall
            brush.drawRect(15, 15, 505, 505); // Draw the inner wall rectangle
        }
    }
}
