import java.util.Scanner;

public class Account {

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    Account(String cname, String cId) {
        this.customerName = cname;
        this.customerId = cId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount; // Corrected to negative amount for withdrawal
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transactions Occurred");
        }
    }

    void calculateInterest(int years) {
        double interestRate = 0.0185;
        double newBalance = (balance * years * interestRate) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance is " + newBalance);
    }

    void showMenu() {
        char option = '\0'; // Initialize option variable
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your id is : " + customerId);
        System.out.println();

        do {
            System.out.println("What would you like to do?");
            System.out.println("A. Check your Balance");
            System.out.println("B. Make a deposit");
            System.out.println("C. Make a withdraw");
            System.out.println("D. View previous transactions");
            System.out.println("E. Calculate interest");
            System.out.println("F. Exit");

            System.out.println();
            System.out.print("Enter an option: ");
            option = scanner.next().charAt(0); // Read user input

            switch (Character.toUpperCase(option)) {
                case 'A':
                    System.out.println("===============================");
                    System.out.println("Balance = RS " + balance);
                    System.out.println("===============================");
                    System.out.println();
                    break;

                case 'B':
                    System.out.print("Enter an amount to Deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;

                case 'C':
                    System.out.print("Enter an amount to Withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    break;

                case 'D':
                    System.out.println("===============================");
                    getPreviousTransaction();
                    System.out.println("===============================");
                    break;

                case 'E':
                    System.out.print("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please enter again.");
                    break;
            }

        } while (option != 'F');

        scanner.close(); // Close the scanner
        System.out.println("Thank you for banking with us at VSRBank!");
    }
}
