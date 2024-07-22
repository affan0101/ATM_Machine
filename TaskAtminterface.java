import java.util.Scanner;

class TaskAtmInterface {
    private double balance;

    public TaskAtmInterface(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    static class ATM {
        private TaskAtmInterface bankAccount;

        public ATM(TaskAtmInterface bankAccount) {
            this.bankAccount = bankAccount;
        }

        public void displayMenu() {
            System.out.println("ATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public void performTransaction(int choice, Scanner scanner) {
            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.println("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial account balance: $");
        double initialBalance = scanner.nextDouble();
        TaskAtmInterface bankAccount = new TaskAtmInterface(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.println("Select an option: ");
            int choice = scanner.nextInt();
            atm.performTransaction(choice, scanner);
        }
    }
}
