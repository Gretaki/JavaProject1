import java.util.Arrays;

public class Printer {

    public static void print(Income[] incomes) {
        System.out.println(Arrays.toString(incomes));
    }

    public static void print(Expense[] expenses) {
        System.out.println(Arrays.toString(expenses));
    }

    public static void inputMessage(String inputKind) {
        System.out.printf("Input of one %s transaction.\n", inputKind);
    }

    public static void enterAmount(){
        System.out.print("Enter amount: ");
    }

    public static void enterDate(){
        System.out.print("Enter date of the income transaction (for today - write 'now'): ");
    }
    
    public static void enterDateTime(){
        System.out.print("Enter date and time of the expense transaction: ");
    }

    public static void enterCategory(){
        System.out.print("Enter category: ");
    }

    public static void enterPaymentMethod(){
        System.out.print("Enter payment method: ");
    }

    public static void enterAdditionalInformation(){
        System.out.print("Enter additional information: ");
    }

    public static void enterIsBankTransaction(){
        System.out.print("Does transaction went throw bank: ");
    }
    
    public static void programStartGreeting() {
        System.out.println("Welcome to The Best Budgeting program!\n");
    }

    public static void options() {
        System.out.print("""
            Options:
            [ii] - input income
            [ie] - input expense
            [oi] - output income
            [oe] - output expense
            [x] - exit
            """);
    }

    public static void invalidArgumentMessage() {
        System.out.println("Invalid command, choose from the list");
    }
}
