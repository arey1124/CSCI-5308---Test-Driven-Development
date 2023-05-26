import java.net.ConnectException;
import java.util.HashMap;

public class DBConnector implements IDBConnectorBase {

    private static HashMap<String, String> dbData = new HashMap<>();

    public boolean openConnection() throws ConnectException {
        System.out.print ("Connection Opened !!");
        return true;
    }

    public boolean closeConnection() {
        System.out.print ("Connection Closed !!");
        return true;
    }

    public boolean executeAddCocktailDetails(String id, String name) {
        dbData.put(id, name);
        return true;
    }

    public String executeFindCocktailById (String id) {
        if(dbData.containsKey(id)) {
            return dbData.get(id);
        } else {
            return "No cocktail found with the matching key";
        }
    }
}
