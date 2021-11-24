package assg4_varnellr18;

import java.util.Objects;

/**
 * Class to store a savings account.
 * @author  Ryan Varnell
 */
public class SavingsAccount extends Account {
    double interestRate = 0;

    /**
     * Default single-parameter constructor.
     * @param accNum Savings account number
     */
    public SavingsAccount(String accNum) {
        super(accNum);
    }

    /**
     * Three-parameter constructor.
     * @param accNum Account number
     * @param initBalance Initial balance
     * @param interestRate Interest rate
     */
    public SavingsAccount(String accNum, double initBalance, double interestRate) {
        super(accNum, initBalance);
        this.interestRate = interestRate;
    }

    /**
     * Getter for interest rate.
     * @return Interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Setter for interest rate.
     * @param interestRate  Interest rate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Adds interest earned to the balance
     */
    public void addInterest() {
        this.setBalance((1 + interestRate) * this.getBalance());
    }

    /**
     * Converts the information from savings account to a string
     * @return A string containing savings account info.
     */
    @Override
    public String toString() {
        return "Account number: " + this.getAccNo() +
                "\nCurrent balance: " + this.getBalance() +
                "\nInterest Rate: " + this.getInterestRate();
    }

    /**
     * Prints the savings account info
     */
    @Override
    public void displayInfo() {
        System.out.println(this);
    }

    /**
     * Searches a given array of accounts for an account with a specified account number.
     * @param accArray Array of accounts
     * @param numOfAcc The amount of accounts present in the array
     * @param accNum The account number of the account to be searched for
     * @return The index of the account if found.
     */
    public static int savingsAccountSearch(SavingsAccount[] accArray, int numOfAcc, String accNum)
            throws AccountNotFoundException {
        for (int i = 0; i <  numOfAcc; i++) {
            if (Objects.equals(accArray[i].getAccNo(), accNum))
                return i;
        }
        throw new AccountNotFoundException("No such savings account.");
    }
}
