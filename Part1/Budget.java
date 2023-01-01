import java.util.Arrays;

public class Budget {
    public final static int ARRAY_SIZE = 100;

    private final Income[] incomes = new Income[ARRAY_SIZE];
    private final Expense[] expenses = new Expense[ARRAY_SIZE];

    public void addIncome(Income income) {
        int length = getFirstNullIndex(incomes);
        if (length < incomes.length) {
            incomes[length] = income;
        } else Printer.noSpaceLeft(TransactionType.INCOME);
    }

    public void addExpense(Expense expense) {
        int length = getFirstNullIndex(expenses);
        if (length < expenses.length) {
            expenses[length] = expense;
        } else Printer.noSpaceLeft(TransactionType.EXPENSE);

    }

    public Income[] getIncomes() {
        int length = getFirstNullIndex(incomes);
        return Arrays.copyOfRange(incomes, 0, length);
    }

    public Expense[] getExpenses() {
        int length = getFirstNullIndex(expenses);
        return Arrays.copyOfRange(expenses, 0, length);
    }

    private int getFirstNullIndex(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                return i;
            }
        }
        return objects.length;
    }
}
