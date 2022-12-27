import java.util.Arrays;
import java.util.Objects;

public class Budget {
    Income[] incomes = new Income[Constants.ARRAY_SIZE];
    Expense[] expenses = new Expense[Constants.ARRAY_SIZE];

    public void setIncome(Income income) {
        int length = getNotNullArrayLength(incomes);
        incomes[length] = income;
    }

    public void setExpense(Expense expense) {
        int length = getNotNullArrayLength(expenses);
        expenses[length] = expense;
    }

    public Income[] getIncomes() {
        int length = getNotNullArrayLength(incomes);
        Income[] result = new Income[length];

        int resultCounter = 0;
        for (Income income : incomes) {
            if (income != null) {
                result[resultCounter] = income;
                resultCounter++;
            }
        }
        return result;
    }

    public Expense[] getExpenses() {
        int length = getNotNullArrayLength(expenses);
        Expense[] result = new Expense[length];

        int resultCounter = 0;
        for (Expense expense : expenses) {
            if (expense != null) {
                result[resultCounter] = expense;
                resultCounter++;
            }
        }
        return result;
    }

    private int getNotNullArrayLength(Expense[] expenses) {
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private int getNotNullArrayLength(Income[] incomes) {
        for (int i = 0; i < incomes.length; i++) {
            if (incomes[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
