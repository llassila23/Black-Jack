// the Card Method class will have the methods that will be called by Card Main and act on the Card Class
// object
// I will choose the game 21 (aka black jack) because I know it best. Being a simpler game I may 
// be able to add more funtionality to my program rather than working out the nuances of the game itself.

import java.io.*; // for reading instruction file
import java.util.*;// scanner, queue, random utility




public class CardMethod{
    
    private int pPoints = 10 ; // points int for player
    private int cPoints = 10 ; // points int for computer
    private int pot; // for the points bet on game
    private boolean gamble = true; // for making sure bet has been made. false once bets are made
    private int cardCounter; // keep track of cards moved
    private final int numCards = 52;

    Scanner input = new Scanner(System.in);
    
    Random rand = new Random(); // starts new random number generator
    Card[] deck = new Card[52];
    //ArrayList<Card> deck= new ArrayList<Card>(); 
    


 // constructor that makes the deck of cards
 public CardMethod(){ // same name as class to be created in Card Main
    String[]face = {"Ace ", "Deuce ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
        "Ten ", "Jack ", "Queen ", "King "};
    String[]suite = {"Hearts ", "Spades ","Clubs ","Diamonds "};
// two arrays, one for face one for suite

// use array to create a card by taking an element from suite and face arrays, put the cards into a new array
try {
    for(int count = 0; count <= 51; count++){
        deck[count] = new Card( face[count%13], suite[count/13]);
    }// end for loop

} catch (Exception ArrayIndexOutOfBounds) {

    
   
}
  
}// end deck of cards method

public String printDeck(){
    String deckString = deck.toString();
    return deckString;
}

    // file IO for instructions
    public static Queue<String> instructions() 
        throws FileNotFoundException{
        Scanner readLine = new Scanner(new File("instruction.txt")); // create scanner to read file
        Queue <String> q = new LinkedList<String>(); // create queue
        String line = null;
        
        while(readLine.hasNextLine()){
             line = readLine.nextLine();
            q.add(line);// fill queue with line
        }
        return q;
    }

    
    // shuffle them using the random number, array reversal ish but with rand num for index
   public void shuffle(){
        Stack <Card> deckStack = new Stack<Card>(); //  create a stack for the shuffled deck
    
        while(cardCounter<= 26){ // shuffles two cards per loop 
            int randNum = rand.nextInt(52);
            int randNumTwo = rand.nextInt(52);
                deck[randNumTwo] = deck[randNum]; // swap the two random cards
                deck[randNum] = deck[randNumTwo];
            cardCounter++; 
        }
    // put this shuffled array into a stack
        for(int i = 0; i<=51; i++){
            deckStack.add(deck[i]); // run a loop to add the cards from the shuffled deck array to the stack
        }
        // could probably delete deck[] here but am not sure how yet
        cardCounter = 0; // reset card counter to be used later.
   }
    
    // ** offer wagers
   public int bet(){
    System.out.println("You have " + pPoints + " points");
    System.out.println("What would you like to wager?");
        int bet = input.nextInt();
        while(gamble){
            if (bet<=pPoints && bet <= cPoints){
                pot += 2*bet;
                cPoints -= bet;
                pPoints -= bet;
                gamble = false;
            }else{
                System.out.println("Insufficent Funds, What would you like to wager?");
                gamble = true;
            }
        }
        return pot;
   }
    // array list for the ** computer and the player
    // deal the 2 cards per player
    // only print the users array list
    // ** logic operation for computer
    // offer a hit
    // show cards and sum them
    // ** assign points back
    // offer to play again
}