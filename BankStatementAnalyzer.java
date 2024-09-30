import java.nio.channels.AsynchronousFileChannel;
import java.util.*;
import java.util.stream.Collectors;

class BankStatementAnalyzer {
    private List<Transaction> transactions;

    public BankStatementAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double calculateTotalProfitOrLoss() {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public long countTransactionsInMonth(String month) {
        return transactions.stream()
                .filter(t -> t.getDate().contains(month))
                .count();
    }

    public List<Transaction> getTop10Expenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public String mostSpentCategory() {
        Map<String, Double> spendingByCategory = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(
                        Transaction::getDescription,
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        return spendingByCategory.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No expenses found");
    }

}
