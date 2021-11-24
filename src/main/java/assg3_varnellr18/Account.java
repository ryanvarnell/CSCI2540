package assg3_varnellr18;

import java.util.Objects;

/**
 * Parent class for bank accounts
 * @author Ryan Varnell
 */
public class Account {
    private final String accNo;
    private double balance = 0;
    private static final String nonPositive = "Amount must be positive";
    private static final String tooMuch = "Amount is greater than allowed";

    /**
     * Single-parameter constructor (Account # only).
     * @param accNo Account number
     */
    public Account(String accNo) {
        this.accNo = accNo;
    }

    /**
     * Two-parameter constructor (Account # and initial balance).
     * @param accNo Account number
     * @param initBalance Initial balance
     */
    public Account(String accNo, double initBalance) {
        this.accNo = accNo;
        if (initBalance < 0) {
            System.out.println("Initial balance must be non-negative. Defaulting to zero");
        } else {
            balance = initBalance;
        }
    }

    /**
     * Getter for account number.
     * @return Account number
     */
    public String getAccNo() {
        return accNo;
    }

    /**
     * Getter for balance.
     * @return Account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter for balance.
     * @param balance Account balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Takes an amount to deposit and adds it to the total balance.
     * @param amt Amount to deposit
     */
    public void deposit(double amt) {
        if (amt <= 0)
            System.out.println(nonPositive);
        else
            this.balance += amt;
    }

    /**
     * Withdraws a specified amount. Does not withdraw if amount is greater than balance or if amount is not positive.
     * @param amt Amount to withdraw
     */
    public void withdraw(double amt) {
        if (amt <= 0)
            System.out.println(nonPositive);
        else if (amt > this.balance)
            System.out.println(tooMuch);
        else
            this.balance -= amt;
    }

    /**
     * Transfers a specified amount from current account to destination account.
     * @param destinationAcc Account to be transferred to.
     * @param amt Amount to transfer.
     */
    public void transfer(Account destinationAcc, double amt) {
        if (amt <= 0)
            System.out.println(nonPositive);
        else if (amt > this.balance)
            System.out.println(tooMuch);
        else {
            this.withdraw(amt);
            destinationAcc.deposit(amt);
        }
    }

    /**
     * Prints account information.
     */
    public void displayInfo() {
        System.out.println(this);
    }

    /**
     * Returns a string with account number and current balance.
     * @return A string containing account information.
     */
    @Override
    public String toString() {
        return "Account number: " + this.accNo +
                "\nCurrent Balance: " + this.balance;
    }

    /**
     *     // Compares two accounts to see if they are the same.
     * @param acc2 Account to be compared to.
     * @return Whether the two objects are the same.
     */
    @Override
    public boolean equals(Object acc2) {
        return (acc2 instanceof Account) && Objects.equals(this.accNo, ((Account) acc2).accNo);
    }
}
