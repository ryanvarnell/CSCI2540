package assg3_varnellr18;

/**
 * Test program for the account class and its children.
 * @author Ryan Varnell
 */
public class AccountTest {
    public static void main(String[] args) {
        accountTest();
        checkingAccountTest();
        savingsAccountTest();
        transferBetweenAccountsTest();
    }

    /**
     * Method for testing the parent Account class
     */
    public static void accountTest() {
        System.out.println("******************** Below are tests for the parent Account class ********************");

        // Single parameter constructor:
        Account acc1 = new Account("THIS IS ACCOUNT 1");

        // Two-parameter constructor:
        Account acc2 = new Account("THIS IS ACCOUNT 2", 1500);

        // getAccNo test:
        System.out.println("\n*** getAccNo test: ***");
        System.out.println("Account 2 account number: " + acc2.getAccNo());

        // getBalance test:
        System.out.println("\n*** getBalance test: ***");
        System.out.println("The balance of account 1 is: " + acc1.getBalance() +
                "\nThe balance of account 2 is: " + acc2.getBalance());

        // setBalance test:
        System.out.println("\n*** setBalance test: ***");
        acc1.setBalance(2500);
        System.out.println("The new balance of account 1 after setBalance is: " + acc1.getBalance());

        // deposit test:
        System.out.println("\n*** deposit test: ***");
        System.out.print("Trying to deposit a non-positive number to account 2: ");
        acc2.deposit(-500);
        System.out.println("The balance of account 2 remains unchanged: " + acc2.getBalance());
        acc2.deposit(500);
        System.out.println("After depositing $500 into account 2: " + acc2.getBalance());

        // withdraw test:
        System.out.println("\n*** withdraw test: ***");
        System.out.print("Trying to withdraw a non-positive number from account 1: ");
        acc1.withdraw(-500);
        System.out.println("The balance of account 1 remains unchanged: " + acc1.getBalance());
        acc1.withdraw(500);
        System.out.println("After withdrawing $500 from account 1: " + acc1.getBalance());

        // transfer test:
        System.out.println("\n*** transfer test: ***");
        System.out.print("Trying to transfer a non-positive amount from account 2 to account 1: ");
        acc2.transfer(acc1, -500);
        System.out.println("The balance of account 1 and 2 remain the same, respectively: " + acc1.getBalance() + ", " +
                acc2.getBalance());
        acc2.transfer(acc1, 500);
        System.out.println("After transferring $500 from account 2 to 1, the balance of account 2: " + acc2.getBalance() +
                ",\nand the balance of account 1: " + acc1.getBalance());

        // displayInfo test:
        System.out.println("\n*** displayInfo test: ***");
        acc2.displayInfo();

        // toString test:
        System.out.println("\n*** toString test: ***");
        String account = acc1.toString();
        System.out.println(account);

        // equals test
        System.out.println("\n*** equals test: ***");
        System.out.println("Account 1 is the same as account 1: " + acc1.equals(acc1));
        System.out.println("Account 1 is the same as account 2: " + acc1.equals(acc2));

        System.out.println();
    }

