

/*	
* class CoinSimViewer
*
* PROGRAM DESCRIPTION:
* This a coin toss simulator program that simulates tossing a pair of coins some number of times. This graphics-based program runs the simulation and outputs the statistics for all the outcomes in the form of a bar graph. 
*
* The program consists of the following:
*
* 1) CoinSimViewer:
*    Prompts user for number of trials and creates a JFrame containing the CoinSimComponent. 
* 
* 2) CoinSimComponent:
*    Extends JComponent and uses CoinTossSimulator and Bar class. It initializes data and overrides paintComponent to draw the bar graph. 
*
* 3) CoinTossSimulator:
*    This class performs the simulation and runs simulation of tossing a pair of coins for some number of trials. 
*
* 4) Bar:
*    Draws all the bars in the bar graph.
*
* 5) CoinTossSimulatorTester:
*    Tests the CoinTossSimulator class. 
*
*
* SUMMARY:
* The CoinSimViewer takes user input and creates a frame. The CoinSimComponent runs the simulation by calling CoinTossSimulator and draws the graph using Bar. The CoinTossSimulator tests the CoinTossSimulator class and provides the output of the outcomes. 
*
* 
* RUNNING THE PROGRAM:
* To view the graphical implementation of the outcomes, compile and run as follows: 
* javac @CoinSimViewer.list
* java CoinSimViewer
*
*
* CLASS DESCRIPTION: 
* The program prompts the user to input the number of trials they need to simulate. Error checking is performed to check whether a positive value is entered or not. User input is requested until the user enters a valid value. 
* A Jframe object is created to make a frame and configured as per specifications. The CoinSimComponent object is added to this frame and made visible. 
*	
*/


import java.util.Scanner; 
import javax.swing.JFrame;


public class CoinSimViewer{

   public static void main(String[] args){

      Scanner scanObj = new Scanner(System.in);
      int numberOfTrials = 0;

      // The following while loop takes user input and checks whether the user inputs a positive number or not.
      // If the user enters a negative number, then it will prompt the user to provide an input again.
      // The loop terminates once the user inputs a positive number.

      while(numberOfTrials <= 0){
         
         System.out.print("Enter number of trials: ");
         numberOfTrials = scanObj.nextInt();

         if(numberOfTrials <= 0){
            System.out.println("ERROR: Number entered must be greater than 0.");
         }
      } 

      // Construct a JFrame object to create a frame and configure it.
      JFrame frame = new JFrame();
      frame.setSize(800, 500);  
      frame.setTitle("CoinSim");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Construct an object of the CoinSimComponent class.
      CoinSimComponent component = new CoinSimComponent(numberOfTrials); 

      // Add component to the frame and make the frame visible. 
      frame.add(component);	
      frame.setVisible(true);

   }
}
