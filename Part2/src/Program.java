import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        runProgram(sc);

        sc.close();
    }

    public static Budget runProgram(Scanner sc) {
        Budget budget = new Budget();

        Printer.programStartGreeting();

        boolean runProgram = true;
        while (runProgram) {
            Printer.options();

            String inputOption = sc.nextLine().toLowerCase();

            switch (inputOption) {
                case "x" -> runProgram = false;
                case "1" -> addIncome(sc, budget);
                case "2" -> addExpense(sc, budget);
                case "3" -> Printer.print(budget.getIncomes(), TransactionType.INCOME.name.toUpperCase());
                case "4" -> Printer.print(budget.getExpenses(), TransactionType.EXPENSE.name.toUpperCase());
                case "5" -> printAllTransactions(budget);
                case "6" -> deleteTransaction(sc, budget);
                case "7" -> Printer.printBudget(budget.balance());
                default -> Printer.invalidArgumentMessage();
            }
        }
        return budget;
    }

    private static void addIncome(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc);
        Printer.inputMessage(TransactionType.INCOME);

        float amount = inputProcessor.getAmount();
        LocalDate date = inputProcessor.getDate();
        String category = inputProcessor.getCategory();
        boolean isBankTransaction = inputProcessor.getIsBankTransaction();
        String additionalInformation = inputProcessor.getAdditionalInformation();

        Income income = new Income(amount, date, category, isBankTransaction, additionalInformation);
        budget.addIncome(income);
    }


    private static void addExpense(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc);
        Printer.inputMessage(TransactionType.EXPENSE);

        float amount = inputProcessor.getAmount();
        LocalDateTime dateTime = inputProcessor.getDateTime();
        String category = inputProcessor.getCategory();
        String paymentMethod = inputProcessor.getPaymentMethod();
        String additionalInformation = inputProcessor.getAdditionalInformation();

        Expense expense = new Expense(amount, dateTime, category, paymentMethod, additionalInformation);
        budget.addExpense(expense);
    }

    private static void deleteTransaction(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc, budget);
        Printer.deleteMessage();

        String id = inputProcessor.getId();
        budget.deleteTransaction(id);
    }

    private static void printAllTransactions(Budget budget) {
        Printer.print(budget.getIncomes(), "Incomes");
        Printer.print(budget.getExpenses(), "Expenses");
    }
}
