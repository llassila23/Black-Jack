//Lucas Lassila
// CS& 141
// Guessing Game Lab 4
// 2/9/2023
/* This program generates a random number and allows the user to guess the number until they are correct.
 * The program gives hints to the user and will display game stats once the number is found, the user can
 * play again or quit and see their game stats.
 * methods: instructions() line 58
 * playYN(input) line 67
 * playGame(input) line 100
 * results(score, gameCount, totalGuess, bestScore) line 130

 */

import java.util.Scanner;// scanner utility
import java.util.Random;// random number utility

public class LucasLassilaGuessingGame{
   public static void main(String[]args){
 // main method
   Scanner input = new Scanner(System.in);// create new scanner for user input
 // initialize game stat integers
   int bestScore = 0;// lowest guess win
   int gameCount = 0;// number of games played
   int totalGuess = 0;// total guesses ofver all games
   int score = 0;// guesser per game   
   int i = 0; // counter for best score while loop
   
   instructions();// method to print the game instructions
   
   int choice = playYN(input); // choice = return value from running playYN method  1 = yes. 0 = no, see line 67
      
   while (choice == 1){ // if choice = yes, playGame
         score = playGame(input); // score = return value from running game method, see line 100
         gameCount++; // game counter++
         totalGuess += score;// adds score to running tally totalGuess

        while(i < 1){// runs loop once to initilize best score value
         bestScore = score;// sets best score = to score
         i++;
         }  // end while
         if (score <= bestScore){ // if score is lower than current best score
           bestScore = score; // sets best score equal to new low score
         }else{
           bestScore = bestScore;// previous best score stands
         }// end if
            choice =  playYN(input); // runs choice method again to see if you want to keep playing, see line 67y
               
        
    }// end play loop
   
   System.out.println("Overall Results:");     
            
   results(score, gameCount,totalGuess, bestScore);// results method with game data
   
      
   }//end main method
   
private static void instructions(){
// print the game instructions
   System.out.println("Welcome to the Super Awesome Guessing Game 100!");
   System.out.println("I will pick a number between 1 and 100 and allow you to guess until you are correct.");
   System.out.println("For each try I will give you a hint if the number is higher or lower than your guess.");
   System.out.println("Good luck!");
}// end instructions method


private static int playYN(Scanner input){
 // user choice method, returns 1 or 0 (yes or no)
 int choice = 3; // faulty value to start loop

 do{   // does once
   System.out.println("Would you like to play? ");
   String choiceYN = input.next();// reads user input as string
    
   switch(choiceYN){// compare the string to some common forms of yes or no
      case"YES": // yes options
      case"yes":
      case"ya":
      case"yuh":
      case"y":
      choice = 1; // if yes return 1
   break;
      case "NO": // no options
      case "no":
      case "n":
      case "nah":
      choice = 0;// if no return 0
   break;
   default:// if neither yes or no
      System.out.println("Faulty Input: please try again");
   }//end switch case

   }while(choice !=1 && choice !=0);// try again if neither
      
   return choice;// returns choice value as a 1 or 0
}// end playYN method
   
   

private static int playGame(Scanner input) {
// main game method, compares user input to random number
   Random rand = new Random(); // starts new random number generator
   int randNum = rand.nextInt(100)+1;// starts at zero, counts 100 digits -> [1 to 100]
   int guess = 0;// guess counter
   int playerInput = 0;// player input integer
   System.out.println("The game has begun!");
   System.out.println();// spacer
  
   while(playerInput != randNum){ // will run until guess is correct
   
      System.out.println("What is your guess?: ");
         playerInput = input.nextInt();// sets user's input to playerInput

         if(playerInput > randNum){ // if guess higher than the random number
            System.out.println("Too High!");
            guess++;
         }else if (playerInput < randNum){// if guess is lower than the random number
             System.out.println("Too Low!");
             guess++;  
         }else{// guess is correct!!
             System.out.println("Congratuations!");             
             guess++;
         }// end if else
      }// end while loop
      System.out.printf("%s%d%s%n","You are correct in " , guess, " guesses!");// prints the stats of this round
      
      return guess;// returns the number of guesses
}// end playGame Method

private static void results(int score, double gameCount, double totalGuess, int bestScore){
// computes the average score, then it prints the game statistics once the player doesn't want to play anymore
   double avgScore = (totalGuess/gameCount);// computes average score
   // print ss
   System.out.printf("%s%d%n", "Last Game = ", score);
   System.out.printf("%s%.0f%n", "Total Guess = ", totalGuess);
   System.out.printf("%s%.0f%n", "Total Games = ", gameCount);
   System.out.printf("%s%.2f%n", "Average Score = ", avgScore);
   System.out.printf("%s%d%n", "High Score = ", bestScore);
   return;
  }// end reults method


   }// end class