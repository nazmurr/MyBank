public class Account {
    private final String name;
    private final String email;
    private final String phone;
    private final String accountNumber;
    private double balance;

    public Account(String name, String email, String phone, double initialDeposit) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = initialDeposit;
        this.accountNumber = String.valueOf(100000 + (int)(Math.random() * ((100000 - 10000) + 1)));
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (balance - amount < 0) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}
