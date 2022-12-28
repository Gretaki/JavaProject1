import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Income extends Transaction {
    private final String category;
    private final String type;
    private final boolean isBankTransaction;

    public Income(float amount, LocalDate date, String category, String type, boolean isBankTransaction, String additionalInformation) {
        super(amount, date, additionalInformation);
        this.category = category;
        this.type = type;
        this.isBankTransaction = isBankTransaction;
    }

    @Override
    public String toString() {
        return String.format("{id=%s, amount=%.2f, date=%s, category=%s, type=%s, isBankTransaction=%b, additionalInformation=%s}",
            super.getId(), super.getAmount(), super.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            category, type, isBankTransaction, super.getAdditionalInformation());
    }
}
