import java.util.Arrays;

public class Budget {
    private final Income[] incomes = new Income[Constants.ARRAY_SIZE];
    private final Expense[] expenses = new Expense[Constants.ARRAY_SIZE];

    public void setIncome(Income income) {
        int length = getNotNullArrayLength(incomes);
        if (length < incomes.length) {
            incomes[length] = income;
        } else Printer.noSpaceLeft("income");
    }

    public void setExpense(Expense expense) {
        int length = getNotNullArrayLength(expenses);
        if (length < expenses.length) {
            expenses[length] = expense;
        } else Printer.noSpaceLeft("expense");

    }

    public Income[] getIncomes() {
        int length = getNotNullArrayLength(incomes);
        return Arrays.copyOfRange(incomes, 0, length);
    }

    public Expense[] getExpenses() {
        int length = getNotNullArrayLength(expenses);
        return Arrays.copyOfRange(expenses, 0, length);
    }

    private int getNotNullArrayLength(Expense[] expenses) {
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] == null) {
                return i;
            }
        }
        return expenses.length;
    }

    private int getNotNullArrayLength(Income[] incomes) {
        for (int i = 0; i < incomes.length; i++) {
            if (incomes[i] == null) {
                return i;
            }
        }
        return incomes.length;
    }
}
