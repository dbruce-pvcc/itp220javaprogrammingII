/*
 * Class representing cards in a deck
 * Represents a standard deck of cards with 
 * 52 cards, four suits, and Ace low. 
 */

// Class implementing Comparable interface for compareTo() method from
// https://www.geeksforgeeks.org/how-to-override-compareto-method-in-java/
public class Card implements Comparable<Card>{

    // Instance variables rank and suit for Card class.
    // Make rank and suit final so deck cards cannot be changed.
    private final int rank; // Card rank Ace,2,3,4,5,6,7,8,9,10,Jack,Queen,King  
    private final int suit; // Card suit Clubs, Diamonds, Hearts, Spades

    // Class variable for card RANKS for Card class.
    // Make array final so card ranks cannot be changed.
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"
    };

    // Class variable for card SUITS for Card class.
    // Make array final so card suits cannot be changed.
    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"
    };

    // Default constructor for Card class set to first card in deck.
    public Card() {
        this.rank = 1;
        this.suit = 0;
    }

    // Value constructor for Card class
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Override of toString() from class Object
    // Uses index to match array string values for rank and suit.
    @Override public String toString() {
        // String str = this.rank + " of " + this.suit;
        String str = RANKS[this.rank] + " of " + SUITS[this.suit];
        return str;
    } 
    
    // Override of equals() from class Object for class Card
    // From example at 
    // https://www.geeksforgeeks.org/overriding-equals-method-in-java/
    @Override public boolean equals(Object obj) {
        boolean isEqual;
        // If object is compared with itself return true.  
        if (obj == this) {
            return true;
        }
        // Check if obj is an instance of Card.
        if (!(obj instanceof Card)) {
            return false;
        }
        // Typecast obj to Card so data members can be compared. 
        Card that = (Card) obj;
        // Compare the data members and return accordingly
        if (this.rank == that.rank & this.suit == that.suit) {
            isEqual = true;
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    // Override of compareTo() using the comparable interface in class Card
    // https://www.geeksforgeeks.org/how-to-override-compareto-method-in-java/
    // Compares suit first and then rank to determine order.
    @Override public int compareTo(Card that) {
        if (this.suit < that.suit) { 
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    // Getter for private instance variable rank for class Card
    // Takes no parametes and returns the instance variable value for rank.
    public int getRank() {
        return this.rank;
    }

    // Getter for private instance variable suit for class Card.
    // Takes no parameters and returns the instance variable value for suit.
    public int getSuit() {
        return this.suit;
    }



}
