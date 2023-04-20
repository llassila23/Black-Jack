// the Card Method class will have the methods that will be called by Card Main and act on the Card Class
// object
// I will choose the game 21 (aka black jack) because I know it best. Being a simpler game I may 
// be able to add more funtionality to my program rather than working out the nuances of the game itself.

import java.io.*; // for reading instruction file
import java.util.*;// scanner, queue, random utility


public class CardMethod{
    
    private int pPoints = 10 ; // points int for player
    private int cPoints = 10 ; // points int for computer
    private int cardCounter; // keep track of cards moved
    private final int numCards = 52;
    
    Random rand = new Random(); // starts new random number generator


    // int randNum = rand.nextInt(53)

    // file IO for instructions
    public static Queue<String> instructions() 
        throws FileNotFoundException{
        Scanner readLine = new Scanner(new File("instruction.txt"));
        Queue <String> q = new LinkedList<String>();
        String line = null;
        
        while(readLine.hasNextLine()){
           
             line = readLine.nextLine();
            q.add(line);
        }
        return q;
    }
    // randomizer for the shuffle function
    // two arrays, one for face one for suite
    // use arrays to create a card by taking an element from suite and face arrays
    // put the cards into a new array
    // shuffle them using the random number, array reversal ish but with rand num for index
    // put this shuffled array into a stack
    // ** offer wagers
    // array list for the ** computer and the player
    // deal the 2 cards per player
    // only print the users array list
    // ** logic operation for computer
    // offer a hit
    // show cards and sum them
    // ** assign points back
    // offer to play again
}