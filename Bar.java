// Name: Anashwara Rajinkumar Puthlat
// USC NetID: puthlat
// USC ID: 2138-2056-39
// Course: CSCI-455 
// Assignment: PA1
// Semester: Fall-2021

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
    
public class Bar {
   
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale).
  
      @param bottom  location of the bottom of the bar
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param applicationHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label under the bar
   */

   //Declare private instance variables for features of the bar
   private int bottom;
   private int left;
   private int width;
   private int applicationHeight;
   private double scale;
   private Color color;
   private String label;

   //Bar constructor initializes all the instance variables declared
   public Bar(int bottom, int left, int width, int applicationHeight, 
              double scale, Color color, String label) {
      this.bottom = bottom;
      this.left = left; 
      this.width = width;
      this.applicationHeight = applicationHeight;
      this.scale = scale;
      this.color = color;
      this.label = label;
   }
   
   /**
      Draw the labeled bar.
      @param g2  the graphics context
   */
   
   public void draw(Graphics2D g2) {

      int height = applicationHeight;

      // Declare and initialize the x and y coordinates for the top-left corner of the rectangle.
      int x = left;	//the x-coordinate.
      int y = (bottom - height);	//the y-coordinate.	
      
      // Construct a rectangle
      Rectangle rectangle = new Rectangle(x, y, width, height);
      g2.setColor(color);	// Sets this graphics context's color to the specified color.
      g2.fill(rectangle);	// Fills the interiors of the rectangle with graphics context's current color.

      Font font = g2.getFont(); //Get the default font for the graphics context

      FontRenderContext context = g2.getFontRenderContext();

      Rectangle2D labelBounds = font.getStringBounds(label, context); 	

      // Label specifications.
      int widthOfLabel = (int) labelBounds.getWidth();
      int heightOfLabel = (int) labelBounds.getHeight();

      g2.setColor(Color.black);
      int barLabelFont = (x + (width/2)) - (widthOfLabel/2);

      // Draw the string. 	
      g2.drawString(label, barLabelFont,(bottom+20));

   }
}
