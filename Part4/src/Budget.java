import java.util.ArrayList;

public class Budget {
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public float balance() {
        float incomeTotal = 0;
        float expenseTotal = 0;

        for (Income income : getIncomes()) {
            incomeTotal += income.getAmount();
        }
        for (Expense expense : getExpenses()) {
            expenseTotal += expense.getAmount();
        }

        return incomeTotal - expenseTotal;
    }

    public void deleteTransaction(String id) {
        transactions.removeIf(transaction -> transaction.getId().equals(id));
    }
    
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void updateTransaction(Transaction newTransaction) {
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
