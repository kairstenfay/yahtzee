import java.util.Map;

// Creates the "FullHouse" scoring category. With the score() method, returns 
//   25 if the given dice roll contains only two unique dice faces (thus 
//   occuring 2 and 3 times each). Otherwise, score() returns 0.
public class FullHouse extends Chance {
   
   private static final int FULL_HOUSE_SCORE = 25;
   
   private int bigFrequency;  // three of a kind, part 1 needed to score
   private int smallFrequency;  // two of a kind, part 2 needed to score
   
   // Sets the two minimum frequencies required in order to fulfill the 
   //   "FullHouse" scoring conditions.
   public FullHouse() { 
      this.bigFrequency = 3;
      this.smallFrequency = 2;
   }
   
   // Returns 25 if two distinct die faces occur two and three times each in a
   //   given dice roll. Otherwise, returns 0.
   @Override
   public int score(int[] roll) {
      Map<Integer, Integer> diceCounter = makeDiceCounter(roll);
      boolean hitBigFrequency = false;
      boolean hitSmallFrequency = false;
      
      for (int dieNumber : diceCounter.keySet()) { 
         if (diceCounter.get(dieNumber) >= bigFrequency) { 
            hitBigFrequency = true;
         } else if (diceCounter.get(dieNumber) >= smallFrequency) { 
            hitSmallFrequency = true;
         }
      }
      
      if (hitBigFrequency && hitSmallFrequency) { 
         return FULL_HOUSE_SCORE;
      } else {
         return 0;
      } 
   }
}