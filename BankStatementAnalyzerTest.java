import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankStatementAnalyzerTest {

    @Test
    public void testTotalProfitLossCalculation() {
        List<Transaction> transactions = List.of(
                new Transaction("01-01-2022", 1000, "Income"),
                new Transaction("01-02-2022", -500, "Expense")
        );
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer(transactions);
        assertEquals(500.0, analyzer.calculateTotalProfitOrLoss());
    }

    @Test
    public void testCountTransactionsInSpecificMonth() {
        List<Transaction> transactions = List.of(
                new Transaction("01-01-2022", -100, "Expense"),
                new Transaction("15-01-2022", -200, "Expense"),
                new Transaction("01-02-2022", 600, "Income")
        );
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer(transactions);
        assertEquals(2, analyzer.countTransactionsInMonth("01"));
    }

    @Test
    public void testTop10ExpensesWithFewerTransactions() {
        List<Transaction> transactions = List.of(
                new Transaction("01-01-2022", -100, "Expense1"),
                new Transaction("05-01-2022", -200, "Expense2")
        );
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer(transactions);
        assertEquals(2, analyzer.getTop10Expenses().size());
    }

    @Test
    public void testMostSpentCategoryWithMultipleExpenses() {
        List<Transaction> transactions = List.of(
                new Transaction("01-01-2022", -100, "Food"),
                new Transaction("01-01-2022", -200, "Transport"),
                new Transaction("01-01-2022", -50, "Food")
        );
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer(transactions);
        assertEquals("Food", analyzer.mostSpentCategory());
    }

    @Test
    public void testMostSpentCategoryWithNoExpenses() {
        List<Transaction> transactions = List.of(
                new Transaction("01-01-2022", 1000, "Income")
        );
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer(transactions);
        assertEquals("No expenses found", analyzer.mostSpentCategory());
    }

    @Test
    public void testTotalProfitLossWithOnlyExpenses() {
        List<Transaction> transactions = List.of(
                new Transaction("01-01-2022", -500, "Expense1"),
                new Transaction("02-01-2022", -300, "Expense2")
        );
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer(transactions);
        assertEquals(-800.0, analyzer.calculateTotalProfitOrLoss());
    }

}

