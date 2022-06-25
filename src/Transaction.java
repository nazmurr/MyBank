import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionType;
    private double transactionAmount;
    private String transactionDate;
    private double currentBalance;

    public Transaction(String transactionType, double transactionAmount, double currentBalance) {
        LocalDateTime myLocalDT = LocalDateTime.now();
        DateTimeFormatter myDTFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myLocalDT.format(myDTFormat);
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = formattedDate;
        this.currentBalance = currentBalance;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}
