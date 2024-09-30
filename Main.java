import java.io.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("30-01-2017", -100, "Deliveroo"),
                new Transaction("30-01-2017", -50, "Tesco"),
                new Transaction("01-02-2017", 6000, "Salary"),
                new Transaction("02-02-2017", -2000, "Rent"),
                new Transaction("02-02-2017", -150, "Gym")
        );

        BankStatementAnalyzer analyzer = new BankStatementAnalyzer(transactions);

        System.out.println("Total Profit/Loss: " + analyzer.calculateTotalProfitOrLoss());
        System.out.println("Number of Transactions in January: " + analyzer.countTransactionsInMonth("01"));
        System.out.println("Top 10 Expenses: " + analyzer.getTop10Expenses());
        System.out.println("Most Spent Category: " + analyzer.mostSpentCategory());

//        try {
//            String fileType = "json";
//            String filePath = "transactions.json";
//
//            Parser parser = ParserFactory.getParser(fileType);
//            BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
//
//            analyzer.loadTransactions(parser, filePath);
//
//            System.out.println("Total Profit/Loss: " + analyzer.calculateTotalProfitOrLoss());
//            System.out.println("Transactions in February: " + analyzer.countTransactionsInMonth("02-2017").size());
//            System.out.println("Top 10 Expenses: " + analyzer.getTop10Expenses());
//            System.out.println("Spending by Category: " + analyzer.mostSpentCategory());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}


