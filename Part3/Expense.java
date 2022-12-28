import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense extends Transaction {
    private final LocalDateTime dateTime;
    private final String category;
    private final String type;
    private final String paymentMethod;

    public Expense(float amount, LocalDateTime dateTime, String category, String type, String paymentMethod, String additionalInformation) {
        super(amount, dateTime.toLocalDate(), additionalInformation);
        this.dateTime = dateTime;
        this.category = category;
        this.type = type;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return String.format("{id=%s, amount=%.2f, dateTime=%s, category=%s, type=%s, paymentMethod=%s, additionalInformation=%s}",
            super.getId(), super.getAmount(), dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
            category, type, paymentMethod, super.getAdditionalInformation());
    }
}
