// Name: Anashwara Rajinkumar Puthlat
// USC NetID: puthlat
// USC ID: 2138-2056-39
// Course: CSCI-455 
// Assignment: PA1
// Semester: Fall-2021

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;

public class CoinTossSimulator {

   private int numberOfTwoHeads; // Total amount of trials resulting in two consecutive heads. 
   private int numberOfTwoTails; // Total amount of trials resulting in two consecutive tails. 
   private int numberOfAHeadAndATail; // Total amount of trials resulting in one head and one tail.  
   int numTrials; // Total number of trials. 

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      numTrials = 0;
      numberOfTwoHeads = 0;
      numberOfTwoTails = 0;
      numberOfAHeadAndATail = 0; 
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
	
      this.numTrials += numTrials;

      Random rand =  new Random();

      int toss1;
      int toss2;
      int tossResult = 0;

      for(int i=1; i<=numTrials; i++){

         /** Generate two random numbers: either 0 (tail) or 1 (head); and add them. 
         */
         toss1 = rand.nextInt(2); // First coin toss.
         toss2 = rand.nextInt(2); // Second coin toss.
         tossResult = toss1 + toss2; 

         /** Increment variables according to tossResult.
         */

         if(tossResult == 0){
            numberOfTwoTails++;
         }

         else if(tossResult == 1){
            numberOfAHeadAndATail++; 
         }

         else{
            numberOfTwoHeads++;
         }
      }
}


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
      return numTrials;
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
      return numberOfTwoHeads;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
      return numberOfTwoTails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
      return numberOfAHeadAndATail; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      numberOfTwoHeads = 0;
      numberOfAHeadAndATail = 0; 
      numberOfTwoTails = 0;
      numTrials = 0;
   }

}
