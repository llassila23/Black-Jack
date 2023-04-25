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
    private int compHand; // int for value of computer hand
    private int playHand; // hand for player
    private final int numCards = 52;


    Scanner input = new Scanner(System.in);
    
    Random rand = new Random(); // starts new random number generator

    Card[] deck = new Card[52];

    Stack <Card> deckStack = new Stack<Card>(); //  create a stack for the shuffled deck
    // array list for the ** computer and the player
    ArrayList<Card> player = new ArrayList<Card>(); 
    ArrayList<Card> comp = new ArrayList<Card>(); 
    
    


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
    }// end try catch
  
}// end deck of cards method

/*public String printDeck(){
    String deckString = deck.toString();
    return deckString;
}*/

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
    
        while(cardCounter<= 26){ // shuffles two cards per loop 
            int randNum = rand.nextInt(52);
            int randNumTwo = rand.nextInt(52);
            Card temp = deck[randNumTwo]; // temporary value to be swapped
                deck[randNumTwo] = deck[randNum]; // swap the two random cards
                deck[randNum] = temp;
            cardCounter++; 
        }
    // put this shuffled array into a stack
        for(int i = 0; i<=51; i++){
            deckStack.add(deck[i]); // run a loop to add the cards from the shuffled deck array to the stack
        }
        // could probably delete deck[] here but am not sure how 
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
   public ArrayList<Card> deal(){
        while(cardCounter <= 1){ 
            player.add(deckStack.pop()); // take top card off. Give to player
            comp.add(deckStack.pop());
            cardCounter++; 
    }
    // only print the users array list
        return player;
   }

    
    // ** logic operation for computer
    public void compHandVal(){
    
        for( int j = 0; j<= comp.size(); j++){
            String cardFace = comp.remove(j) +"";
            
            switch(cardFace){
                case "King": 
                case  "Queen":
                case  "Jack":
                case  "Ten":
                    compHand += 10;
                    break;
                case "Deuce":
                    compHand += 2;
                    break;
                 case "Three":
                    compHand += 3;                  
                    break;
                case "Four":
                    compHand += 4;                   
                    break;
                case "Five":
                    compHand += 5;                  
                    break;
                case "Six":
                    compHand += 6;                  
                    break;
                case "Seven":
                    compHand += 7;                
                    break;
                case "Eight":
                    compHand += 8;                 
                    break;
                case "Nine":
                    compHand += 9;            
                    break;
            }// end switch case
        }// end for loop
    }// end method
// think there must be a way to do one case switch for both arrayLists and both hand totals but dont know how
    public void playHandVal(){
    
        for( int j = 0; j<= player.size(); j++){
            String cardFace = player.remove(j) +"";
            
            switch(cardFace){
                case "King": 
                case  "Queen":
                case  "Jack":
                case  "Ten":
                    playHand += 10;
                    break;
                case "Deuce":                  
                    playHand += 2;
                    break;
                 case "Three":                  
                    playHand += 3;
                    break;
                case "Four":                   
                    playHand += 4;
                    break;
                case "Five":                  
                    playHand += 5;
                    break;
                case "Six":                  
                    playHand += 6;
                    break;
                case "Seven":                  
                    playHand += 7;
                    break;
                case "Eight":                
                    playHand += 8;
                    break;
                case "Nine":              
                    playHand += 9;
                    break;
            }// end switch case
        }// end for loop

    }// end method

    public void ace(){
    for( int j = 0; j<= comp.size(); j++){
        String cardFace = comp.remove(j) +"" ;
        if(compHand<=5 && cardFace.contains("Ace")){
            compHand ++; // treat ace as a 1
            comp.add(deckStack.pop()); // take another card
            compHandVal(); // add value of that card to hand
        } else if(cardFace.contains("Ace")){
            compHand += 11; // treat ace as an 11
        } // end if else
    }// end for loop
    for( int i = 0; i<= player.size(); i++){
        String cardFace = player.remove(i) +"" ;
        if(cardFace.contains("Ace")){
            playHand += playerAce();

        }else{
            return;
        }// end if
    } // end for loop
} // end method ace

public int playerAce(){
        System.out.println("would you like to play your ace as a 1 or an 11?");
         int aceVal = input.nextInt();
         return aceVal;
}

    // offer a hit
    // show cards and sum them
    // ** assign points back
    // offer to play again
}