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

    public float getAmount() {
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

    public LocalDate getDate() {
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

    public LocalDateTime getDateTime() {
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

    public boolean getIsBankTransaction() {
        Printer.enterIsBankTransaction();
        String inputIsBankTransaction = getNextLine().toLowerCase();

        return inputIsBankTransaction.equals("yes") || inputIsBankTransaction.equals("true")
            || inputIsBankTransaction.equals("y") || inputIsBankTransaction.equals("taip")
            || inputIsBankTransaction.equals("t") || inputIsBankTransaction.equals("+");
    }

    public String getCategory() {
        Printer.enterCategory();
        return getTextInput();
    }

    public String getAdditionalInformation() {
        Printer.enterAdditionalInformation();
        return getTextInput();
    }

    public String getPaymentMethod() {
        Printer.enterPaymentMethod();
        return getTextInput();
    }

    public String getId() {
        while (true) {
            Printer.enterId();
            String inputId = getNextLine();

            for (Income income : budget.getIncomes()) {
                if (income.getId().equals(inputId)) {
                    return inputId;
                }
            }

            for (Expense expense : budget.getExpenses()) {
                if (expense.getId().equals(inputId)) {
                    return inputId;
                }
            }

            Printer.wrongId();
        }
    }

    private String getTextInput() {
        String input = getNextLine();

        if (input.equals("-")) {
            return "";
        }
        return input;
    }
    
    private String getNextLine() {
        return sc.nextLine().trim();
    }
}