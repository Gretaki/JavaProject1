import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Income {
    private final String id = UUID.randomUUID().toString();
    private final float amount;
    private final LocalDate date;
    private final String category;
    private final boolean isBankTransaction;
    private final String additionalInformation;

    public Income(float amount, LocalDate date, String category, boolean isBankTransaction, String additionalInformation) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.isBankTransaction = isBankTransaction;
        this.additionalInformation = additionalInformation;
    }

    public String getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("{id=%s, amount=%.2f, date=%s, category=%s, isBankTransaction=%b, additionalInformation=%s}",
            id, amount, date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            category, isBankTransaction, additionalInformation);
    }
}
