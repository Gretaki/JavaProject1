import java.util.ArrayList;

public class Budget {
    private final ArrayList<Income> incomes = new ArrayList<>();
    private final ArrayList<Expense> expenses = new ArrayList<>();

    public float balance(){
        float balance = 0;
        for (Income income: incomes) {
            balance+= income.getAmount();
        }
        for (Expense expense: expenses) {
            balance-= expense.getAmount();
        }
        
        return balance;
    }
    
    public void setIncome(Income income) {
        incomes.add(income);
    }

    public void setExpense(Expense expense) {
        expenses.add(expense);
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
}
