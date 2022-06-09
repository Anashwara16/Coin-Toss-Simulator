// Name: Anashwara Rajinkumar Puthlat
// USC NetID: puthlat
// USC ID: 2138-2056-39
// Course: CSCI-455 
// Assignment: PA1
// Semester: Fall-2021


/** 
* class CoinSimComponent
*
* CoinSimComponent extends JComponent. Constructor initializes all the necessary data and runs the simulation. 
* It overrides the paintComponent to draw the bar graph, using Bar objects for each bar in the graph. 
* This class uses CoinTossSimulator and Bar class. 
*
*/


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.Rectangle;
import java.math.*;
import java.util.Scanner; 

public class CoinSimComponent extends JComponent{
      
   // Declare variables for each outcome of coin toss and their percentages.
   // Declare constants for bar width and vertical buffer. 
   private int numberOfTwoHeads;
   private int numberOfTwoTails;
   private int numberOfAHeadAndATail;
   private int numTrials;
   private int numberOfTrials;	
   private int percentageOfTwoHeads;
   private int percentageOfAHeadAndATail;
   private int percentageOfTwoTails;
   private static final int BAR_WIDTH = 60;
   private static final int VERTICAL_BUFFER = 50;
   CoinTossSimulator coinToss;

   /**  CoinSimComponent constructor.
	    @param numberOfTwoHeads is the total number of coin toss outcomes resulting in two heads.  
	    @param numberOfAHeadAndATail is the total number of coin toss outcomes resulting in a head and a tail.  
	    @param numberOfTwoTails is the total number of coin toss outcomes resulting in two tails.  
	    @param numTrials is the total number of trials.  
   */
   public CoinSimComponent(int numberOfTrials){

      this.numberOfTrials = numberOfTrials;

      coinToss = new CoinTossSimulator();
      coinToss.run(numberOfTrials);

      numberOfTwoHeads = coinToss.getTwoHeads();
      numberOfAHeadAndATail = coinToss.getHeadTails();
      numberOfTwoTails = coinToss.getTwoTails();
      numTrials = coinToss.getNumTrials();
   }

/*
* paintComponent method:  
*
* This method calculates the scale, bottom, and left and height values for all the bars.  
* It create labels for each bar of the bar graph and create instances of the Bar class for each of them.  
* The bars are then drawn using the draw method. 
*
*/

   public void paintComponent(Graphics g){
		
      int portion = (getWidth()/4); // Divides the width into 4 equal parts.

      // Remove half of the bar width from the first portion of split (width divided into 4 equal parts).
      int leftBar1 = (int) (portion-(BAR_WIDTH/2)); 

      // Remove half of the bar width from the second portion of the split (width divided into 2 equal parts). 
      int leftBar2 = (int) ((portion*2)-(BAR_WIDTH/2));

      // Remove half of the bar width from the third portion of split (width divided into 3/4 equal parts). 
      int leftBar3 = (int) ((portion*3)-(BAR_WIDTH/2));

      // The scale depends on window size - height minus the 2 vertical buffers.  
      double scale = ((getHeight()-(2*VERTICAL_BUFFER))/(double)numTrials);

      // Calculate the heights of bars relative to its scale (application unit in pixels). 
      int heightOfBar1 = (int) (numberOfTwoHeads * scale);
      int heightOfBar2 = (int) (numberOfAHeadAndATail * scale);
      int heightOfBar3 = (int) (numberOfTwoTails * scale);

      // The height of the frame minus the vertical buffer gives us the bottom distance. 
      int bottom = (getHeight()-VERTICAL_BUFFER);

      // Each outcome in percentage.
      percentageOfTwoHeads = (int) Math.round((numberOfTwoHeads * 1.0 / numTrials) * 100);
      percentageOfAHeadAndATail = (int) Math.round((numberOfAHeadAndATail * 1.0 / numTrials) * 100);
      percentageOfTwoTails = (int) Math.round((numberOfTwoTails * 1.0/ numTrials) * 100);

      // Labels for all the bars in the bar graph.
      String label1 = "Two Heads: " + numberOfTwoHeads + " (" + percentageOfTwoHeads + "%)" ;
      String label2 = "A Head and a Tail: " + numberOfAHeadAndATail + " (" + percentageOfAHeadAndATail + "%)" ;
      String label3 = "Two Tails: " + numberOfTwoTails + " (" + percentageOfTwoTails + "%)" ;

      // Bar colors 
      Color HEAD_COLOR = Color.red;
      Color HEAD_TAIL_COLOR = Color.green;
      Color TAIL_COLOR = Color.blue;

      // Create bars for each outcome. 
      Bar barForTwoHeads = new Bar(bottom, leftBar1, BAR_WIDTH, heightOfBar1, scale, HEAD_COLOR, label1);	
      Bar barForHeadTail = new Bar(bottom, leftBar2, BAR_WIDTH, heightOfBar2, scale, HEAD_TAIL_COLOR, label2);	
      Bar barForTwoTails = new Bar(bottom, leftBar3, BAR_WIDTH, heightOfBar3, scale, TAIL_COLOR, label3);	

      Graphics2D g2 = (Graphics2D) g;

      // Draw the bars.
      barForTwoHeads.draw(g2);
      barForHeadTail.draw(g2);
      barForTwoTails.draw(g2);

   }
}