    /**
     * Method for testing the CheckingAccount class.
     */
    public static void checkingAccountTest() {
        System.out.println("******************** Below are tests for the CheckingAccount class ********************");

        // Single parameter constructor:
        CheckingAccount acc1 = new CheckingAccount("THIS IS CHECKING ACCOUNT 1");

        // Three-parameter constructor:
        Account acc2 = new CheckingAccount("THIS IS CHECKING ACCOUNT 2", 1500, -500);

        // getOverdraft test:
        System.out.println("\n*** getOverdraft test: ***");
        System.out.println("The overdraft limit for checking account 1 is: " + acc1.getOverdraft() +
                "\nThe overdraft limit for checking account 2 is: " + ((CheckingAccount) acc2).getOverdraft());

        // setOverdraft test:
        System.out.println("\n*** setOverdraft test: ***");
        acc1.setOverdraft(-500);
        System.out.println("The new overdraft limit of checking account 1 after setOverdraft: "
                + acc1.getOverdraft());

        // setFee test:
        System.out.println("\n*** setFee test: ***");
        CheckingAccount.setFee(25);
        System.out.println("The overdraft fee after setFee is now: " + CheckingAccount.fee);

        // getFee test:
        System.out.println("\n*** getFee test: ***");
        System.out.println("The same overdraft fee, but using getFee instead: " + CheckingAccount.getFee());

        // getAccNo test:
        System.out.println("\n*** getAccNo test: ***");
        System.out.println("Checking account 2 account number: " + acc2.getAccNo());

        // getBalance test:
        System.out.println("\n*** getBalance test: ***");
        System.out.println("The balance of checking account 1 is: " + acc1.getBalance() +
                "\nThe balance of checking account 2 is: " + acc2.getBalance());

        // setBalance test:
        System.out.println("\n*** setBalance test: ***");
        acc1.setBalance(2500);
        System.out.println("The new balance of checking account 1 after setBalance is: " + acc1.getBalance());

        // deposit test:
        System.out.println("\n*** setBalance test: ***");
        System.out.print("Trying to deposit a non-positive number to checking account 2: ");
        acc2.deposit(-500);
        System.out.println("The balance of checking account 2 remains unchanged: " + acc2.getBalance());
        acc2.deposit(500);
        System.out.println("After depositing $500 into checking account 2: " + acc2.getBalance());

        // withdraw test:
        System.out.println("\n*** withdraw test: ***");
        System.out.print("Trying to withdraw a non-positive number from checking account 1: ");
        acc1.withdraw(-500);
        System.out.println("The balance of checking account 1 remains unchanged: " + acc1.getBalance());
        acc1.withdraw(500);
        System.out.println("After withdrawing $500 from checking account 1: " + acc1.getBalance());
        acc1.withdraw(2100);
        System.out.println("After withdrawing $2200 from checking account 1 (over-balance but within overdraft " +
                        "limits: " + acc1.getBalance());

        // transfer test:
        System.out.println("\n*** transfer test: ***");
        System.out.print("Trying to transfer a non-positive amount from checking account 2 to checking account 1: ");
        acc2.transfer(acc1, -500);
        System.out.println("The balance of checking accounts 1 and 2 remain the same, respectively: "
                + acc1.getBalance() + ", " + acc2.getBalance());
        acc2.transfer(acc1, 500);
        System.out.println("After transferring $500 from checking account 2 to 1, the balance of account 2: "
                + acc2.getBalance() + ",\nand the balance of checking account 1: " + acc1.getBalance());

        // displayInfo test:
        System.out.println("\n*** displayInfo test: ***");
        acc2.displayInfo();

        // toString test:
        System.out.println("\n*** toString test: ***");
        String accString = acc1.toString();
        System.out.println(accString);

        // equals test
        System.out.println("\n*** equals test: ***");
        System.out.println("Checking Account 1 is the same as account 1: " + acc1.equals(acc1));
        System.out.println("Checking Account 1 is the same as account 2: " + acc1.equals(acc2));

        System.out.println();
    }

