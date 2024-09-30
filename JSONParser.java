import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.util.*;
class JSONParser implements Parser {
    @Override
    public List<Transaction> parse(String filePath) throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonArray = new JSONArray(content);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            transactions.add(new Transaction(jsonObject.getString("date"),
                    ((JSONObject) jsonObject).getDouble("amount"),
                    jsonObject.getString("description")));
        }
        return transactions;
    }
}
