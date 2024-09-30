import java.util.*;
interface Parser {
    List<Transaction> parse(String filePath) throws Exception;
}