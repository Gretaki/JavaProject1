import java.time.LocalDate;

public class Income {
    float amount;
    LocalDate date;
    String category;
    boolean isBankTransaction;
    String additionalInformation;

    public Income(float amount, LocalDate date, String category, boolean isBankTransaction, String additionalInformation) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.isBankTransaction = isBankTransaction;
        this.additionalInformation = additionalInformation;
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
