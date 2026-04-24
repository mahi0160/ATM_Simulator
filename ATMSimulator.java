import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin = 1223;
        double balance = 5000;
        int attempts = 3;

        System.out.println("Welcome to ATM");

        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                int choice;

                do {
                    System.out.println("\n1. Check Balance");
                    System.out.println("2. Deposit Money");
                    System.out.println("3. Withdraw Money");
                    System.out.println("4. Exit");
                    System.out.print("Choose option: ");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        System.out.println("Balance: " + balance);
                    } else if (choice == 2) {
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        if (dep > 0) {
                            balance += dep;
                            System.out.println("Deposited successfully");
                        } else {
                            System.out.println("Invalid amount");
                        }
                    } else if (choice == 3) {
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        if (wd > 0 && wd <= balance) {
                            balance -= wd;
                            System.out.println("Withdraw successful");
                        } else {
                            System.out.println("Insufficient balance or invalid amount");
                        }
                    } else if (choice == 4) {
                        System.out.println("Thank you for using ATM");
                    } else {
                        System.out.println("Invalid option");
                    }

                } while (choice != 4);

                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN. Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Account locked");
        }

        sc.close();
    }
}