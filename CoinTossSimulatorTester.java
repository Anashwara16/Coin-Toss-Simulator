

/** class CoinTossSimulatorTester.
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
* The test program is compiled and run as follows:
* javac CoinTossSimulator*.java
* java CoinTossSimulatorTester 
* 
* 
* CLASS DESCRIPTION:
* This class tests the CoinTossSimulator class.   
* It creates an instance of the CoinTossSimulator class and generates toss outcomes. It determines if the tosses added up correctly.  
* The reset method is called to reset all the values of the outcomes and restart the testing for the next set of trials. 
* A new instance of the CoinTossSimulator class is created again to test another set of trials. 
* All the methods of the CoinTossSimulator class are also tested. 
* The CoinTossSimulatorTester ensures thorough testing of the CoinTossSimulator class. 
*
*/
 
import java.util.*;

public class CoinTossSimulatorTester{
   	
   public static void main(String[] args){

      // Creates an instance of the CoinTossSimulator class. 
      CoinTossSimulator firstCoinToss = new CoinTossSimulator();
      
      System.out.println();
      System.out.println("After constructor:");
      System.out.println("Number of trials [exp:0]: " + firstCoinToss.getNumTrials());
      System.out.println("Two-head tosses: " + firstCoinToss.getTwoHeads());
      System.out.println("Two-tail tosses: " + firstCoinToss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + firstCoinToss.getHeadTails());

      int totalToss = (firstCoinToss.getTwoHeads() + firstCoinToss.getTwoTails() + firstCoinToss.getHeadTails());
      boolean tossAddUp = (firstCoinToss.getNumTrials() == totalToss) ? true : false;
      System.out.println("Tosses add up correctly? " + tossAddUp);
      System.out.println();

      // Creates another instance of the CoinTossSimulator class - for testing purposes. 
      CoinTossSimulator secondCoinToss = new CoinTossSimulator();

      // Test a set of trials.		
      int[] roundOneOfTrials = {1, 10, 100, 200, 300}; 
      int expectedTrials = 0;

      for(int i=0; i<roundOneOfTrials.length; i++){

         int trialRound = roundOneOfTrials[i];
         secondCoinToss.run(trialRound);
         expectedTrials += trialRound;

         System.out.println("After run(" + trialRound + ")");
         System.out.println("Number of trials [exp:"+ expectedTrials + "]: " + secondCoinToss.getNumTrials());
         System.out.println("Two-head tosses: " + secondCoinToss.getTwoHeads());
         System.out.println("Two-tail tosses: " + secondCoinToss.getTwoTails());
         System.out.println("One-head one-tail tosses: " + secondCoinToss.getHeadTails());

         totalToss = (secondCoinToss.getTwoHeads() + secondCoinToss.getTwoTails() + secondCoinToss.getHeadTails());
         tossAddUp = (secondCoinToss.getNumTrials() == totalToss) ? true : false;
         System.out.println("Tosses add up correctly? " + tossAddUp);
         System.out.println();

      }

      // Reset all the values.  
      secondCoinToss.reset();
      System.out.println("After reset:");
      System.out.println("Number of trials [exp:0]: " + secondCoinToss.getNumTrials());
      System.out.println("Two-head tosses: " + secondCoinToss.getTwoHeads());
      System.out.println("Two-tail tosses: " + secondCoinToss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + secondCoinToss.getHeadTails());

      totalToss = (secondCoinToss.getTwoHeads() + secondCoinToss.getTwoTails() + secondCoinToss.getHeadTails());
      tossAddUp = (secondCoinToss.getNumTrials() == totalToss) ? true : false;
      System.out.println("Tosses add up correctly? " + tossAddUp);
      System.out.println();


      // Test another set of trials.		
      int[] roundTwoOfTrials = {1000, 1100, 1200, 1300, 1400}; 
      expectedTrials = 0;

      // Creates another instance of the CoinTossSimulator class - for testing purposes. 
      CoinTossSimulator thirdCoinToss = new CoinTossSimulator();

      for(int i=0; i<roundTwoOfTrials.length; i++){

         int trialRound = roundTwoOfTrials[i];
         thirdCoinToss.run(trialRound);
         expectedTrials += trialRound;

         System.out.println("After run(" + trialRound + ")");
         System.out.println("Number of trials [exp:"+ expectedTrials + "]: " + thirdCoinToss.getNumTrials());
         System.out.println("Two-head tosses: " + thirdCoinToss.getTwoHeads());
         System.out.println("Two-tail tosses: " + thirdCoinToss.getTwoTails());
         System.out.println("One-head one-tail tosses: " + thirdCoinToss.getHeadTails());

         totalToss = (thirdCoinToss.getTwoHeads() + thirdCoinToss.getTwoTails() + thirdCoinToss.getHeadTails());
         tossAddUp = (thirdCoinToss.getNumTrials() == totalToss) ? true : false;
         System.out.println("Tosses add up correctly? " + tossAddUp);
         System.out.println();

      }

   }

}
