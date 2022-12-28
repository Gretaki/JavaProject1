import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

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
                case "e" -> editTransaction(sc, budget);
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
        Income income = inputProcessor.getIncome();
        budget.addTransaction(income);
    }

    private static void addExpense(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc);
        Expense expense = inputProcessor.getExpense();
        budget.addTransaction(expense);
    }

    private static void deleteTransaction(Scanner sc, Budget budget) {
        InputProcessor inputProcessor = new InputProcessor(sc, budget);
        Printer.deleteMessage();

        Transaction transaction = inputProcessor.getTransactionById();
        budget.deleteTransaction(transaction);
    }

    private static void editTransaction(Scanner sc, Budget budget) {
        if (budget.getExpenses().size() + budget.getIncomes().size() == 0) {
            Printer.noTransactionsMessage();
            return;
        }
        InputProcessor inputProcessor = new InputProcessor(sc, budget);
        Printer.editMessage();

        Transaction transaction = inputProcessor.getTransactionById();
        Transaction newTransaction;

        if (transaction instanceof Income oldIncome) {
            newTransaction = inputProcessor.getEditedIncome(oldIncome);
        } else {
            Expense oldExpense = (Expense) transaction;
            newTransaction = inputProcessor.getEditedExpense(oldExpense);
        }

        budget.updateTransaction(newTransaction);
    }

    private static void printAllTransactions(Budget budget) {
        Printer.print(budget.getIncomes(), "Incomes");
        Printer.print(budget.getExpenses(), "Expenses");
    }
}
