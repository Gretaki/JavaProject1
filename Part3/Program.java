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
                case "d" -> deleteTransaction(sc, budget);
                case "b" -> Printer.printBudget(budget.balance());
                case "o" -> printAllTransactions(budget);
                case "oi" -> Printer.print(budget.getIncomes(), "Incomes");
                case "oe" -> Printer.print(budget.getExpenses(), "Expenses");
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
        String type = inputProcessor.getType();
        boolean isBankTransaction = inputProcessor.getIsBankTransaction();
        String additionalInformation = inputProcessor.getAdditionalInformation();

        Income income = new Income(amount, date, category, type, isBankTransaction, additionalInformation);
        budget.setIncome(income);
    }


    private static void addExpense(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc);
        Printer.inputMessage("expense");

        float amount = inputProcessor.getAmount();
        LocalDateTime dateTime = inputProcessor.getDateTime();
        String category = inputProcessor.getCategory();
        String type = inputProcessor.getType();
        String paymentMethod = inputProcessor.getPaymentMethod();
        String additionalInformation = inputProcessor.getAdditionalInformation();

        Expense expense = new Expense(amount, dateTime, category, type, paymentMethod, additionalInformation);
        budget.setExpense(expense);
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
