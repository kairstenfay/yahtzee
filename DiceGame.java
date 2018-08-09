import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

// Allows the client to play a game with five 8-sided dice. Provides methods 
//   for:
//   - scoring a given dice roll using a given scoring category (score())
//   - suggesting scoring categories that provide the highest scores given a 
//     dice roll (suggestedCategories())
//
// Note that the indices of the static arrays are important because they are 
//   used in the construction of the scoring category objects. The categories 
//   stored in the arrays all have distinct patterns in their scoring logic. 
//   The major types of patterns are "SumOfX", "XOfAKind", and "Sraight".
// The other three categories are treated as special cases and are considered 
//   "miscellaneous".
public class DiceGame { 
	
   private static final String[] SUM_OF_X = new String[]{"Ones", "Twos", "Threes", "Fours", 
                                                        "Fives", "Sixes", "Sevens", "Eights"};
   private static final String[] X_OF_A_KIND = new String[]{"ThreeOfAKind", "FourOfAKind", 
                                                           "AllOfAKind"};
   private static final String[] STRAIGHT = new String[]{"SmallStraight", "LargeStraight"};
   private static final String CHANCE = "Chance";
   private static final String FULL_HOUSE = "FullHouse";
   private static final String NONE_OF_A_KIND = "NoneOfAKind";
   
   private Map<String, Category> categories;  // stores the category and its related object
  
   // Stores the names of the various scoring categories along with their
   //   object instantiations for future access. 
   public DiceGame() { 
      List<String> scoringCategories = new ArrayList<String>();
      scoringCategories.addAll(Arrays.asList(SUM_OF_X)); 
      scoringCategories.addAll(Arrays.asList(STRAIGHT));
      scoringCategories.addAll(Arrays.asList(X_OF_A_KIND));
      scoringCategories.add(CHANCE);
      scoringCategories.add(FULL_HOUSE);
      scoringCategories.add(NONE_OF_A_KIND); 
      
      categories = new HashMap<String, Category>();
     
      for (String category : scoringCategories) {
         categories.put(category, getCategory(category));
      }  
   }

   // With the given category, returns a new object of type Category that will
   //   be used for scoring a dice game. This method is index-aware for the 
   //   scoring patterns (other than the "miscellaneous" categories). 
   // If the given category does not match a category in the set of allowed
   //   categories, then the method defaults to "Chance".
   private Category getCategory(String category) {

      // The "SumOfX" scoring pattern takes an index in the constructor that
      //   converts to the die face important in calculating a score.
      for (int i = 0; i < SUM_OF_X.length; i++) { 
         if(SUM_OF_X[i].equals(category)) {
            return new SumOfX(i + 1);
         }
      }
      // The "XOfAKind" scoring pattern takes an index in the constructor that
      //   converts to the minimum frequency required of any one die face in
      //   calculating a score. 
      for (int i = 0; i < X_OF_A_KIND.length; i++) { 
         if(X_OF_A_KIND[i].equals(category)) {
            return new XOfAKind(i + 3);
         }
      } 
      // The "Straight" scoring pattern takes an index in the constructor that
      //   converts to the minimum number of sequential (consecutive) dice in
      //   calculating a score.
      for (int i = 0; i < STRAIGHT.length; i++) { 
         if (STRAIGHT[i].equals(category)) {
            return new Straight(i + 4);
         }
      }
      // The miscellaneous categories do not take parameters in their 
      //   constructor and have their own, deterministic scoring methods.
      if ("FullHouse".equals(category)) { 
         return new FullHouse();
      } else if ("NoneOfAKind".equals(category)) { 
         return new NoneOfAKind();
      } else { 
         return new Chance();
      }
   }
   
   // Returns the score of a given dice roll according to the scoring rules and 
   //   conditions relating to the given category.
   public int score(String category, int[] roll) { 
      return categories.get(category).score(roll);
   }
   
   // Returns an array of suggested scoring categories that would result in the
   //   highest score, given a dice roll. 
   public String[] suggestedCategories(int[] roll) {
      int maxScore = 0;
      List<String> suggestedCategories = new ArrayList<String>();
      
      for (String category : categories.keySet()) { 
         int score = categories.get(category).score(roll);
         if (score == maxScore) { 
            suggestedCategories.add(category);
         } else if (score > maxScore) {  // empty list and start fresh
            suggestedCategories.clear();
            maxScore = score;
            suggestedCategories.add(category);
         }
      }
      
      return suggestedCategories.toArray(new String[suggestedCategories.size()]);
   }
}