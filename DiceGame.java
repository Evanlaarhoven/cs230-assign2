/** 
 * Names: Silvie Coheleach and Emily Van Laarhoven
 * Assignment 2, Task 3
 * DiceGame.java
 * Due: 9/19/16 11:59pm
 * 
 * 
 * Simulates a Dice Poker game played between the computer and user. 
  * This class definition contains a main() method that assumes 
  * that the user enters a name and an integer in the command line, for example: 
  * java PlayDice Wendy 7
  * @author   Takis Metaxas 
  * @version     %I%, %G%
  */


public class DiceGame {
  
  /** Creates a game object that contains the variables associated with a game.
    */
  
  String name; // Dave is the default
  int numRounds; // 5 rounds by default
  int pwin; //round wins of the player
  int cwin; //round wins of the computer
  
  public DiceGame() {
    name = "Dave";
    numRounds = 5;
    pwin = 0;
    cwin = 0;    
  }
  
  
  /** Counts how many distinct values appear in the input array
    * and stores each count onto the diceResults array.
    * PRE-CONDITION: diceResults[] should have enough length 
    * to accomodate the values found in the input array.
    *
    * @param input   the input array
    * @param diceResults  holds the multiplicity of values found in input.
    *       Note that this is actually the output parameter
    */
  private void accumulateValues(int[] input, int[] diceResults) {
    /* this method iterates through the values on the dice (1-6) and in the nested for loop iterates
     * through the player's hand and totals the count of each value on a die, storing the count in diceResults.
     * For example, if a player's hand is 23232, the diceResults array is 0 3 2 0 0 0
     */
    for (int n = 1; n < 7; n++) {
      int counter = 0;
      for (int i = 0; i < input.length; i++) {
        if (input[i] == n){
          counter++;
        }
        diceResults[n - 1] = counter;                 
      }
    }
  }
  
  /** Given an input array storing five dice values, 
    * determines the rank of the set of values 
    * @param input  the array with the five dice values
    * @return    the rank: an integer between 0 and 6
    */
  private int getRank (int[] input) {
    /* Goes through the diceResults array, which is counts of each value 1-6 in the hand and 
     * returns the rank.  We organized the logic according to which cases are the most exclusive.
     */
    int[] results = new int[6];
    accumulateValues(input, results);
    
    for (int i = 0; i < results.length; i++){
      if (results[i] == 5){
        return 6;
      }
      if (results[i] == 4) {
        return 5;
      }
      if (results[i] == 3) {
        for (int j = 0; j < results.length; j++) {
             if (results[j] == 2) {
                return 4;
              }
            }
        return 3;
      }
      if (results[i] == 2) {
         for (int j = i+1; j < results.length; j++) {
           if (results[j] == 2) {
             return 2;
           }
         }
         return 1;
      }
  }
  return 0;
  }
  
  
  
  /** Plays one round of the game: First the computer's turn, 
    * then the player's turn
    * @param name the player's name
    * @return   0 if computer wins the round, 1 if player wins, 2 if a tie
    */
  private int playOneRound(String name) {
    DicePlayer computer = new DicePlayer("computer");
    computer.playNewHand();
    int computerRank = getRank(computer.getValues());
    String compRankStr = "";

    DicePlayer user = new DicePlayer(name);
    user.playNewHand();
    int userRank = getRank(user.getValues());
    String userRankStr = "";
    
    if (computerRank == 6) {
      compRankStr += " Five of a kind";
    }
    else if (computerRank == 5) {
      compRankStr += " Four of a kind";
    }
    else if (computerRank == 4) {
      compRankStr += " Full House";
    }
    else if (computerRank == 3) {
      compRankStr += " Three of a kind";
    }
    else if (computerRank == 2) {
      compRankStr += " Two Pairs";
    }
    else if (computerRank == 1) {
      compRankStr += " One Pair";
    }
    else {
      compRankStr += " Nothing";
    } 
    
    if (userRank == 6) {
      userRankStr += "Five of a kind";
    }
    else if (userRank == 5) {
      userRankStr += "Four of a kind";
    }
    else if (userRank == 4) {
      userRankStr += "Full House";
    }
    else if (userRank == 3) {
      userRankStr += "Three of a kind";
    }
    else if (userRank == 2) {
      userRankStr += "Two Pairs";
    }
    else if (userRank == 1) {
      userRankStr += "One Pair";
    }
    else {
      userRankStr += "Nothing";
    } 
    System.out.println(computer.toString() + compRankStr);
    System.out.println(user.toString() + userRankStr);
    if (userRank>computerRank){
      return 1;
    }
    if (computerRank==userRank) {
      return 2;
    }
    return 0;    
  }
  
  
  
  /**  Simulates the playing of numRounds of the Dice Poker game between 
    * HAL and player name, and prints the winner at the end
    * @param name   the player's name
    * @param numRounds  the number of rounds to play
    */
  public void playDiceGame (String name, int numRounds) {
    
    System.out.println("Good evening, " + name + ". Everything's running smoothly. And you?" + ".");
    System.out.println("I'm completely operational and all my circuits are functioning perfectly.");
    System.out.println("Would you like to play a game of Dice Poker? I play very well.");
    
    int counter = 1;
    while(counter<numRounds){
      System.out.println("***ROUND "+counter);
      int winner = playOneRound(name);
      
      if (winner==0) {
        cwin++;
      }
      if(winner==1){
        pwin++;
      }
        counter++;
    }
    
    
    // After all rounds played, determine the final winner of the game and print the results
    if (pwin>cwin) System.out.print("The game was won by "+ name + " with a score of " + pwin + " to " + cwin);
    else if (cwin>pwin) System.out.print("The game was won by the HAL with a score of " + cwin + " to " + pwin);
    else System.out.print("The game was tied with a score of " + cwin + " to " + pwin);
    
    System.out.println(" in " + numRounds + " rounds.");
    System.out.println("Thank you for a very enjoyable game!");
    
  }
  
  
  /** Start the homework by reading this method. 
    */
  public static void main (String args[]) {
    
    // Create an instance of a new game and play the rounds
    DiceGame game = new DiceGame();
    String name = (args.length >  0)? args[0] : "Dave";
    
    // 5 rounds by default
    int numRounds = (args.length >  1)? Integer.parseInt(args[1]) : 5; 
    game.playDiceGame(name, numRounds);
    
  }
  
  }
