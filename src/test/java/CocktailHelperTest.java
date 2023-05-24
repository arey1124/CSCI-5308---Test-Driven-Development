import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CocktailHelperTest {

    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    static CocktailHelper cocktailHelper;

    @BeforeAll
    public static void setUp() throws IOException {
        System.setOut(new PrintStream(outputStreamCaptor));
        cocktailHelper = mock(CocktailHelper.class);
    }
    @Test
    public void testSendGetRequest() throws IOException {
        // Create a mock HttpURLConnection
        HttpURLConnection connection = mock(HttpURLConnection.class);

        // Define the expected URL and response
        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=13497";
        String expectedResponse = "{\"drinks\":[{\"idDrink\":\"13497\",\"strDrink\":\"Green Goblin\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Beer\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Pint glass\",\"strInstructions\":\"Cider First, Lager then Curacao\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Zuerst Apfelwein, dann Lager und Curacao.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Sidro prima, Lager poi Curacao\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/qxprxr1454511520.jpg\",\"strIngredient1\":\"Cider\",\"strIngredient2\":\"Lager\",\"strIngredient3\":\"Blue Curacao\",\"strIngredient4\":null,\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1\\/2 pint hard \",\"strMeasure2\":\"1\\/2 pint \",\"strMeasure3\":\"1 shot \",\"strMeasure4\":null,\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2016-02-03 14:58:40\"}]}";

        when(cocktailHelper.sendGetRequest(apiUrl)).thenReturn("{\"drinks\":[{\"idDrink\":\"13497\",\"strDrink\":\"Green Goblin\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Beer\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Pint glass\",\"strInstructions\":\"Cider First, Lager then Curacao\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Zuerst Apfelwein, dann Lager und Curacao.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Sidro prima, Lager poi Curacao\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/qxprxr1454511520.jpg\",\"strIngredient1\":\"Cider\",\"strIngredient2\":\"Lager\",\"strIngredient3\":\"Blue Curacao\",\"strIngredient4\":null,\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1\\/2 pint hard \",\"strMeasure2\":\"1\\/2 pint \",\"strMeasure3\":\"1 shot \",\"strMeasure4\":null,\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2016-02-03 14:58:40\"}]}");

        // Mock the HttpURLConnection behavior
        when(connection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(expectedResponse.getBytes()));

        // Call the method to be tested
        String actualResponse = cocktailHelper.sendGetRequest(apiUrl);

        // Verify the result
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testFetchRandomCocktail() throws IOException {
        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"drinks\":[{\"idDrink\":\"13497\",\"strDrink\":\"Green Goblin\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Beer\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Pint glass\",\"strInstructions\":\"Cider First, Lager then Curacao\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Zuerst Apfelwein, dann Lager und Curacao.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Sidro prima, Lager poi Curacao\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/qxprxr1454511520.jpg\",\"strIngredient1\":\"Cider\",\"strIngredient2\":\"Lager\",\"strIngredient3\":\"Blue Curacao\",\"strIngredient4\":null,\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1\\/2 pint hard \",\"strMeasure2\":\"1\\/2 pint \",\"strMeasure3\":\"1 shot \",\"strMeasure4\":null,\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2016-02-03 14:58:40\"}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.fetchRandomCocktail();

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(CocktailHelper.BASE_URL + "/random.php"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "----------------------------------------------------------------------------------------------------\n" +
                "|  Id     |  Name          |  Category   |  IsAlcholic      |  Glass Type       |\n" +
                "|  13497  |  Green Goblin  |  BEER       |  ALCOHOLIC       |  PINT_GLASS       |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Instructions : \n" +
                "Cider First, Lager then Curacao\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Thumbnail URL : https://www.thecocktaildb.com/images/media/drink/qxprxr1454511520.jpg\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testGetCocktailByName() {

    }

    @Test
    public void testGetCocktailById() {

    }

    @Test
    public void testSearchCocktailByIngredients() {

    }

    @Test
    public void testFilterCocktailByAlcoholicFilter() {

    }

    @Test
    public void testFilterCocktailByCategory() {

    }

    @Test
    public void testFilterCocktailByGlass() {

    }

    @Test
    public void testGetIngredientById() {

    }

    @Test
    public void testGetIngredientsByName() {

    }
}
