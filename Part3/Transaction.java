import java.time.LocalDate;
import java.util.UUID;

public abstract class Transaction {
    private final String id;
    private float amount;
    private final LocalDate date;
    private final String category;
    private final String type;
    private final String additionalInformation;

    public Transaction(String id, float amount, LocalDate date, String category, String type, String additionalInformation) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.type = type;
        this.additionalInformation = additionalInformation;
    }

    public Transaction(float amount, LocalDate date, String category, String type, String additionalInformation) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.type = type;
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

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
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
