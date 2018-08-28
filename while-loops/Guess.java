// Colby Gilbert
// 10/27/2014
// TA: Michelle Cho
// CSE 142: Assignment 5
//
// This program play a guessing game with the user, and will tell the user if
// they guesed corretly the game is over when the user guesses correctly, the 
// user may play as many time as desired, and the program with give data about
// games played. the user can set the range of which they will guess numbers

import java.util.*;

public class Guess {
   public static final int MAXNUM = 100;
   
   // this method exacutes the main parts of the game and allows for multiple 
   // games, variable cont = is the users answer if they want too (cont)inue 
   // or not
   public static void main (String[] args) {
      Random rand = new Random();
      Scanner console = new Scanner(System.in);
      int totalGuesses = 0;
      int gamesPlayed = 0;
      int bestGame = 9999;
      String test = "y";
       
      giveIntro();
      while(test != "n") {
         int guesses = playGame(rand, console);
         totalGuesses += guesses;
         if (guesses < bestGame) {
            bestGame = guesses;
         }
         gamesPlayed++;
         String cont = console.next();
         if(cont.substring(0,1).equalsIgnoreCase("Y")) {
            test = "y";
         } else {
            test = "n";
         }
         System.out.println();   
      }
      reportResults(totalGuesses, gamesPlayed, bestGame);
   }
   
   // this method reaads out the intructions of the game to the user
   public static void giveIntro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and"); 
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   // this method asks the user for thier guess and compares them to the answer
   // while counting how many guesses are being made
   public static int playGame(Random rand, Scanner console) {
      int numGuesses = 0;
      int guess = -1;
      int answer = rand.nextInt(MAXNUM) + 1;
      System.out.println("I'm thinking of a number between 1 and " + MAXNUM + "...");
      while (guess != answer) {
         System.out.print("Your guess? ");
         guess = console.nextInt();
         if(guess > answer){
            System.out.println("It's lower.");
         } else if (guess < answer) {
            System.out.println("It's higher.");
         }   
         numGuesses++;
      }
      if(numGuesses == 1) {
         System.out.println("You got it right in 1 guess");
      } else {   
         System.out.println("You got it right in " + numGuesses + " guesses");
      }   
      System.out.print("Do you want to play again? ");
      return numGuesses;
   }
   
   // this method does the calculations/ reads out the results of the games played.
   // they are total games,total guesses, avergae #of guesses per game, and best 
   // game (least amout of guesses in one game.)
   public static void reportResults(int totalGuesses, int gamesPlayed, int bestGame) {
      System.out.println("Overall results:");
      System.out.println("    total games   = " + gamesPlayed);
      System.out.println("    total guesses = " + totalGuesses);
      double ratio = (double)totalGuesses/gamesPlayed;
      System.out.printf("    guesses/game  = %.1f\n", ratio);
      System.out.println("    best game     = " + bestGame);
   }  
}