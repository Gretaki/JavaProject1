import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense extends Transaction {
    private final LocalDateTime dateTime;
    private final String paymentMethod;

    public Expense(String id, float amount, LocalDateTime dateTime, String category, String type, String paymentMethod, String additionalInformation) {
        super(id, amount, dateTime.toLocalDate(), category, type, additionalInformation);
        this.dateTime = dateTime;
        this.paymentMethod = paymentMethod;
    }

    public Expense(float amount, LocalDateTime dateTime, String category, String type, String paymentMethod, String additionalInformation) {
        super(amount, dateTime.toLocalDate(), category, type, additionalInformation);
        this.dateTime = dateTime;
        this.paymentMethod = paymentMethod;
    }

    public Expense(float amount, LocalDate date, String category) {
        super(amount, date, category);
        this.dateTime = date.atStartOfDay();
        this.paymentMethod = null;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return String.format("{id=%s, amount=%.2f, dateTime=%s, category=%s, type=%s, paymentMethod=%s, additionalInformation=%s}",
            super.getId(), super.getAmount(), dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
            super.getCategory(), super.getType(), paymentMethod, super.getAdditionalInformation());
    }
}
