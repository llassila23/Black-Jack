// Programmer Lucas Lassila
// 4/25/2023
// CS&142 
// Lab Four Card Game - Black Jack
// This is the Main method and controls the CardMethod.Java Manager class
// and the Card.java object class



// the Card Main class will execute the program by calling the methods defined in Card Method
import java.io.*;
import java.util.*;

public class CardMain{ 
    // execute my program
    public static void main(String[]args) {
// create an instance of the Card Method Class
            CardMethod myGame = new CardMethod(); // class, instance name, new instance of constructor method
            
// begin calling methods to act on the card class

// instructions, uses a queue created in card method transfer and print the instructions from instructions.txt file
   
    try { 
        Queue<String> q = CardMethod.instructions();
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    } catch (Exception FileNotFound) {

    } 
       
        int choice = 0; // int for play do while control, set by playYN();
    do{
     // create deck of cards
        myGame.shuffle();
        // ** points system, could wager
        System.out.println(myGame.bet() + " points are on the table");
        
        
        int cardChoice = 0; // int for controlling hit method
        // deal (display to terminal)

        System.out.println("Your Hand: " + myGame.deal(cardChoice));
        // show player hand, deal another card if needed.
        do{
             cardChoice = myGame.hit();
            if(cardChoice == 1){
                System.out.println(myGame.deal(cardChoice));
            }else{
                System.out.println(myGame.deal(cardChoice));
                break;
            }// end if else
        }while(cardChoice == 1);
 // logic operation
        myGame.compHandVal();
        myGame.playHandVal();
        myGame.ace(); // also runs compHandVal

        // ** if possible ** deal to computer too, play against computer
      
       // determine who wins and assign points back
        System.out.println(myGame.compare());
        System.out.println("Opponent Hand " + myGame.comp); // show opponent hand
        
        choice = myGame.playYN(); // see if player wants to play agian, returns 1 if yes
    }while(choice == 1); // end of master play loop
    
    myGame.end(); // end method. displays stats
       
    }
}