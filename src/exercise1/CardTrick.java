package exercise1;

import java.util.Scanner;
import java.util.Random;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card.
 *
 * @author Hussain Vahora
 * @date February 2, 2024
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] hand = new Card[7];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            card.setValue(generateRandomNumber());
            card.setSuit(Card.SUITS[generateRandomNumberBetween(0, 3)]);
            hand[i] = card;
        }
        
        System.out.println("Pick a card by entering the value and suit (e.g., 5 Hearts):");
        int userValue = scanner.nextInt();
        String userSuit = scanner.next();

        // Search the hand for the user's card
        boolean found = false;
        for (Card card : hand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        // Report whether the user's card is in the hand
        if (found) {
            printInfo();
        } else {
            System.out.println("Sorry, your card is not in the hand.");
        }
    }


    /**
     * A simple method to generate a random number between 1 and 13 (inclusive) for card values.
     */
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(13) + 1;
    }

    /**
     * A simple method to generate a random number between min and max (inclusive) for suits.
     */
    private static int generateRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * A simple method to print out personal information.
     */
    private static void printInfo() {
        System.out.println("Congratulations, you guessed right!");
        System.out.println();

        System.out.println("My name is YourName");
        System.out.println();

        System.out.println("My career ambitions:");
        System.out.println("-- Your career ambitions here");

        System.out.println("My hobbies:");
        System.out.println("-- Your hobbies here");

        System.out.println();
    }
}
