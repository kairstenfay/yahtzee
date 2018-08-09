import java.util.Map;

// Creates the "ThreeOfAKind", "FourOfAKind", or "AllOfAKind" scoring 
//   categories depending on the given target die face frequency. With the 
//   score() method, returns the sum of the dice if the target frequency is 3
//   or 4 and is met. If the target frequency is 5 and is met, returns 50. 
//   Otherwise, returns 0.
public class XOfAKind extends Chance {
   
   public static final int ALL_OF_A_KIND_SCORE = 50;
   
   private int targetFrequency;  // a die face must occur this many times to score
   
   // Creates either the "ThreeOfAKind", "FourOfAKind", or "AllOfAKind" 
   //   scoring categories depending on the given target frequency.
   public XOfAKind(int targetFrequency) { 
      this.targetFrequency = targetFrequency;
   }
   
   // Returns the score of a given dice roll by calculating the sum of the dice
   //   if the target frequency is met and is 3 or 4. Returns 50 if the target
   //   frequency is met and is 5. Otherwise, returns 0.
   @Override
   public int score(int[] roll) {
      Map<Integer, Integer> diceCounter = makeDiceCounter(roll);
      
      boolean hitMinimum = false;
      for (int dieNumber : diceCounter.keySet()) { 
         if (diceCounter.get(dieNumber) >= targetFrequency) {
            hitMinimum = true;
         }
      }
      
      if (!hitMinimum) { 
         return 0;
      } else if (targetFrequency <= 4) {  // ThreeOfAKind and FourOfAKind
         return super.score(roll); 
      } else {  // AllOfAKind
         return ALL_OF_A_KIND_SCORE;
      } 
   }
}