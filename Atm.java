import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = Math.max(initialBalance, 0);
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    doWithdrawal();
                    break;
                case 2:
                    doDeposit();
                    break;
                case 3:
                    System.out.printf("Your current balance is: ₹%.2f%n%n", account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    private void showMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private void doWithdrawal() {
        double amount = readDouble("Enter amount to withdraw: ");
        if (amount <= 0) {
            System.out.println("Please enter a positive amount.\n");
        } else if (account.withdraw(amount)) {
            System.out.printf("Withdrawal successful. New balance: ₹%.2f%n%n", account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.\n");
        }
    }

    private void doDeposit() {
        double amount = readDouble("Enter amount to deposit: ");
        if (amount <= 0) {
            System.out.println("Please enter a positive amount.\n");
        } else if (account.deposit(amount)) {
            System.out.printf("Deposit successful. New balance: ₹%.2f%n%n", account.getBalance());
        } else {
            System.out.println("Invalid amount. Try again.\n");
        }
    }

    // Input helpers
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

public class Atm {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000.0); // initial balance
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
