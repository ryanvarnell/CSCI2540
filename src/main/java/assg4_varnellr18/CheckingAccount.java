package assg4_varnellr18;

import java.util.Objects;

/**
 Class to store a checking account.
 @author Ryan Varnell
 */
public class CheckingAccount extends Account {
    // Is the overdraft amount expected to be negative? This class assumes yes.
    private double overdraft = 0;
    static double fee = 0;

    /**
     * Single-parameter constructor with a provided account number.
     * @param accNo Account number
     */
    public CheckingAccount(String accNo) {
        super(accNo);
    }

    /**
     * Three-parameter constructor including account number, initial balance, and initial overdraft.
     * @param accNo Account number
     * @param initBalance Initial balance
     * @param initOverdraft Initial overdraft
     */
    public CheckingAccount(String accNo, double initBalance, double initOverdraft) {
        super(accNo, initBalance);
        this.overdraft = initOverdraft;
    }

    /**
     * Getter for overdraft.
     * @return Overdraft amount
     */
    public double getOverdraft() {
        return overdraft;
    }

    /**
     * Setter for overdraft.
     * @param overdraft Overdraft amount
     */
    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    /**
     * Getter for fee.
     * @return Overdraft fee
     */
    public static double getFee() {
        return fee;
    }

    /**
     * Setter for fee.
     * @param fee Overdraft fee
     */
    public static void setFee(double fee) {
        CheckingAccount.fee = fee;
    }

    /**
     * Formats the checking account information and returns it as a string.
     * @return A string containing the checking account's information.
     */
    @Override
    public String toString() {
        return "Account number: " + this.getAccNo() +
                "\nCurrent balance: " + this.getBalance() +
                "\nOverdraft amount: " + this.getOverdraft();
    }

    /**
     * Withdraws a specific amount, taking into account overdraft amount and fees.
     *
     * If the amount to withdraw is greater than the current balance, but is still within overdraft limits
     * including overdraft fee), the specified amount and overdraft fee are withdrawn.
     * @param amt The amount to be withdrawn
     */
    @Override
    public void withdraw(double amt) {
        if (this.getBalance() < amt && this.getBalance() - (amt + fee) > this.overdraft)
            this.setBalance(getBalance() - (amt + fee));
        else
            super.withdraw(amt);
    }

    /**
     * Transfers a specified amount to a destination account.
     *
     * If the amount to transfer is greater than the current balance, but is still within overdraft limits
     * (including overdraft fee), the specified amount is transferred to the destination account and the overdraft
     * fee is deducted from this account.
     * @param destinationAcc The account to be transferred to.
     * @param amt The amount to be transferred.
     */
    @Override
    public void transfer(Account destinationAcc, double amt) {
        if (this.getBalance() < amt && this.getBalance() - (amt + fee) > this.overdraft) {
            this.withdraw(amt + fee);
            destinationAcc.deposit(amt);
        } else {
            super.transfer(destinationAcc, amt);
        }
    }

    /**
     * Prints the checking account's information
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
    public static int checkingAccountSearch(CheckingAccount[] accArray, int numOfAcc, String accNum)
            throws AccountNotFoundException {
        for (int i = 0; i <  numOfAcc; i++) {
            if (Objects.equals(accArray[i].getAccNo(), accNum))
                return i;
        }
        throw new AccountNotFoundException("No such checking account.");
    }
}
