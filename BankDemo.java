abstract class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + " in Savings Account");
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " from Savings Account");
        } else {
            System.out.println("Minimum balance of ₹1000 must be maintained.");
        }
    }
}

class CurrentAccount extends BankAccount {

    CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + " in Current Account");
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount >= -5000) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " from Current Account");
        } else {
            System.out.println("Overdraft limit of ₹5000 exceeded.");
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {

        SavingsAccount s = new SavingsAccount(5000);
        s.deposit(2000);
        s.withdraw(5500);
        s.showBalance();

        System.out.println();

        CurrentAccount c = new CurrentAccount(3000);
        c.deposit(1000);
        c.withdraw(7000);
        c.showBalance();
    }
}
