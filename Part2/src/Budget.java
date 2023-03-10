import java.util.ArrayList;

public class Budget {
    private final ArrayList<Income> incomes = new ArrayList<>();
    private final ArrayList<Expense> expenses = new ArrayList<>();

    public float balance() {
        float incomeTotal = 0;
        float expenseTotal = 0;
        
        for (Income income : incomes) {
            incomeTotal += income.getAmount();
        }
        for (Expense expense : expenses) {
            expenseTotal += expense.getAmount();
        }

        return incomeTotal - expenseTotal;
    }

    public void deleteTransaction(String id) {
        incomes.removeIf(income -> income.getId().equals(id));
        expenses.removeIf(expense -> expense.getId().equals(id));
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
}
