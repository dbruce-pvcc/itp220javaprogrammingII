public class PlayerEights extends Player {

    /**
     * Constructs a player with an empty hand from PlayerEights class.
     */
    public PlayerEights(String name) {
        super(name);
    }

    /**
     * Checks whether two cards match by rank.
     */
    public static boolean cardMatchesRank(Card card1, Card card2) {
        return card1.getRank() == card2.getRank();
    }

    /**
     * Checks whether two cards match by suit.
     */
    public static boolean cardMatchesSuit(Card card1, Card card2) {
        return card1.getSuit() == card2.getSuit();
    }

    /**
     * Checks whether there is an eight card in hand.
     */
    public static boolean cardMatchesEight(Card card1, Card card2) {
        return card1.getRank() == 8;
    }

     /**
     * Searches the player's hand for an eight card.
     */
    public Card searchForEight(Card prevdiscard) {
        for (int idx = 0; idx < getHand().size(); idx = idx + 1) {
            Card card = getHand().getCard(idx);
            if (cardMatchesEight(card, prevdiscard)) {
                return getHand().popCard(idx);
            }
        }
        return null;
    }

     /**
     * Searches the player's hand for matching suit.
     */
    public Card searchForMatchSuit(Card prevdiscard) {
        for (int idx = 0; idx < getHand().size(); idx = idx + 1) {
            Card card = getHand().getCard(idx);
            if (cardMatchesSuit(card, prevdiscard)) {
                return getHand().popCard(idx);
            }
        }
        return null;
    }

    /**
     * Searches the player's hand for a matching rank.
     */
    public Card searchForMatchRank(Card prevdiscard) {
        for (int idx = 0; idx < getHand().size(); idx = idx + 1) {
            Card card = getHand().getCard(idx);
            if (cardMatchesRank(card, prevdiscard)) {
                return getHand().popCard(idx);
            }
        }
        return null;
    }

    /**
     * Override from class Player for game crazy eights.
     * Removes and returns a legal card from the player's hand.
     * Uses all eight cards first, then matches suit, and then 
     * rank. If no cards are found then draw for match from deck.
     */
    @Override public Card play(Eights eights, Card prevdiscard) {

        Card card = searchForEight(prevdiscard);
        if (card != null) {
            return card;
        } else {
            card = searchForMatchSuit(prevdiscard);
            if (card != null) {
                return card;
            } else {
                card = searchForMatchRank(prevdiscard);
                if (card != null) {
                    return card;
                } else {
                    card = drawForMatch(eights, prevdiscard);
                }
            }   
        }      
        return card;
    } 



} // end class PlayerEights

