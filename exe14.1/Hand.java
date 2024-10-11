/**
 * A hand of playing cards.
 */
public class Hand extends CardCollection {

    /**
     * Constructs an empty hand.
     */
    public Hand(String label) {
        super(label);
    }

    /**
     * Prints the label and cards.
     */
    public void display() {
        System.out.println(getLabel() + ": ");
        for (int idx = 0; idx < size(); idx = idx + 1) {
            System.out.println(getCard(idx));
        }
        System.out.println();
    }

}
