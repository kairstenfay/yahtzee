import java.util.Map;

// Creates the "SmallStraight" or "LargeStraight" scoring categories depending
//   on the given target sequence. With the score() method, returns either 40 
//   or 50 if the given dice roll contains four or five sequential dice 
//   (consecutive integers), respectively. Otherwise, score() returns 0.
public class Straight extends Chance {
   
   private static final int SCORE_MULTIPLIER = 10;  // 4 in a row gets 40, etc.
   
   private int targetSequenceLength; // number of sequential dice needed to score
   
   // Creates either the "SmallStraight" or "LargeStraight" scoring category 
   //   with a given target sequence length of either 4 or 5, respectively.  
   public Straight(int targetSequenceLength){
      this.targetSequenceLength = targetSequenceLength;
   }
   
   // If the target sequence length is 4, then returns 40 if there are at least
   //   4 sequential die faces in a given roll (ie. 2, 3, 4, and 5). Otherwise
   //   returns 0.If the target sequence length is 5, then returns 50 if there 
   //   are at least 5 sequential die faces in a given roll (ie. 4, 5, 6, 7, 
   //   and 8). Otherwise returns 0.
   @Override
   public int score(int[] roll) {
      Map<Integer, Integer> diceCounter = makeDiceCounter(roll);
      
      int longestSequence = 0;
      int currentSequence = 0;
      
      for (int dieNumber : diceCounter.keySet()) { 
         if (diceCounter.get(dieNumber) > 0) { 
            currentSequence++;
         } else {  // reset the current sequence streak, maybe updating the max
            longestSequence = Math.max(longestSequence, currentSequence);
            currentSequence = 0;
         }
      }
      longestSequence = Math.max(longestSequence, currentSequence);
      
      if (longestSequence >= targetSequenceLength) { 
         return targetSequenceLength * SCORE_MULTIPLIER;
      } else { 
         return 0;
      }
   }
}