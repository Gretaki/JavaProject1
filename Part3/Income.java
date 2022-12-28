import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Income extends Transaction {
    private boolean isBankTransaction;

    public Income(String id, float amount, LocalDate date, String category, String type, boolean isBankTransaction, String additionalInformation) {
        super(id, amount, date, category, type, additionalInformation);
        this.isBankTransaction = isBankTransaction;
    }

    public Income(float amount, LocalDate date, String category, String type, boolean isBankTransaction, String additionalInformation) {
        super(amount, date, category, type, additionalInformation);
        this.isBankTransaction = isBankTransaction;
    }
    
    public boolean isBankTransaction() {
        return isBankTransaction;
    }

    @Override
    public String toString() {
        return String.format("{id=%s, amount=%.2f, date=%s, category=%s, type=%s, isBankTransaction=%b, additionalInformation=%s}",
            super.getId(), super.getAmount(), super.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            super.getCategory(), super.getType(), isBankTransaction, super.getAdditionalInformation());
    }
}
