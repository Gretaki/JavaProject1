import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputProcessor {
    private final Scanner sc;
    private final Budget budget;

    public InputProcessor(Scanner sc) {
        this.sc = sc;
        budget = null;
    }

    public InputProcessor(Scanner sc, Budget budget) {
        this.sc = sc;
        this.budget = budget;
    }

    public Income getIncome() {
        Printer.inputMessage("income");

        float amount = getAmount();
        LocalDate date = getDate();
        String category = getCategory();
        String type = getType();
        boolean isBankTransaction = getIsBankTransaction();
        String additionalInformation = getAdditionalInformation();

        return new Income(amount, date, category, type, isBankTransaction, additionalInformation);
    }

    public Expense getExpense() {
        Printer.inputMessage("expense");

        float amount = getAmount();
        LocalDateTime dateTime = getDateTime();
        String category = getCategory();
        String type = getType();
        String paymentMethod = getPaymentMethod();
        String additionalInformation = getAdditionalInformation();

        return new Expense(amount, dateTime, category, type, paymentMethod, additionalInformation);
    }

    public Income getEditedIncome(Income income) {
        Printer.editMessage("income");

        float newAmount = editAmount(income.getAmount());
        LocalDate newDate = editDate(income.getDate());
        String newCategory = editCategory(income.getCategory());
        String newType = editType(income.getType());
        boolean newIsBankTransaction = editIsBankTransaction(income.isBankTransaction());
        String newAdditionalInformation = editAdditionalInformation(income.getAdditionalInformation());

        return new Income(income.getId(), newAmount, newDate, newCategory, newType, newIsBankTransaction, newAdditionalInformation);
    }

    public Expense getEditedExpense(Expense expense) {
        Printer.editMessage("expense");

        float newAmount = editAmount(expense.getAmount());
        LocalDateTime newDateTime = editDateTime(expense.getDateTime());
        String newCategory = editCategory(expense.getCategory());
        String newType = editType(expense.getType());
        String newPaymentMethod = editPaymentMethod(expense.getPaymentMethod());
        String newAdditionalInformation = editAdditionalInformation(expense.getAdditionalInformation());

        return new Expense(expense.getId(), newAmount, newDateTime, newCategory, newType, newPaymentMethod, newAdditionalInformation);
    }

    public Transaction getTransactionById() {
        while (true) {
            Printer.enterId();
            String inputId = sc.nextLine().trim();

            for (Income income : budget.getIncomes()) {
                if (income.getId().equals(inputId)) {
                    return income;
                }
            }

            for (Expense expense : budget.getExpenses()) {
                if (expense.getId().equals(inputId)) {
                    return expense;
                }
            }

            Printer.wrongId();
        }
    }
    
    private boolean editField() {
        while (true) {
            Printer.editOptions();
            String inputOption = sc.nextLine().toLowerCase();

            switch (inputOption) {
                case "1" -> {
                    return true;
                }
                case "2" -> {
                    return false;
                }
                default -> Printer.invalidArgumentMessage();
            }
        }
    }

    private float getAmount() {
        while (true) {
            Printer.enterAmount();
            String inputAmount = sc.nextLine().trim();
            try {
                float amount = Float.parseFloat(inputAmount);
                return (float) (Math.round(amount * 100.0) / 100.0);
            } catch (NumberFormatException e) {
                Printer.wrongNumberFormat();
            } catch (NullPointerException e) {
                Printer.noAmountField();
            }
        }
    }

    private float editAmount(float oldAmount) {
        Printer.currentAmount(oldAmount);
        boolean editField = editField();
        if (editField) {
            return getAmount();
        }
        return oldAmount;
    }

    private LocalDate getDate() {
        while (true) {
            Printer.enterDate();
            String inputDate = sc.nextLine().trim();

            if (inputDate.equals("now")) {
                return LocalDate.now();
            }

            try {
                return LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                Printer.wrongDateFormat();
            }
        }
    }

    private LocalDate editDate(LocalDate oldDate) {
        Printer.currentDate(oldDate);
        boolean editField = editField();
        if (editField) {
            return getDate();
        }
        return oldDate;
    }

    private LocalDateTime getDateTime() {
        while (true) {
            Printer.enterDateTime();
            String inputDateTime = sc.nextLine().trim();

            if (inputDateTime.equals("now")) {
                LocalDateTime now = LocalDateTime.now();
                return LocalDateTime.of(now.toLocalDate(), LocalTime.of(now.getHour(), now.getMinute(), 0, 0));
            }

            try {
                return LocalDateTime.parse(inputDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            } catch (DateTimeParseException e) {
                Printer.wrongDateTimeFormat();
            }
        }
    }

    private LocalDateTime editDateTime(LocalDateTime oldDateTime) {
        Printer.currentDateTime(oldDateTime);
        boolean editField = editField();
        if (editField) {
            return getDateTime();
        }
        return oldDateTime;
    }

    private String getCategory() {
        Printer.enterCategory();
        String inputCategory = sc.nextLine().trim();

        if (inputCategory.equals("-")) {
            return null;
        }
        return inputCategory;
    }

    private String editCategory(String oldCategory) {
        Printer.currentCategory(oldCategory);
        boolean editField = editField();
        if (editField) {
            return getCategory();
        }
        return oldCategory;
    }

    private String getType() {
        Printer.enterType();
        String inputType = sc.nextLine().trim();

        if (inputType.equals("-")) {
            return null;
        }
        return inputType;
    }

    private String editType(String oldType) {
        Printer.currentType(oldType);
        boolean editField = editField();
        if (editField) {
            return getType();
        }
        return oldType;
    }

    private String getAdditionalInformation() {
        Printer.enterAdditionalInformation();
        String inputAdditionalInformation = sc.nextLine().trim();

        if (inputAdditionalInformation.equals("-")) {
            return null;
        }
        return inputAdditionalInformation;
    }

    private String editAdditionalInformation(String oldAdditionalInformation) {
        Printer.currentAdditionalInformation(oldAdditionalInformation);
        boolean editField = editField();
        if (editField) {
            return getAdditionalInformation();
        }
        return oldAdditionalInformation;
    }

    private boolean getIsBankTransaction() {
        Printer.enterIsBankTransaction();
        String inputIsBankTransaction = sc.nextLine().trim().toLowerCase();

        return inputIsBankTransaction.equals("yes") || inputIsBankTransaction.equals("true")
            || inputIsBankTransaction.equals("y") || inputIsBankTransaction.equals("taip")
            || inputIsBankTransaction.equals("t") || inputIsBankTransaction.equals("+");
    }

    private boolean editIsBankTransaction(boolean oldIsBankTransaction) {
        Printer.currentIsBankTransaction(oldIsBankTransaction);
        boolean editField = editField();
        if (editField) {
            return getIsBankTransaction();
        }
        return oldIsBankTransaction;
    }

    private String getPaymentMethod() {
        Printer.enterPaymentMethod();
        String inputPaymentMethod = sc.nextLine().trim();

        if (inputPaymentMethod.equals("-")) {
            return null;
        }
        return inputPaymentMethod;
    }

    private String editPaymentMethod(String oldPaymentMethod) {
        Printer.currentPaymentMethod(oldPaymentMethod);
        boolean editField = editField();
        if (editField) {
            return getPaymentMethod();
        }
        return oldPaymentMethod;
    }
}
