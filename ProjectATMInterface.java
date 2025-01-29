import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw amount
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to check the current balance
    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Transaction successful! You've withdrawn " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount! Your balance is " + account.getBalance());
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Transaction successful! You've deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount! Please enter a positive value.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

public class ProjectATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a bank account with an initial balance of 1000
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);

        while (true) {
            // Display the ATM menu
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    // Check Balance
                    atm.checkBalance();
                    break;

                case 4:
                    // Exit the ATM
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose a valid option (1-4).");
            }
        }
    }
}
