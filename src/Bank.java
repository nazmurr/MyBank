import java.util.ArrayList;

public class Bank {
    private static ArrayList<Account> bankAccounts = new ArrayList<>();
    private static Account queriedAccount = null;

    public static void main(String[] args) {
        welcome();
    }
    public static void welcome() {
        System.out.println("Welcome to MyBank! Please use the options below for your banking.");
        UserMenu.displayUserMenu();
//        System.out.println("Thank you for banking with MyBank!");
//        openAccount("john", "john@gmail.com", "3332223333", 10);
//        openAccount("sdfdsd", "johnss@gmail.com", "2233223322", 10);
//        depositFund("123456", 100);
//        System.out.println(bankAccounts.get(0).getBalance());
//        System.out.println(bankAccounts);
//        System.out.println(closeAccount("12345"));
//        System.out.println(closeAccount("123456"));
//        System.out.println(bankAccounts);
    }

    public static boolean openAccount(String name, String email, String phone, double initialDeposit) {
        bankAccounts.add(new Account(name, email, phone, initialDeposit));
        return true;
    }

    public static boolean depositFund(String accountNumber, double amount) {
        findAccount(accountNumber);
        if (queriedAccount == null) return false;
        return queriedAccount.deposit(amount);
    }

    public static boolean withdrawFund(String accountNumber, double amount) {
        findAccount(accountNumber);
        if (queriedAccount == null) return false;
        return queriedAccount.withdraw(amount);
    }

    public static double getCurrentBalance(String accountNumber) {
        findAccount(accountNumber);
        if (queriedAccount == null) return -1;
        return queriedAccount.getBalance();
    }

    public static String getMyAccountNumber(String email) {
        findAccountByEmail(email);
        if (queriedAccount == null) return "";
        return queriedAccount.getAccountNumber();
    }

    public static boolean closeAccount(String accountNumber) {
        findAccount(accountNumber);
        if (queriedAccount == null) return false;
        return bankAccounts.remove(queriedAccount);
    }

    private static void findAccount(String accountNumber) {
        queriedAccount = null;
        for (Account account: bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                queriedAccount = account;
            }
        }
    }

    private static void findAccountByEmail(String email) {
        queriedAccount = null;
        for (Account account: bankAccounts) {
            if (account.getEmail().equals(email)) {
                queriedAccount = account;
            }
        }
    }
}
