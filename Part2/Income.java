import java.time.LocalDate;

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
        return "Income{" +
            "amount=" + amount +
            ", date=" + date +
            ", category='" + category + '\'' +
            ", isBankTransaction=" + isBankTransaction +
            ", additionalInformation='" + additionalInformation + '\'' +
            '}';
    }
}
