import java.util.ArrayList;
import java.util.Scanner;

// Account Class
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void checkBalance() {
        System.out.println("Account balance for " + accountHolderName + ": " + balance);
    }
}

// ATM Class
class ATM {
    private ArrayList<Account> accounts;
    private Scanner scanner;

    public ATM() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully.");
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void run() {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Access Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    accessAccount();
                    break;
                case 3:
                    System.out.println("Exiting ATM. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void accessAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        while (true) {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit Account");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    scanner.nextLine(); // Consume newline
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    scanner.nextLine(); // Consume newline
                    break;
                case 4:
                    System.out.println("Exiting Account.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// Main Class
public class ATMManagementSystem {
    public static void main(Stringargs) {
        ATM atm = new ATM();
        atm.run();
    }
}
