package user;

public class Billing {
    private String paymentMethod;
    private double balance;

    public Billing(String paymentMethod, double balance) {
        this.paymentMethod = paymentMethod;
        this.balance = balance;
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

}
