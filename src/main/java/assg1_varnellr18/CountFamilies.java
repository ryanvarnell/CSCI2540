// Ryan Varnell

package assg1_varnellr18;

import java.util.Scanner;

// This class gets a number of families and incomes from the user, finds the max income and the incomes less than
// 10% of the max
public class CountFamilies {

    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);

        // Gets the number of families and initializes an array of incomes
        System.out.print("Please enter the number of families: ");
        int numOfFamilies = get.nextInt();
        int[] incomes = new int[numOfFamilies];

        // Gets the incomes
        for (int i = 0; i < numOfFamilies; i++) {
            System.out.print("Enter an income: ");
            incomes[i] = get.nextInt();
        }

        // Finds the max income iteratively
        int maxIncome = incomes[0];
        for (int i = 0; i < numOfFamilies; i++) {
            if (incomes[i] > maxIncome) {
                maxIncome = incomes[i];
            }
        }

        System.out.println(
                "\nThe maximum income is: " + maxIncome +
                "\n\nThe incomes of families making less than 10% of the maximum are:"
        );

        // Finds the incomes less than 10% of the max
        int lessThanTenPercent = 0;
        for (int i = 0; i < numOfFamilies; i++) {
            if (incomes[i] < (maxIncome * .10)) {
                lessThanTenPercent++;
                System.out.println(incomes[i]);
            }
        }
        System.out.println("for a total of " + lessThanTenPercent + " families.");
    }
}

