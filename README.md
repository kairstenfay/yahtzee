# Yahtzee Dice Game  
## Written by Kairsten Fay (@kairstenfay)  

This program allows a user to play a game with five 8-sided dice. The categories for scoring are specified as follows:
> Ones – scores the sum of all the ones  
> Twos – scores the sum of all the twos  
> Threes – scores the sum of all the threes  
> Fours – scores the sum of all the fours  
> Fives – scores the sum of all the fives  
> Sixes – scores the sum of all the sixes  
> Sevens – scores the sum of all the sevens  
> Eights – scores the sum of all the eights  
> ThreeOfAKind – scores the sum of all dice if there are 3 or more of the same die, otherwise scores 0  
> FourOfAKind – scores the sum of all dice if there are 4 or more of the same die, otherwise scores 0  
> AllOfAKind – Scores 50 if all of the dice are the same, otherwise scores 0  
> NoneOfAKind – Scores 40 if there are no duplicate dice, otherwise scores 0  
> FullHouse – Scores 25 if there are two duplicate dice of one value and three duplicate dice of a different value, otherwise scores 0  
> SmallStraight – Scores 30 if there are 4 or more dice in a sequence, otherwise scores 0  
> LargeStraight – Scores 40 if all 5 dice are in a sequence, otherwise scores 0  
> Chance – scores the sum of all dice

The public-facing API is contained in the file `DiceGame.java`. There are two public methods there, `score()` and `suggestedCategories()`.  

The first method takes a given category and a given dice roll and returns the score. 
`public int score(String category, int[] roll) {…}`

The second method returns a list of categories that score the highest given a roll. 
`public String[] suggestedCategories(int[] roll) {…}`

The classes other than `DiceGame` are implementation details. Please see the file `codeOverview.html` for more information on the program's structure.    

Example calls of how to run the Dice Game follow.  
```
DiceGame scorer = new DiceGame();
scorer.score("Ones", new int[]{1, 2, 3, 4, 5}); 
scorer.suggestedCategories(new int[]{3, 3, 8, 8, 8});
```  

To print the above input, run:  
```
System.out.println(scorer.score("Ones", new int[]{1, 2, 3, 4, 5}));
System.out.println(Arrays.toString(scorer.suggestedCategories(new int[]{3, 3, 8, 8, 8}))); 
``` 

