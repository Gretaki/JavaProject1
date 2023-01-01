import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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

    public static ArrayList<Transaction> getData(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Transaction> result = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] elements = line.split(",");

            try {
                float amount = Float.parseFloat(elements[1]);
                String category = elements[2];
                LocalDate date = LocalDate.parse(elements[3]);

                Transaction transaction = null;
                if (elements[0].equals("I")) {
                    transaction = new Income(amount, date, category);
                } else if (elements[0].equals("E")) {
                    transaction = new Expense(amount, date, category);
                }
                result.add(transaction);
            } catch (NumberFormatException | NullPointerException | DateTimeParseException ignored) {
            }
        }
        br.close();
        return result;
    }
}
