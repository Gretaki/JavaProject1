public enum TransactionType {
    INCOME("income"),
    EXPENSE("expense");

    public final String name;

    TransactionType(String name) {
        this.name = name;
    }
}
