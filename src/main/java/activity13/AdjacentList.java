package activity13;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Adjacent list program for graphs
 * @author Ryan Varnell
 * @author Nimra Javed
 */
public class AdjacentList {
    private static final Scanner KBD = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<LinkedList<Character>> adjacentList = new LinkedList<>();
        System.out.print("Enter the vertices (separated by comma): ");
        String input = KBD.nextLine();
        String[] vertices = input.split(",");
        System.out.print("Enter the edges (separated by comma): ");
        input = KBD.nextLine();
        String[] edges = input.split(",");

        for (LinkedList<Character> list :
                adjacentList) {
            for (Character c :
                    list) {
                System.out.println(c + ",");
            }
        }
    }
}
