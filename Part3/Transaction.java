import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Transaction {
    private final String id = UUID.randomUUID().toString();
    private final float amount;
    private final LocalDate date;
    private final String additionalInformation;

    public Transaction(float amount, LocalDate date, String additionalInformation) {
        this.amount = amount;
        this.date = date;
        this.additionalInformation = additionalInformation;
    }

    public String getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }
}
