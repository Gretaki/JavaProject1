import java.time.LocalDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id.equals(that.id);
    }
}
