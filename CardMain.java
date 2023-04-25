
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
        // create deck of cards
        //System.out.println(myGame.printDeck());
        //CardMethod.deckOfCards();
        myGame.shuffle();

        System.out.println(myGame.bet() + " points are on the table");
        // deal (display to terminal)
        System.out.println("Your Hand: " + myGame.deal());
        myGame.compHandVal();
        myGame.playHandVal();
        myGame.ace();
        // ** if possible ** deal to computer too, play against computer
        // ** points system, could wager
        // logic operation
        // deal again or compare hands
        //** assign points to player
        // ask if want to play again
    }
}