import java.util.Map;

// The Category interface specifies a scoring method for the various categories 
//   of scoring a dice roll within the game itself. It does not represent the 
//   public facing API. The score() method calculates the score of a given dice 
//   roll using a scoring method tied to a specific instance of the Category 
//   object.
public interface Category { 
   int score(int[] roll);
} 