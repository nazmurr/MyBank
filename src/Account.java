import java.util.ArrayList;
import java.util.ListIterator;

public class Account {
    private final String name;
    private final String email;
    private final String phone;
    private final String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String name, String email, String phone, double initialDeposit) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = initialDeposit;
        this.accountNumber = String.valueOf(100000 + (int)(Math.random() * ((100000 - 10000) + 1)));
        transactions.add(new Transaction("Deposit", initialDeposit, balance));
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
        transactions.add(new Transaction("Deposit", amount, balance));
        return true;
    }

    public boolean withdraw(double amount) {
        if (balance - amount < 0) {
            return false;
        }
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount, balance));
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getTransactionHistory() {
        if (transactions.size() <= 0) {
            return "No transaction history found.";
        }
        StringBuilder transactionList = new StringBuilder();
        ListIterator<Transaction> transactionListIterator = transactions.listIterator(transactions.size());
        System.out.format("%-25s%-25s%-25s%-25s%n", "Transaction Date", "Transaction Type", "Transaction Amount", "Current Balance");
        while (transactionListIterator.hasPrevious()) {
            Transaction transactionItem = transactionListIterator.previous();
            transactionList.append(String.format("%-25s", transactionItem.getTransactionDate()));
            transactionList.append(String.format("%-25s", transactionItem.getTransactionType()));
            transactionList.append(String.format("%-25s", transactionItem.getTransactionAmount()));
            transactionList.append(String.format("%-25s%n", transactionItem.getCurrentBalance()));
        }
        return transactionList.toString();
    }

}
