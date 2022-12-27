import java.time.LocalDateTime;

public class Expense {
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
        return "Expense{" +
            "amount=" + amount +
            ", dateTime=" + dateTime +
            ", category='" + category + '\'' +
            ", paymentMethod='" + paymentMethod + '\'' +
            ", additionalInformation='" + additionalInformation + '\'' +
            '}';
    }
}
