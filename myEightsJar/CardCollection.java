import java.util.ArrayList;
import java.util.Random;

/**
 * A collection of playing cards.
 */
public class CardCollection {

    /**
    * Label for a collection of cards.
    * ArrayList for a collection of cards.
    */
    private String label;
    private ArrayList<Card> cards;

    /**
     * Constructs an empty ArrayList collection with label.
     */
    public CardCollection(String label) {
        this.label = label;
        this.cards = new ArrayList<Card>();
    }

    /**
     * Returns the label of the card collection.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Returns a string representation of the card collection.
     */
    public String toString() {
        return label + ": " + cards.toString();
    }

    /**
     * Adds the given card to the collection.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Removes and returns the card with the given index.
     */
    public Card popCard(int index) {
        return cards.remove(index);
    }

    /**
     * Overloaded method that removes and returns the last card.
     */
    public Card popCard() {
        int lastindex = cards.size() - 1;    // from the end of the list
        return popCard(lastindex);
    }

    /**
     * True if the collection is empty, false otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Returns the number of cards.
     */
    public int size() {
        return cards.size();
    }

    /**
     * Returns the card with the given index.
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * Returns the last card.
     */
    public Card lastCard() {
        int lastindex = cards.size() - 1;
        return cards.get(lastindex);
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int index1, int index2) {
        Card temp = cards.get(index1);
        cards.set(index1, cards.get(index2));
        cards.set(index2, temp);
    }

    /**
     * Randomly permute the cards.
     */
    public void shuffle() {
        Random random = new Random();
        for (int idx = cards.size() - 1; idx > 0; idx = idx - 1) {
            int jdx = random.nextInt(idx + 1);
            swapCards(idx, jdx);
        }
    }

    /**
     * Moves n cards from this collection to the given collection.
     */
    public void deal(CardCollection that, int numcards) {
        for (int idx = 0; idx < numcards; idx = idx + 1) {
            Card card = popCard();
            that.addCard(card);
        }
    }

    /**
     * Moves all remaining cards to the given collection.
     */
    public void dealAll(CardCollection that) {
        int allcards = cards.size();
        deal(that, allcards);
    }


    /**
     * Finds the index of the lowest card
     * between low and high index range inclusive.
    */
    private int indexLowest(int low, int high) {
        int small = low; // Start index at first element.
        // Go through array of card elements to find the lowest card.
        for(int jdx = low + 1; jdx <= high; jdx = jdx + 1) { 
            // Use compareTo to determine lowest card from suit and rank.
            int compareCards;
            compareCards = getCard(jdx).compareTo(getCard(small));
            if (compareCards == -1) {
                small = jdx;
            }
        }
        return small; 
    }

    /**
     * Sorts the array of Card objects using selection sort.
     * Arranges cards according to suit and then rank.
     */
    public void selectionSort() {
        int cardsLength = cards.size(); // length of array of card objects.
        // Go through the array of card objects and swap indexes to sort.
        // Use indexLowest() to find lowest card from unsorted array.
        // Use swapCards() to swap the indexes from start to end.
        for (int idx = 0; idx < cardsLength - 1; idx = idx + 1) {
            int small = idx;
            small = indexLowest(idx, cardsLength - 1);    
            swapCards(idx, small);
        }
    }

}