import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        runProgram(sc);

        sc.close();
    }

    public static Budget runProgram(Scanner sc) throws IOException {
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
                case "7" -> Printer.printBalance(budget.balance());
                case "8" -> editTransaction(sc, budget);
                case "9" -> saveDataToFile(budget);
                case "10" -> getDataFromFile(sc, budget);
                default -> Printer.invalidArgumentMessage();
            }
        }
        return budget;
    }

    private static void getDataFromFile(Scanner sc, Budget budget) throws IOException {
        InputProcessor inputProcessor = new InputProcessor(sc);
        String filePath = inputProcessor.getFilePath();
        List<Transaction> transactions = File.readTransactions(filePath);

        for (Transaction transaction : transactions) {
            budget.addTransaction(transaction);
        }

        Printer.uploadedTransactions();
        printAllTransactions(budget);
    }

    private static void saveDataToFile(Budget budget) throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.addAll(budget.getIncomes());
        transactions.addAll(budget.getExpenses());

        if (transactions.size() > 0) {
            File.saveData(transactions);
        } else {
            Printer.noTransactions();
        }
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
        if (budget.getIncomes().size() + budget.getExpenses().size() == 0) {
            Printer.noTransactionsMessage();
            return;
        }

        InputProcessor inputProcessor = new InputProcessor(sc);
        Stream<String> validIncomeIds = budget.getIncomes().stream().map(Income::getId);
        Stream<String> validExpenseIds = budget.getExpenses().stream().map(Expense::getId);
        List<String> validIds = Stream.concat(validIncomeIds, validExpenseIds).toList();

        Printer.deleteMessage();

        String id = inputProcessor.getId(validIds);
        budget.deleteTransaction(id);
    }

    private static void editTransaction(Scanner sc, Budget budget) {
        if (budget.getExpenses().size() + budget.getIncomes().size() == 0) {
            Printer.noTransactionsMessage();
            return;
        }
        
        InputProcessor inputProcessor = new InputProcessor(sc);
        List<Transaction> validTransactions = Stream.concat(budget.getExpenses().stream(), budget.getIncomes().stream()).toList();
        
        Printer.editMessage();

        Transaction transaction = inputProcessor.getTransaction(validTransactions);
        
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
