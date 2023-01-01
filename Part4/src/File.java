import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class File {

    public static void saveData(ArrayList<Transaction> transactions) throws IOException {
        String filePath = String.format("outputFiles/Transactions - %s.csv", LocalDate.now());
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

        String header = "Transaction Type,ID,Amount,Category,Date\n";
        bw.write(header);

        for (Transaction transaction : transactions) {
            String line = null;
            if (transaction.getClass().equals(Income.class)) {
                line = "I,";
            } else if (transaction.getClass().equals(Expense.class)) {
                line = "E,";
            }
            line += String.join(",", transaction.getValuesAsString()) + "\n";
            bw.write(Objects.requireNonNull(line));
        }

        bw.close();
    }

    public static List<Transaction> readTransactions(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        List<Transaction> result = br.lines().map(File::parseTransaction).filter(Objects::nonNull).toList();
        br.close();
        return result;
    }

    private static Transaction parseTransaction(String line) {
        String[] elements = line.split(",");

        try {
            float amount = Float.parseFloat(elements[1]);
            String category = elements[2];
            LocalDate date = LocalDate.parse(elements[3]);

            if (elements[0].equals("I")) {
                return new Income(amount, date, category);
            } else if (elements[0].equals("E")) {
                return new Expense(amount, date, category);
            } else return null;
        } catch (NumberFormatException | NullPointerException | DateTimeParseException ignored) {
            Printer.failedToParseTransactions(line);
            return null;
        }
    }
}
