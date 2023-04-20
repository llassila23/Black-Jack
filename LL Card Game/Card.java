// this file will be for the card object
// it will have a constructor 
// it will return the card to the CardMethod class

public class Card {
    private String face;
    private String suite;

    // constructor method, initialize the face and suite of object Card
    public Card(String cardFace, String cardSuite ){
        this.face = cardFace;
        this.suite = cardSuite;
    } // end constructor

    // return Card as a string consisting of face and suite
    public String toString(){
        return face + "of" + suite;

    }// end return string
} // end class card