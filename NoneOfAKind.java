import java.util.Map;

// Creates the "NoneOfAKind" scoring category. With the score() method, 
//   returns 40 if the given dice roll contains only unique dice faces (each 
//   occuring at most 1 time). Otherwise, score() returns 0.
public class NoneOfAKind extends Chance {
   
   private static final int NONE_OF_A_KIND_SCORE = 40;
   private int maxFrequency;  // a die face can't occur more than this to score
   
   // Sets the maximum frequency for any die face equal to one in order to 
   //   fulfill the "NoneOfAKind" scoring condition.
   public NoneOfAKind() { 
      this.maxFrequency = 1;
   }
   
   // Returns 40 if only distinct die faces occur in a given dice roll. 
   //   Otherwise, returns 0.   
   @Override
   public int score(int[] roll) {
      Map<Integer, Integer> diceCounter = makeDiceCounter(roll);
      boolean noneOfAKind = true;
      for (int dieNumber : diceCounter.keySet()) { 
         if (diceCounter.get(dieNumber) > maxFrequency) {
            noneOfAKind = false;
         }
      }
      
      if (noneOfAKind) { 
         return NONE_OF_A_KIND_SCORE;
      } else {
         return 0;
      } 
   }
}