import java.util.Map;
import java.util.TreeMap;

// Creates the "Chance" scoring category. Returns the simple sum of a given 
//   dice roll using the score() method. Also provides methodology for 
//   counting the occurrence of each dice face (one through eight) in a given 
//   roll using makeDiceCounter(). This method is used as a helper alongside 
//   category scoring methods.
public class Chance implements Category { 
   
   // Returns the "Chance" score of a given dice roll (a simple sum). There is
   //   no alternate scoring condition for this category.
   @Override 
   public int score(int[] roll) { 
      Map<Integer, Integer> diceCounter = makeDiceCounter(roll);
      int sum = 0;
      for (int dieNumber : diceCounter.keySet()) { 
         sum += dieNumber * diceCounter.get(dieNumber);
      }
      return sum;
   }

   // Instantiates a dice tracker where all die faces (one through eight) are
   //   counted. This method is essential in calculating the score of a dice 
   //   roll.
   protected static Map<Integer, Integer> makeDiceCounter(int[] roll) { 
      Map<Integer, Integer> diceCounter = new TreeMap<Integer, Integer>();
      for (int i = 1; i < 9; i++) {  // eight-sided die
         diceCounter.put(i, 0);  // instantiate to all zeros initially
      }
      for (int i = 0; i < roll.length; i++) {  // count each die face
         diceCounter.put(roll[i], diceCounter.get(roll[i]) + 1);
      }
      return diceCounter;
   }
}
