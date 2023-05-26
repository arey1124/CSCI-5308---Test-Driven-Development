import java.net.ConnectException;

public interface IDBConnectorBase {

    boolean openConnection() throws ConnectException;

    boolean closeConnection();

    boolean executeAddCocktailDetails(String id, String name);

    String executeFindCocktailById (String id);

}
