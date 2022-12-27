import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Income {
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

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Income: {amount=%.2f, date=%s, category=%s, isBankTransaction=%b, additionalInformation=%s}",
            amount, date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            category, isBankTransaction, additionalInformation);
    }
}
