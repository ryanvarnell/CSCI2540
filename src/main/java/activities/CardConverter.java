// Ryan Varnell

package activities;

import java.util.Scanner;

public class CardConverter {

    public static void main(String[] args) {

        Scanner get = new Scanner(System.in);

        System.out.println("Pick a card, any card:\n" +
                "(In the format of AH = Ace of Hearts, 10D = 10 of Diamonds, etc.)");
        String card = get.nextLine();
        if (card.length() < 3)
            card = "_".concat(card);
        String shortValue = card.substring(0, 1);
        char shortSuit = card.charAt(2);

        printValue(shortValue);
        System.out.print(" of ");
        printSuit(shortSuit);
    }

    public static void printValue(String shortValue) {

        String value = "";
        switch (shortValue) {
            case "_A" -> value = "Ace";
            case "_2" -> value = "Two";
            case "_3" -> value = "Three";
            case "_4" -> value = "Four";
            case "_5" -> value = "Five";
            case "_6" -> value = "Six";
            case "_7" -> value = "Seven";
            case "_8" -> value = "Eight";
            case "_9" -> value = "Nine";
            case "10" -> value = "Ten";
            case "_J" -> value = "Jack";
            case "_Q" -> value = "Queen";
            case "_K" -> value = "King";
        }
        System.out.print(value);
    }

    public static void printSuit(char shortSuit) {

        String suit = "";
        switch (shortSuit) {
            case 'H' -> suit = "Hearts";
            case 'D' -> suit = "Diamonds";
            case 'C' -> suit = "Clubs";
            case 'S' -> suit = "Spades";
        }
        System.out.print(suit);
    }
}
