import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


class CSVParser implements Parser {
    @Override
    public List<Transaction> parse(String filePath) throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            transactions.add(new Transaction(values[0], Double.parseDouble(values[1]), values[2]));
        }
        br.close();
        return transactions;
    }
}



