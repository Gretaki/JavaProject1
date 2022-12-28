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

    public LocalDate getDate() {
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

    public LocalDateTime getDateTime() {
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

    public String getCategory() {
        Printer.enterCategory();
        String inputCategory = sc.nextLine().trim();

        if (inputCategory.equals("-")) {
            return null;
        }
        return inputCategory;
    }

    public String getAdditionalInformation() {
        Printer.enterAdditionalInformation();
        String inputAdditionalInformation = sc.nextLine().trim();

        if (inputAdditionalInformation.equals("-")) {
            return null;
        }
        return inputAdditionalInformation;
    }

    public boolean getIsBankTransaction() {
        Printer.enterIsBankTransaction();
        String inputIsBankTransaction = sc.nextLine().trim().toLowerCase();

        return inputIsBankTransaction.equals("yes") || inputIsBankTransaction.equals("true")
            || inputIsBankTransaction.equals("y") || inputIsBankTransaction.equals("taip")
            || inputIsBankTransaction.equals("t") || inputIsBankTransaction.equals("+");
    }

    public String getPaymentMethod() {
        Printer.enterPaymentMethod();
        String inputPaymentMethod = sc.nextLine().trim();

        if (inputPaymentMethod.equals("-")) {
            return null;
        }
        return inputPaymentMethod;
    }

    public String getId() {
        while (true) {
            Printer.enterId();
            String inputId = sc.nextLine().trim();

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
}
