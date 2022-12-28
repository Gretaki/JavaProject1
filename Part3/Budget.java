import java.util.ArrayList;

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

    public void deleteTransaction(String id) {
        transactions.removeIf(income -> income.getId().equals(id));
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
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
