package user;

import java.util.Scanner;

public class Billing implements BillingInterface{
    private String paymentMethod;
    private double balance;
    public static Billing billingUser1 = new Billing("Credit Card", 150.00);
    public static Billing billingUser2 = new Billing("Apple Pay", 200.00);

    public Billing(String paymentMethod, double balance) {
        this.paymentMethod = paymentMethod;
        this.balance = balance;
    }

    public Billing(){

    }
    public double getBalance() {
        return balance;
    }

    public void addFunds(double amount) {
        balance += amount;//no need return?
    }

    public void charge(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else
            System.out.println("Deduction failed due to insufficient balance");
    }

    public void accountsAndSecurity(Scanner scanner){
        System.out.println("1. Add Funds to Account");
        System.out.println("2. Charge for Premium Movie");
        System.out.println("0. Back to Main Menu");
        System.out.println("Select an option: ");
        int billingChoice = scanner.nextInt();
        scanner.nextLine();

        if (billingChoice == 1) {
            System.out.print("Enter the total amount to add:");
            double amount = scanner.nextDouble();
            User.user1.getBilling().addFunds(amount);
            System.out.println("Funds added. Current balance is $" + User.user1.getBilling().getBalance());
        }
        else if (billingChoice == 2) {
            System.out.print("Enter the amount to charge:");
            double amount = scanner.nextDouble();
            User.user1.getBilling().charge(amount);
            System.out.println("Charged. Current balance is $" + User.user1.getBilling().getBalance());
        }
        else if (billingChoice == 0) {
            return;
        }
    }
}
