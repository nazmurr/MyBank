import java.util.Scanner;

public class UserMenuActions {
    public static void createAccountMenu() {
        Scanner userInput = new Scanner(System.in);
        String name = "";
        String email = "";
        String phone = "";
        double initialDeposit = -1;
        int mainMenuKey = -1;
        do {
            try {
                System.out.print("Enter your name: ");
                name = userInput.nextLine();
                if (name.isEmpty()) throw new Exception("[Error] Name can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (name.equals(""));

        do {
            try {
                System.out.print("Enter your email: ");
                email = userInput.nextLine();
                if (email.isEmpty()) throw new Exception("[Error] Email can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (email.equals(""));

        do {
            try {
                System.out.print("Enter your phone: ");
                phone = userInput.nextLine();
                if (phone.isEmpty()) throw new Exception("[Error] Phone can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (phone.equals(""));

        do {
            try {
                System.out.print("Enter initial deposit amount: ");
                if (!userInput.hasNextDouble()) {
                    throw new Exception("[Error] Please enter only number for deposit amount");
                }
                initialDeposit = userInput.nextDouble();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                userInput.next();
            }
        } while (initialDeposit == -1);

        boolean status = Bank.openAccount(name, email, phone, initialDeposit);
        String statusMessage;
        if (status) {
            statusMessage = "Account opened successfully. Your account number is " +
                    Bank.getMyAccountNumber(email);
        } else {
            statusMessage = "Sorry, we are unable to open your account. " +
                    "Please try again with correct information.";
        }
        System.out.println(statusMessage);
        while (mainMenuKey != 0) {
            System.out.print("Press 0 to return to main menu. ");
            mainMenuKey = userInput.nextInt();
        }
    }

    public static void depositFundMenu() {
        Scanner userInput = new Scanner(System.in);
        String accountNumber = "";
        double amount = -1;
        int mainMenuKey = -1;
        do {
            try {
                System.out.print("Enter your account number: ");
                accountNumber = userInput.nextLine();
                if (accountNumber.isEmpty()) throw new Exception("[Error] Account number can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (accountNumber.equals(""));

        do {
            try {
                System.out.print("Enter deposit amount: ");
                if (!userInput.hasNextDouble()) {
                    throw new Exception("[Error] Please enter only number for deposit amount");
                }
                amount = userInput.nextDouble();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                userInput.next();
            }
        } while (amount == -1);

        boolean status = Bank.depositFund(accountNumber, Math.abs(amount));
        String statusMessage;
        if (status) {
            statusMessage = "Fund deposited successfully.";
        } else {
            statusMessage = "Sorry, we are unable to deposit fund in your account. " +
                    "Please try again with correct information.";
        }
        System.out.println(statusMessage);
        while (mainMenuKey != 0) {
            System.out.print("Press 0 to return to main menu. ");
            mainMenuKey = userInput.nextInt();
        }
    }

    public static void withdrawFundMenu() {
        Scanner userInput = new Scanner(System.in);
        String accountNumber = "";
        double amount = -1;
        int mainMenuKey = -1;
        do {
            try {
                System.out.print("Enter your account number: ");
                accountNumber = userInput.nextLine();
                if (accountNumber.isEmpty()) throw new Exception("[Error] Account number can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (accountNumber.equals(""));

        do {
            try {
                System.out.print("Enter withdrawal amount: ");
                if (!userInput.hasNextDouble()) {
                    throw new Exception("[Error] Please enter only number for withdrawal amount");
                }
                amount = userInput.nextDouble();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                userInput.next();
            }
        } while (amount == -1);

        boolean status = Bank.withdrawFund(accountNumber, Math.abs(amount));
        String statusMessage;
        if (status) {
            statusMessage = "Fund withdrawn successfully.";
        } else {
            statusMessage = "Sorry, we are unable to withdraw fund from your account. " +
                    "Please try again with correct information.";
        }
        System.out.println(statusMessage);
        while (mainMenuKey != 0) {
            System.out.print("Press 0 to return to main menu. ");
            mainMenuKey = userInput.nextInt();
        }
    }

    public static void currentBalanceAndHistoryMenu() {
        Scanner userInput = new Scanner(System.in);
        String accountNumber = "";
        int mainMenuKey = -1;
        do {
            try {
                System.out.print("Enter your account number: ");
                accountNumber = userInput.nextLine();
                if (accountNumber.isEmpty()) throw new Exception("[Error] Account number can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (accountNumber.equals(""));

        double currentBalance = Bank.getCurrentBalance(accountNumber);
        String statusMessage;
        if (currentBalance != -1) {
            statusMessage = "Your current balance is " + currentBalance;
        } else {
            statusMessage = "Sorry, we are unable to get current balance from your account. " +
                    "Please try again with correct information.";
        }
        System.out.println(statusMessage);
        while (mainMenuKey != 0) {
            System.out.print("Press 0 to return to main menu. ");
            mainMenuKey = userInput.nextInt();
        }
    }

    public static void forgotAccountNumberMenu() {
        Scanner userInput = new Scanner(System.in);
        String email = "";
        int mainMenuKey = -1;
        do {
            try {
                System.out.print("Enter your email: ");
                email = userInput.nextLine();
                if (email.isEmpty()) throw new Exception("[Error] Email can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (email.equals(""));

        String accountNumber = Bank.getMyAccountNumber(email);
        String statusMessage;
        if (!accountNumber.equals("")) {
            statusMessage = "Your account number: " + accountNumber;
        } else {
            statusMessage = "Sorry, we are unable to get account number of your account. " +
                    "Please try again with correct information.";
        }
        System.out.println(statusMessage);
        while (mainMenuKey != 0) {
            System.out.print("Press 0 to return to main menu. ");
            mainMenuKey = userInput.nextInt();
        }
    }

    public static void closeAccountMenu() {
        Scanner userInput = new Scanner(System.in);
        String accountNumber = "";
        int mainMenuKey = -1;
        do {
            try {
                System.out.print("Enter your account number: ");
                accountNumber = userInput.nextLine();
                if (accountNumber.isEmpty()) throw new Exception("[Error] Account number can not be blank");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (accountNumber.equals(""));

        boolean status = Bank.closeAccount(accountNumber);
        String statusMessage;
        if (status) {
            statusMessage = "Your account has been closed.";
        } else {
            statusMessage = "Sorry, we are unable to close your account. " +
                    "Please try again with correct information.";
        }
        System.out.println(statusMessage);
        while (mainMenuKey != 0) {
            System.out.print("Press 0 to return to main menu. ");
            mainMenuKey = userInput.nextInt();
        }
    }
}
