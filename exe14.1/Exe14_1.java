/*
 * Exercise 14.1 Design a better strategy for the Player.play method. 
 * For example, if there are multiple cards you can play, and one 
 * of them is an 8, you might want to play the 8. Think of other 
 * ways you can minimize penalty points, such as playing the 
 * highest-ranking cards first. 
 * 
 * Write a new class that extends Player and overrides play to 
 * implement your strategy
 * 
 * The new play strategy plays eight cards first, then matches suit next,
 * and then matches rank. If no cards match then player draws from deck. 
 */

public class Exe14_1 {

    public static void main(String[] args) {
        Eights game = new Eights();
        game.playGame();
    } 

}
