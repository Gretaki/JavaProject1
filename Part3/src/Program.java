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
                case "8" -> editTransaction(sc, budget);
                default -> Printer.invalidArgumentMessage();
            }
        }
        return budget;
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
