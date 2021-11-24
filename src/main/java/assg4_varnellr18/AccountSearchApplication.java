package assg4_varnellr18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A program to read a list of accounts from an input file and allow a user to search for one or more accounts.
 * @author Ryan Varnell
 */
public class AccountSearchApplication {
    static Scanner kbd = new Scanner(System.in);

    // Arrays for containing savings and checking accounts.
    static final int maxSize = 100;
    static CheckingAccount[] checkingAccounts = new CheckingAccount[maxSize];
    static SavingsAccount[] savingsAccounts = new SavingsAccount[maxSize];

    // Integers to keep track of how many checking and savings accounts we have.
    static int numOfCheckAccs = 0;
    static int numOfSavingsAccs = 0;

    /**
     * It's the main method!!! Glad you could make it.
     */
    public static void main(String[] args) {
        // loadFile loads the file into the accountData Scanner and extractAccounts breaks up the file into the
        // checkingAccounts and savingsAccounts arrays.
        Scanner accountData = loadFile("assg4_input.txt");
        extractAccounts(accountData);
        accountData.close();

        // Prints the number of accounts and their average balance.
        System.out.println("Number of checking accounts: " + numOfCheckAccs +
                "\nAverage balance of all checking accounts: " + findAverageBalance(checkingAccounts) +
                "\nNumber of savings accounts:  " + numOfSavingsAccs +
                "\nAverage balance of all savings accounts: " + findAverageBalance(savingsAccounts));

        // Prints each individual account's account number and balance.
        System.out.println("\nAll the checking accounts:");
        for (int i = 0; i < numOfCheckAccs; i++) {
            System.out.println(checkingAccounts[i].getAccNo() + ", " + checkingAccounts[i].getBalance());
        }
        System.out.println("\nAll the savings accounts:");
        for (int i = 0; i < numOfSavingsAccs; i++) {
            System.out.println(savingsAccounts[i].getAccNo() + ", " + savingsAccounts[i].getBalance());
        }

        // Beginning of loop for searching accounts.
        System.out.println("\nAccount Search.");
        boolean loop = true;
        while (loop) {
            findAccount();

            // Prompts the user to search again. Exits the loop if they say no.
            System.out.print("\nDo you want to search for another Account(Y/N)? ");
            String choice = kbd.nextLine().toUpperCase();
            if ("N".equals(choice)) {
                loop = false;
            } else {
                System.out.println();
            }
        }

        // Just a couple of closing statements and cleanup.
        System.out.println("Thank you for coming :)");
        kbd.close();
    }

    /**
     * Method to load a given file. Throws a FileNotFoundException and exits program if file can't be read/isn't found.
     * @param fileName The name of the file, including file extension.
     * @return Successfully loaded file as a Scanner object.
     */
    public static Scanner loadFile(String fileName) {
        Scanner inputStream = null;

        // Tries to load the given file and returns it in a Scanner if successful.
        // Throws FileNotFoundException and exits program if not.
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("No such file.");
            System.exit(1);
        }
        return inputStream;
    }

    /**
     * Method for parsing the file. Adds checking accounts to the checkingAccounts array, and savings accounts to the
     * savingsAccounts array. Uses numOfCheckAccs and numOfSavingsAccs as the index for creating objects in the arrays,
     * as they are both initialized at 0 anyway.
     * @param accountData File to be read from
     */
    public static void extractAccounts(Scanner accountData) {
        while (accountData.hasNextLine()) {
            // Takes the next line of the file as a string and splits it up using white space (\\s) as a delimiter.
            String line = accountData.nextLine();
            String[] splitLine = line.split("\\s");

            // If the line contains a "C", then use the splitLine array to feed a new checking account.
            // If it contains an "S", then it uses the splitLine array to feed a new savings account.
            if (line.contains("C")) {
               checkingAccounts[numOfCheckAccs] = new CheckingAccount(splitLine[1], Double.parseDouble(splitLine[2]),
                       Double.parseDouble(splitLine[3]));
               numOfCheckAccs++;
            } else if (line.contains("S")) {
               savingsAccounts[numOfSavingsAccs] = new SavingsAccount(splitLine[1], Double.parseDouble(splitLine[2]),
                       Double.parseDouble(splitLine[3]));
               numOfSavingsAccs++;
            }
        }
    }

    /**
     * Method for finding the average balance of a collection of accounts stored in an array.
     * @param accounts The array with the accounts for which the average balance is to be calculated.
     * @return The average balance of said accounts.
     */
    public static double findAverageBalance(Account[] accounts) {
        int index = 0;
        double total = 0;

        // Add balances to "total" until you reach a null entry in the array.
        while (accounts[index] != null) {
            total += accounts[index].getBalance();
            index++;
        }

        // Returns the total divided by the index used for the while loop, which at this point should be the number of
        // accounts present in the array.
        return total / (index);
    }

    /**
     * Method that asks for a user's desired account information and searches for that account.
     */
    public static void findAccount() {
        // Requests an account type and account number to be searched.
        System.out.print("Enter account type (C/S –C for Checking and S for Savings)to search: ");
        String accountType = kbd.nextLine().toUpperCase();
        switch (accountType) {
            case "C", "S" -> {
                System.out.print("Enter account number: ");
                String accountNumber = kbd.nextLine();

                // Tries to find the account using the user's provided info.
                // CheckingAccount.checkingAccountSearch(checkingAccounts, numOfCheckAccs, accountNumber) returns the index
                // of the account in the checkingAccounts array, should it be found. That index is then plugged into
                // checkingAccounts[], which then prints said account. Same principle for the "S" savings account case.
                // Throws an AccountNotFoundException if no account is found.
                try {
                    switch (accountType) {
                        case "C" -> System.out.println(
                                checkingAccounts[CheckingAccount.checkingAccountSearch(checkingAccounts,
                                        numOfCheckAccs, accountNumber)]);
                        case "S" -> System.out.println(
                                savingsAccounts[SavingsAccount.savingsAccountSearch(savingsAccounts,
                                        numOfSavingsAccs, accountNumber)]);
                        default -> System.out.println("Something went wrong.");
                    }
                } catch (AccountNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> System.out.println("Invalid account type.");
        }
    }
}
