import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputProcessor {
    private final Scanner sc;

    public InputProcessor(Scanner sc) {
        this.sc = sc;
    }

    public float getAmount() {
        float amount = 0;
        while (amount == 0) {
            Printer.enterAmount();
            String inputAmount = sc.nextLine().trim();
            try {
                amount = Float.parseFloat(inputAmount);
            } catch (NumberFormatException e) {
                Printer.wrongNumberFormat();
            } catch (NullPointerException e) {
                Printer.noAmountField();
            }
        }
        return amount;
    }

    public LocalDate getDate() {
        LocalDate date = null;
        while (date == null) {
            Printer.enterDate();
            String inputDate = sc.nextLine().trim();

            if (inputDate.equals("now")) {
                date = LocalDate.now();
                break;
            }

            try {
                date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                Printer.wrongDateFormat();
            }
        }
        return date;
    }

    public LocalDateTime getDateTime() {
        LocalDateTime dateTime = null;
        while (dateTime == null) {
            Printer.enterDateTime();
            String inputDateTime = sc.nextLine().trim();

            if (inputDateTime.equals("now")) {
                LocalDateTime now = LocalDateTime.now();
                dateTime = LocalDateTime.of(now.toLocalDate(), LocalTime.of(now.getHour(), now.getMinute(), 0, 0));
                break;
            }

            try {
                dateTime = LocalDateTime.parse(inputDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            } catch (DateTimeParseException e) {
                Printer.wrongDateTimeFormat();
            }
        }
        return dateTime;
    }

    public String getCategory() {
        String category = null;
        while (category == null) {
            Printer.enterCategory();
            String inputCategory = sc.nextLine().trim();

            if (inputCategory.equals("-")) {
                break;
            }
            category = inputCategory;
        }
        return category;
    }

    public String getAdditionalInformation() {
        String additionalInformation = null;
        while (additionalInformation == null) {
            Printer.enterAdditionalInformation();
            String inputAdditionalInformation = sc.nextLine().trim();

            if (inputAdditionalInformation.equals("-")) {
                break;
            }
            additionalInformation = inputAdditionalInformation;
        }
        return additionalInformation;
    }

    public boolean getIsBankTransaction() {
        boolean isBankTransaction = false;
        Printer.enterIsBankTransaction();
        String inputIsBankTransaction = sc.nextLine().trim().toLowerCase();

        if (inputIsBankTransaction.equals("yes") || inputIsBankTransaction.equals("true")
            || inputIsBankTransaction.equals("y") || inputIsBankTransaction.equals("taip")
            || inputIsBankTransaction.equals("t") || inputIsBankTransaction.equals("+")) {
            isBankTransaction = true;
        }
        return isBankTransaction;
    }

    public String getPaymentMethod() {
        String paymentMethod = null;
        while (paymentMethod == null) {
            Printer.enterPaymentMethod();
            String inputPaymentMethod = sc.nextLine().trim();

            if (inputPaymentMethod.equals("-")) {
                break;
            }
            paymentMethod = inputPaymentMethod;
        }
        return paymentMethod;
    }
}
