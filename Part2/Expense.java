import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {
    private final float amount;
    private final LocalDateTime dateTime;
    private final String category;
    private final String paymentMethod;
    private final String additionalInformation;

    public Expense(float amount, LocalDateTime dateTime, String category, String paymentMethod, String additionalInformation) {
        this.amount = amount;
        this.dateTime = dateTime;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.additionalInformation = additionalInformation;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Expense: {amount=%.2f, dateTime=%s, category=%s, paymentMethod=%s, additionalInformation=%s}",
            amount, dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
            category, paymentMethod, additionalInformation);
    }
}
