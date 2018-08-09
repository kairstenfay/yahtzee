import java.util.Map;

// Creates the "Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Sevens",
//   or "Eights" scoring categories depending on the given target die face.
//   With the score() method, returns the sum of the dice of only the given 
//   die face.
public class SumOfX extends Chance {
   
   private int targetDieFace; // the only die face that will count in the sum
   
   // Creates either the "Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", 
   //   "Sevens", or "Eights" scoring categories depending on the given target
   //   die face.  
   public SumOfX(int targetDieFace) { 
      this.targetDieFace = targetDieFace;
   } 
   
   // Returns the score of a given dice roll by calculating the sum of only the
   //   target die face.
   @Override
   public int score(int[] roll) {
      Map<Integer, Integer> diceCounter = makeDiceCounter(roll);
      return targetDieFace * diceCounter.get(targetDieFace);
   }
}