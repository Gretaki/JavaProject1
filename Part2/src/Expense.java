import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Expense {
    private final String id = UUID.randomUUID().toString();
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

    @Override
    public String toString() {
        return String.format("{id=%s, amount=%.2f, dateTime=%s, category=%s, paymentMethod=%s, additionalInformation=%s}",
            id, amount, dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
            category, paymentMethod, additionalInformation);
    }
    
    public String getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }
}
