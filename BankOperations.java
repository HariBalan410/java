import java.util.Scanner;

interface Account {
    void deposit(double amount);
    void withdraw(double amount) throws BalanceException;
    void checkBalance();
}

class BalanceException extends java.lang.Exception {
    public BalanceException(String message) {
        super(message);
    }
}

class BankAccount implements Account {
    String name;
    int accountNumber;
    double balance;

    BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        balance = balance + amount;

        System.out.println("Amount Deposited Successfully");
        System.out.println("Available Balance: Rs. " + balance);
    }

    public void withdraw(double amount) throws BalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        if (amount > balance) {
            throw new BalanceException("Insufficient Balance");
        }

        balance = balance - amount;

        System.out.println("Amount Withdrawn Successfully");
        System.out.println("Available Balance: Rs. " + balance);
    }

    public void checkBalance() {
        System.out.println("Available Balance: Rs. " + balance);
    }
}

public class BankOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Account Number: ");
            int accountNumber = sc.nextInt();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            if (balance < 0) {
                throw new IllegalArgumentException("Invalid Initial Balance");
            }

            BankAccount account =
                    new BankAccount(name, accountNumber, balance);

            System.out.println();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    try {
                        account.withdraw(withdrawAmount);
                    } catch (BalanceException e) {
                        System.out.println("Exception: " + e.getMessage());
                        System.out.println("Transaction Failed");
                        System.out.println(
                            "Available Balance: Rs. " + account.balance
                        );
                    }
                    break;

                case 3:
                    account.checkBalance();
                    break;

                default:
                    System.out.println("Invalid Operation");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Exception: Invalid Input");

        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}

