import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.ConnectException;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DBConnectorTest {

    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void validate() {
        outputStreamCaptor.reset();
    }

    @Test
    public void openConnectionTest() throws ConnectException {

        DBConnector connector = null;
        try {
            connector = new DBConnector();
            String expectedOutput = "Connection Opened !!";

            // Verifying that the expected output is achieved
            Assertions.assertTrue(connector.openConnection(),"Connection Successful" );
            assertEquals(true, outputStreamCaptor.toString().equals(expectedOutput));
        } catch (ConnectException e) {
            Assertions.assertFalse(connector.openConnection(),"Connection Failed");
            throw new ConnectException("\"Connection Failed\"");
        }
    }

    @Test
    public void closeConnectionTest() {
        DBConnector connector = new DBConnector();
        String expectedOutput = "Connection Closed !!";

        // Verifying that the expected output is achieved
        Assertions.assertTrue(connector.closeConnection(),"Connection Closed" );
        assertEquals(true, outputStreamCaptor.toString().equals(expectedOutput));
    }

    @Test
    public void executeAddCocktailDetailsTest () {
        DBConnector connector = new DBConnector();;

        // Try Adding a value to the DB to see if it is success
        Assertions.assertTrue(connector.executeAddCocktailDetails("1", "Vodka"));
    }

    @Test
    public void executeFindCocktailByIdTest () {
        DBConnector connector = new DBConnector();;

        // Try Adding a value to the DB to see if it is success
        Assertions.assertTrue(connector.executeAddCocktailDetails("1", "Vodka"));

        // Finding a data which was recently added and exists in the database returns the mapped Cocktail name
        Assertions.assertEquals("Vodka", connector.executeFindCocktailById("1"));

        // If no data for the cocktail exists in the database then it returns the error message
        Assertions.assertEquals("No cocktail found with the matching key", connector.executeFindCocktailById("100"));
    }

}
