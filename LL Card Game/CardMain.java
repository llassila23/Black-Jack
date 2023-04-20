
// the Card Main class will execute the program by calling the methods defined in Card Method
import java.io.*;
import java.util.*;

public class CardMain{ 
    // execute my program
    public static void main(String[]args) 
        throws FileNotFoundException{

            CardMethod myGame = new CardMethod();
// begin calling methods to act on the card class
        Queue<String> q = CardMethod.instructions();
        while(!q.isEmpty()){
            System.out.println(q.remove());
            
        }
        // shuffle
        // deal (display to terminal)
        // ** if possible ** deal to computer too, play against computer
        // ** points system, could wager
        // logic operation
        // deal again or compare hands
        //** assign points to player
        // ask if want to play again
    }
}