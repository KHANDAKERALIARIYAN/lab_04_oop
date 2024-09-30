import java.io.File;
import java.util.*;

class XMLParser implements Parser {
    @Override
    public List<Transaction> parse(String filePath) throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        File file = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("transaction");

        for (int i = 0; i < nList.getLength(); i++) {
            String date = doc.getElementsByTagName("date").item(i).getTextContent();
            double amount = Double.parseDouble(doc.getElementsByTagName("amount").item(i).getTextContent());
            String description = doc.getElementsByTagName("description").item(i).getTextContent();
            transactions.add(new Transaction(date, amount, description));
        }

        return transactions;
    }
}