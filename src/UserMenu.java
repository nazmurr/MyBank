import java.util.Scanner;

public class UserMenu {
    public static void displayUserMenu() {
        Scanner userChoice = new Scanner(System.in);
        int menuId = 0;
        String userMenu = "1. Open Account\n" +
                "2. Deposit Fund\n" +
                "3. Withdraw Fund\n" +
                "4. Current Balance & History\n" +
                "5. Forgot My Account Number\n" +
                "6. Close Account\n" +
                "7. Exit\n";
        do {
            try {
                System.out.println(userMenu);
                System.out.print("Enter your choice [1-7]: ");
                if(!userChoice.hasNextInt()) {
                    throw new Exception("[Error] Please enter a number between 1 to 7");
                }
                menuId = userChoice.nextInt();
                processUserMenuChoice(menuId);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                userChoice.next();
            }
        } while (menuId != 7);
        userChoice.close();
    }

    private static void processUserMenuChoice(int menuId) {
        switch (menuId) {
            case 1:
                UserMenuActions.createAccountMenu();
                break;
            case 2:
                UserMenuActions.depositFundMenu();
                break;
            case 3:
                UserMenuActions.withdrawFundMenu();
                break;
            case 4:
                UserMenuActions.currentBalanceAndHistoryMenu();
                break;
            case 5:
                UserMenuActions.forgotAccountNumberMenu();
                break;
            case 6:
                UserMenuActions.closeAccountMenu();
                break;
            default:
                System.out.println("Thank you for banking with MyBank!");
                break;
        }

    }


}