    /**
     * Method for testing the SavingsAccount class
     */
    public static void savingsAccountTest() {
        System.out.println("******************** Below are tests for the SavingsAccount class ********************\n");

        // Single parameter constructor:
        SavingsAccount acc1 = new SavingsAccount("THIS IS SAVINGS ACCOUNT 1");

        // Three-parameter constructor:
        Account acc2 = new SavingsAccount("THIS IS SAVINGS ACCOUNT 2", 1500, 3);

        // getInterestRate test:
        System.out.println("*** getInterestRate test: ***");
        System.out.println("The interest rate of savings account 1 is: " + acc1.getInterestRate() +
                "\nThe interest rate of savings account 2 is: " + ((SavingsAccount) acc2).getInterestRate());

        // setInterestRate test:
        System.out.println("\n*** setInterestRate test: ***");
        acc1.setInterestRate(2);
        System.out.println("The interest rate of savings account 1 after setInterestRate is: "
                + acc1.getInterestRate());

        // addInterest test:
        System.out.println("\n*** addInterest test: ***");
        System.out.println("Account 2 balance before addInterest: " + acc2.getBalance());
        ((SavingsAccount) acc2).addInterest();
        System.out.println("Account 2 balance after addInterest: " + acc2.getBalance());

        // getAccNo test:
        System.out.println("\n*** getAccNo test: ***");
        System.out.println("Savings account 2 account number: " + acc2.getAccNo());

        // getBalance test:
        System.out.println("\n*** getBalance test: ***");
        System.out.println("The balance of savings account 1 is: " + acc1.getBalance() +
                "\nThe balance of savings account 2 is: " + acc2.getBalance());

        // setBalance test:
        System.out.println("\n*** setBalance test: ***");
        acc1.setBalance(2500);
        System.out.println("The new balance of savings account 1 after setBalance is: " + acc1.getBalance());

        // deposit test:
        System.out.println("\n*** deposit test: ***");
        System.out.print("Trying to deposit a non-positive number to savings account 2: ");
        acc2.deposit(-500);
        System.out.println("The balance of savings account 2 remains unchanged: " + acc2.getBalance());
        acc2.deposit(500);
        System.out.println("After depositing $500 into checking account 2: " + acc2.getBalance());

        // withdraw test:
        System.out.println("\n*** withdraw test: ***");
        System.out.print("Trying to withdraw a non-positive number from savings account 1: ");
        acc1.withdraw(-500);
        System.out.println("The balance of savings account 1 remains unchanged: " + acc1.getBalance());
        acc1.withdraw(500);
        System.out.println("After withdrawing $500 from savings account 1: " + acc1.getBalance());
        System.out.print("Trying to overdraft savings account 1: ");
        acc1.withdraw(acc1.getBalance() + 200);
        System.out.println("Balance of savings account 1 remains unchanged: " + acc1.getBalance());

        // transfer test:
        System.out.println("\n*** transfer test: ***");
        System.out.print("Trying to transfer a non-positive amount from savings account 2 to savings account 1: ");
        acc2.transfer(acc1, -500);
        System.out.println("The balance of savings accounts 1 and 2 remain the same, respectively: "
                + acc1.getBalance() + ", " + acc2.getBalance());
        acc2.transfer(acc1, 500);
        System.out.println("After transferring $500 from savings account 2 to 1, the balance of savings account 2: "
                + acc2.getBalance() + "; the balance of savings account 1: " + acc1.getBalance());

        // displayInfo test:
        System.out.println("\n*** displayInfo test: ***");
        acc2.displayInfo();

        // toString test:
        System.out.println("\n*** toString test: ***");
        String accString = acc1.toString();
        System.out.println("" + accString);

        // equals test
        System.out.println("\n*** equals test: ***");
        System.out.println("Savings Account 1 is the same as savings account 1: " + acc1.equals(acc1));
        System.out.println("Savings Account 1 is the same as savings account 2: " + acc1.equals(acc2));

        System.out.println();
    }

    /**
     * Method for testing transfers between checking and savings accounts
     */
    public static void transferBetweenAccountsTest() {
        System.out.println("******************** Below are tests for transferring between account types" +
                " ********************\n");

        // Creates and prints the accounts before any modifications
        CheckingAccount checkingAcc = new CheckingAccount("THIS IS A CHECKING ACCOUNT", 5000, -500);
        SavingsAccount savingsAcc = new SavingsAccount("THIS IS A SAVINGS ACCOUNT", 5000, 3);
        System.out.println("***** Savings account before transfers: *****\n" + savingsAcc
        + "\n\n***** Checking account before transfers: *****\n" + checkingAcc);

        // Transfer from savings account to checking
        System.out.println("\n***** After transferring from Savings to Checking: *****");
        savingsAcc.transfer(checkingAcc, 1250);
        savingsAcc.displayInfo();
        lineBreak();
        checkingAcc.displayInfo();

        // Transfer from checking to savings
        System.out.println("\n***** Transferring back to Savings from Checking: *****");
        checkingAcc.transfer(savingsAcc, 1250);
        savingsAcc.displayInfo();
        lineBreak();
        checkingAcc.displayInfo();

        // Overdraft checking account for a transfer
        System.out.println("\n***** Over-drafting Checking for a transfer to Savings: *****");
        checkingAcc.transfer(savingsAcc, checkingAcc.getBalance() + 150);
        savingsAcc.displayInfo();
        lineBreak();
        checkingAcc.displayInfo();
        System.out.println();
    }

    /**
     * Line-break for formatting purposes. Not integral.
     */
    public static void lineBreak() {
        System.out.println("----------");
    }
}
