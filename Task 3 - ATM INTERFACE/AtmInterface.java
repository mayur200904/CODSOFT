import java.util.Scanner;

// BankAccount class representing user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false; // Insufficient funds
        }
    }
}

// ATM class representing the ATM machine
public class AtmInterface {
    private BankAccount account;

    public AtmInterface(double initialBalance) {
        account = new BankAccount(initialBalance);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processOption(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + account.getBalance());
                break;
            case 3:
                System.out.println("Current balance: " + account.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();

        AtmInterface atm = new AtmInterface(initialBalance);

        while (true) {
            atm.displayMenu();
            int choice = scanner.nextInt();
            atm.processOption(choice, scanner);
        }
    }
}
