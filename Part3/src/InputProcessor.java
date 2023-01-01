import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class InputProcessor {
    private final Scanner sc;

    public InputProcessor(Scanner sc) {
        this.sc = sc;
    }

    public Income getIncome() {
        Printer.inputMessage(TransactionType.INCOME);

        float amount = getAmount();
        LocalDate date = getDate();
        String category = getCategory();
        String type = getType();
        boolean isBankTransaction = getIsBankTransaction();
        String additionalInformation = getAdditionalInformation();

        return new Income(amount, date, category, type, isBankTransaction, additionalInformation);
    }

    public Expense getExpense() {
        Printer.inputMessage(TransactionType.EXPENSE);

        float amount = getAmount();
        LocalDateTime dateTime = getDateTime();
        String category = getCategory();
        String type = getType();
        String paymentMethod = getPaymentMethod();
        String additionalInformation = getAdditionalInformation();

        return new Expense(amount, dateTime, category, type, paymentMethod, additionalInformation);
    }

    public Income getEditedIncome(Income income) {
        Printer.editMessage(TransactionType.INCOME);

        float newAmount = editAmount(income.getAmount());
        LocalDate newDate = editDate(income.getDate());
        String newCategory = editCategory(income.getCategory());
        String newType = editType(income.getType());
        boolean newIsBankTransaction = editIsBankTransaction(income.isBankTransaction());
        String newAdditionalInformation = editAdditionalInformation(income.getAdditionalInformation());

        return new Income(income.getId(), newAmount, newDate, newCategory, newType, newIsBankTransaction, newAdditionalInformation);
    }

    public Expense getEditedExpense(Expense expense) {
        Printer.editMessage(TransactionType.EXPENSE);

        float newAmount = editAmount(expense.getAmount());
        LocalDateTime newDateTime = editDateTime(expense.getDateTime());
        String newCategory = editCategory(expense.getCategory());
        String newType = editType(expense.getType());
        String newPaymentMethod = editPaymentMethod(expense.getPaymentMethod());
        String newAdditionalInformation = editAdditionalInformation(expense.getAdditionalInformation());

        return new Expense(expense.getId(), newAmount, newDateTime, newCategory, newType, newPaymentMethod, newAdditionalInformation);
    }

    public String getId(List<String> validIds) {
        while (true) {
            Printer.enterId();
            String inputId = getNextLine();

            for (String id : validIds) {
                if (inputId.equals(id)) {
                    return inputId;
                }
            }

            Printer.wrongId();
        }
    }

    public Transaction getTransaction(List<Transaction> validTransaction) {
        while (true) {
            Printer.enterId();
            String inputId = getNextLine();

            for (Transaction transaction : validTransaction) {
                if (transaction.getId().equals(inputId)) {
                    return transaction;
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
            String inputAmount = getNextLine();
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
            String inputDate = getNextLine();

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
            String inputDateTime = getNextLine();

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
        return getNextLine();
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
        return getNextLine();
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
        return getNextLine();
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
        String inputIsBankTransaction = getNextLine().toLowerCase();

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
        return getNextLine();
    }

    private String editPaymentMethod(String oldPaymentMethod) {
        Printer.currentPaymentMethod(oldPaymentMethod);
        boolean editField = editField();
        if (editField) {
            return getPaymentMethod();
        }
        return oldPaymentMethod;
    }

    private String getNextLine() {
        return sc.nextLine().trim();
    }
}
