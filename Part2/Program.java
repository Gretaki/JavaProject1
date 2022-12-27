import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean runProgram = true;
        Budget budget = new Budget();

        Printer.programStartGreeting();

        while (runProgram) {
            Printer.options();

            String inputOption = sc.nextLine().toLowerCase();

            switch (inputOption) {
                case "x" -> runProgram = false;
                case "ii" -> addIncome(sc, budget);
                case "ie" -> addExpense(sc, budget);
                case "b" -> Printer.printBudget(budget.balance());
                case "ot" -> printAllTransactions(budget);
                case "oi" -> Printer.print(budget.getIncomes());
                case "oe" -> Printer.print(budget.getExpenses());
                default -> Printer.invalidArgumentMessage();
            }
        }
        sc.close();

    }

    private static void addIncome(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc);
        Printer.inputMessage("income");

        float amount = inputProcessor.getAmount();
        LocalDate date = inputProcessor.getDate();
        String category = inputProcessor.getCategory();
        boolean isBankTransaction = inputProcessor.getIsBankTransaction();
        String additionalInformation = inputProcessor.getAdditionalInformation();

        Income income = new Income(amount, date, category, isBankTransaction, additionalInformation);
        budget.setIncome(income);
    }


    private static void addExpense(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc);
        Printer.inputMessage("expense");

        float amount = inputProcessor.getAmount();
        LocalDateTime dateTime = inputProcessor.getDateTime();
        String category = inputProcessor.getCategory();
        String paymentMethod = inputProcessor.getPaymentMethod();
        String additionalInformation = inputProcessor.getAdditionalInformation();

        Expense expense = new Expense(amount, dateTime, category, paymentMethod, additionalInformation);
        budget.setExpense(expense);
    }

    private static void printAllTransactions(Budget budget) {
        Printer.print(budget.getIncomes());
        Printer.print(budget.getExpenses());
    }
}
