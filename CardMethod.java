// Lucas Lassila
// This is the Manager class for The Black Jack Card Game

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
    private boolean gamble; // for making sure bet has been made. false once bets are made
    private int cardCounter; // keep track of cards moved
    private int compHand; // int for value of computer hand
    private int playHand; // hand for player
    private int compHandCount = 0;// counter for comp hand valueation
    private final int numCards = 52;

    String winString = null; // string for win statement

    Scanner input = new Scanner(System.in);
    
    Random rand = new Random(); // starts new random number generator

    Card[] deck = new Card[numCards];

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



    // file IO for instructions
    public static Queue<String> instructions() {
        Queue <String> q = new LinkedList<String>(); // create queue
        try {
            
        Scanner readLine = new Scanner(new File("Welcome.txt")); // create scanner to read file
        String line = null;
        while(readLine.hasNextLine()){
             line = readLine.nextLine();
            q.add(line);// fill queue with line
        }
        
    } catch (Exception fileNotFoundException) {
    }// end try catch
        return q;
    }

    
    // shuffle them using the random number, array reversal ish but with rand num for index
   public void shuffle(){ 
    for(int i = 0; i<=10; i++){ // shuffle 10 times
        while(cardCounter<= 26){ // shuffles two cards per loop 
            int randNum = rand.nextInt(52);
            int randNumTwo = rand.nextInt(52);
            Card temp = deck[randNumTwo]; // temporary value to be swapped
                deck[randNumTwo] = deck[randNum]; // swap the two random cards
                deck[randNum] = temp;
            cardCounter++; 
        }
    }// end for loop
    // put this shuffled array into a stack
        for(int i = 0; i<=51; i++){
            deckStack.add(deck[i]); // run a loop to add the cards from the shuffled deck array to the stack
        }
        // could probably delete deck[] here but am not sure how 
        cardCounter = 0; // reset card counter to be used later.
   }
    
    // ** offer wagers
   public int bet(){
    gamble = true;// set gamble to true
    System.out.println("You have " + pPoints + " points");
    System.out.println("What would you like to wager?");
        int bet = input.nextInt();
        while(gamble){
            if (bet<=pPoints ){
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
   public ArrayList<Card> deal(int cardChoice){
        while(cardCounter <=1 && !deckStack.isEmpty()){ 
                player.add(deckStack.pop()); // take top card off. Give to player
                comp.add(deckStack.pop());
                cardCounter++;   
    }// end while
    // offer a hit
        if(cardCounter >= 1 && cardChoice == 1 ){ // if player wants additional card
            player.add(deckStack.pop()); // take top card off. Give to player
        }
    // only print the users array list
        return player;
   }

   public int hit(){
        System.out.println("Do you want a hit? press 1 for yes, 2 for no.");
        int cardChoice = input.nextInt();
        return cardChoice;
   }
    
    // ** logic operation for computer
    public void compHandVal() throws IndexOutOfBoundsException{
        
        while(compHandCount<comp.size()){
            
            String cardFace = comp.get(compHandCount) +"";
            // get value of card
            // add value of card to sum of computer hand
            if(cardFace.contains("King") || cardFace.contains("Queen")
                || cardFace.contains("Jack") || cardFace.contains("Ten")){
                compHand += 10;
            }else if(cardFace.contains("Deuce")){
                compHand += 2;
            }else if(cardFace.contains("Three")){
                compHand += 3;
            }else if(cardFace.contains("Four")){
                compHand += 4;
            }else if(cardFace.contains("Five")){
                compHand += 5;
            }else if(cardFace.contains("Six")){
                compHand += 6;
            }else if(cardFace.contains("Seven")){
                compHand += 7;
            }else if(cardFace.contains("Eight")){
                compHand += 8;
            }else if(cardFace.contains("Nine")){
                compHand += 9;
            }else{
                return;
            }// end if else
            compHandCount++; //counter
        }// end while
    }// end method

// think there must be a way to do one case switch for both arrayLists and both hand totals but dont know how
    public void playHandVal(){
        int i = 0; // counter
        while (i<player.size()){
            
            String cardFace = player.get(i) +""; // once card is removed off top next
            // card is at index zero 
            
            if(cardFace.contains("King") || cardFace.contains("Queen")
                || cardFace.contains("Jack") || cardFace.contains("Ten")){
                playHand += 10;
            }else if(cardFace.contains("Deuce")){
                playHand += 2;
            }else if(cardFace.contains("Three")){
                playHand += 3;
            }else if(cardFace.contains("Four")){
                playHand += 4;
            }else if(cardFace.contains("Five")){
                playHand += 5;
            }else if(cardFace.contains("Six")){
                playHand += 6;
            }else if(cardFace.contains("Seven")){
                playHand += 7;
            }else if(cardFace.contains("Eight")){
                playHand += 8;
            }else if(cardFace.contains("Nine")){
                playHand += 9;
            }else{
                return;
            }// end if else
            i++; // counter 
        }// end while

    }// end method

    public void ace(){ // method for handling a computer ace
        int i = 0; // counter
        while(i<comp.size()){
            String cardFace = comp.get(i) +"" ;
        
        if(compHand > 10 && cardFace.contains("Ace")){
            compHand ++; // treat ace as a 1
            
        } else if(compHand <= 10 && cardFace.contains("Ace")){
            compHand += 11; // treat ace as an 11
        } else if (compHand <= 15){
            comp.add(deckStack.pop()); // take another card
            compHandVal(); // sum comp hand with addtional card
        }// end if else
        i++;
    }// end while
    
        int j = 0; // counter 
    while(j<player.size()){
        
        String cardFace = player.get(j) +"" ;
        if(cardFace.contains("Ace")){
            playHand += playerAce();

        }else{
            // do nothing
        }// end if
        j++;
    } // end while
    return;
} // end method ace

public int playerAce(){ // method for handling a player ace
    int aceVal = 0; // initialize value to be set by player choice
    do{
        System.out.println("would you like to play your ace as a 1 or a 11?");
        aceVal = input.nextInt();
    }while(  aceVal != 1 && aceVal != 11 );
    return aceVal; // returns
}// end playerAce method


    
    // show cards and sum them
public String compare(){
    if(compHand > 21 && playHand > 21){
        pPoints += pot/2; // if tie for loss, split pot 
        cPoints += pot/2;
        pot = 0;
        winString = "You both lost, you have " +pPoints+ " points" ;
    }else if (21 <= compHand && compHand >= playHand || playHand > 21 ){
        winString = "You  lost, you have " +pPoints+ " points" ;
        // ** assign points back
            cPoints+=pot;
            pot = 0;
    }else if(compHand <= playHand || compHand > 21 ){
        pPoints += pot;
        winString = "You Won! You have " +pPoints+ " points" ;
            
            pot = 0;
    } else if( compHand == 21 && playHand == 21){
        pPoints += pot;
        winString = "Tie! You have " +pPoints+ " points" ;

    }else{
    }// end if else
        return winString;
}// end compare method
 
// offer to play again
public int playYN(){
  int choice = 0; // value for do while and return to main for play loop 
    
    System.out.println("Would you like to play? ");
    String choiceYN = input.next();// reads user input as string
    do{
        switch(choiceYN){
            case"YES": // yes options
            case"yes":
            case"ya":
            case"yuh":
            case"y":
                choice = 1; 
                comp.clear();// clear players hands
                player.clear();
                compHandCount = 0; //reset value 
        break;
            case "NO": // no options
            case "no":
            case "n":
            case "nah":
                choice = 0;
        break;
            default:// if neither yes or no
                System.out.println("Faulty Input: please try again");
            }//end switch case
        }while(choice != 1 && choice != 0 ); 
    return choice;

    
    }   // end playYN method
public void end(){
    System.out.println("Computer Points " +cPoints);
    System.out.println("Your Points " + pPoints);
    System.out.println("Goodbye");

}
}// end class CardMethod