import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Printer {

    public static void print(ArrayList<?> transactions, String type) {
        System.out.println(type.concat(": ").concat(transactions.toString()));
    }

    public static void inputMessage(TransactionType type) {
        System.out.printf("Input of one %s transaction.\n", type.name);
    }

    public static void editMessage(TransactionType type) {
        System.out.printf("Edit of one %s transaction.\n", type.name);
    }

    public static void deleteMessage() {
        System.out.println("Deletion of one transaction.");
    }

    public static void editMessage() {
        System.out.println("Edit of one transaction.");
    }

    public static void currentAmount(float amount) {
        System.out.printf("Current amount: %.2f\n", amount);
    }

    public static void enterAmount() {
        System.out.print("Enter amount: ");
    }

    public static void currentDate(LocalDate date) {
        System.out.printf("Current date of the income transaction: %s\n", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public static void enterDate() {
        System.out.print("Enter date of the income transaction (for today - write 'now'): ");
    }

    public static void currentDateTime(LocalDateTime dateTime) {
        System.out.printf("Current dateTime of the expense transaction: %s\n", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }

    public static void enterDateTime() {
        System.out.print("Enter date and time of the expense transaction (for now - write 'now'): ");
    }

    public static void currentCategory(String category) {
        System.out.printf("Current category: %s\n", category);
    }

    public static void enterCategory() {
        System.out.print("Enter category: ");
    }

    public static void currentType(String type) {
        System.out.printf("Current type: %s\n", type);
    }

    public static void enterType() {
        System.out.print("Enter type: ");
    }

    public static void currentPaymentMethod(String paymentMethod) {
        System.out.printf("Current payment method: %s\n", paymentMethod);
    }

    public static void enterPaymentMethod() {
        System.out.print("Enter payment method: ");
    }

    public static void currentAdditionalInformation(String additionalInformation) {
        System.out.printf("Current additional information: %s\n", additionalInformation);
    }

    public static void enterAdditionalInformation() {
        System.out.print("Enter additional information: ");
    }

    public static void currentIsBankTransaction(boolean isBankTransaction) {
        System.out.printf("Current transaction went through bank: %b\n", isBankTransaction);
    }

    public static void enterIsBankTransaction() {
        System.out.print("Did transaction go through bank: ");
    }

    public static void programStartGreeting() {
        System.out.println("Welcome to The Best Budgeting program!\n");
    }

    public static void options() {
        System.out.print("""
            Options:
            [1] - input income
            [2] - input expense
            [3] - output income
            [4] - output expense
            [5] - output all transactions
            [6] - delete transactions
            [7] - get balance
            [8] - edit transactions
            [x] - exit
            """);
    }

    public static void editOptions() {
        System.out.print("""
            Options:
            [1] - edit transaction
            [2] - next
            """);
    }

    public static void invalidArgumentMessage() {
        System.out.println("Invalid command, choose from the list");
    }

    public static void wrongNumberFormat() {
        System.out.println("Wrong number, try again with format ###.##");
    }

    public static void wrongId() {
        System.out.println("Id does not exist, try again");
    }

    public static void noAmountField() {
        System.out.println("Amount field is necessary, please enter amount in format ###.##");
    }

    public static void wrongDateFormat() {
        System.out.println("Wrong date, try again with format yyyy-MM-dd");
    }

    public static void wrongDateTimeFormat() {
        System.out.println("Wrong date time format, try again with format yyyy-MM-dd HH:mm");
    }

    public static void printBalance(float balance) {
        System.out.printf("Balance is: %.2f\n", balance);
    }

    public static void enterId() {
        System.out.print("Enter id: ");
    }

    public static void noTransactionsMessage() {
        System.out.println("No transactions.");
    }
}
