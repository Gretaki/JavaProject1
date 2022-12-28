import java.util.ArrayList;
import java.util.Objects;

public class Budget {
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public float balance() {
        float balance = 0;
        for (Income income : getIncomes()) {
            balance += income.getAmount();
        }
        for (Expense expense : getExpenses()) {
            balance -= expense.getAmount();
        }

        return balance;
    }

    public void deleteTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void updateTransaction( Transaction newTransaction) {
        int index = transactions.indexOf(newTransaction);
        transactions.set(index, newTransaction);
    }

    public ArrayList<Income> getIncomes() {
        ArrayList<Income> incomes = new ArrayList<>();
        for (Transaction transaction : transactions) {
            try {
                incomes.add((Income) transaction);
            } catch (ClassCastException ignored) {
            }
        }
        return incomes;
    }

    public ArrayList<Expense> getExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        for (Transaction transaction : transactions) {
            try {
                expenses.add((Expense) transaction);
            } catch (ClassCastException ignored) {
            }
        }
        return expenses;
    }
}
