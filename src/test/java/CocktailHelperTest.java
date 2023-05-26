import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;
import org.junit.jupiter.api.AfterEach;
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

    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1";

    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    static CocktailHelper cocktailHelper;

    @BeforeAll
    public static void setUp() throws IOException {
        System.setOut(new PrintStream(outputStreamCaptor));
        cocktailHelper = mock(CocktailHelper.class);
    }

    @AfterEach
    public void reset() {
        outputStreamCaptor.reset();
        Mockito.reset(cocktailHelper);
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
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/random.php"));

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
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }

    @Test
    public void testGetCocktailByName() throws IOException{

        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"drinks\":[{\"idDrink\":\"11007\",\"strDrink\":\"Margarita\",\"strDrinkAlternate\":null,\"strTags\":\"IBA,ContemporaryClassic\",\"strVideo\":null,\"strCategory\":\"Ordinary Drink\",\"strIBA\":\"Contemporary Classics\",\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Cocktail glass\",\"strInstructions\":\"Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Reiben Sie den Rand des Glases mit der Limettenscheibe, damit das Salz daran haftet. Achten Sie darauf, dass nur der \\u00e4u\\u00dfere Rand angefeuchtet wird und streuen Sie das Salz darauf. Das Salz sollte sich auf den Lippen des Genie\\u00dfers befinden und niemals in den Cocktail einmischen. Die anderen Zutaten mit Eis sch\\u00fctteln und vorsichtig in das Glas geben.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Strofina il bordo del bicchiere con la fetta di lime per far aderire il sale.\\r\\nAvere cura di inumidire solo il bordo esterno e cospargere di sale.\\r\\nIl sale dovrebbe presentarsi alle labbra del bevitore e non mescolarsi mai al cocktail.\\r\\nShakerare gli altri ingredienti con ghiaccio, quindi versarli delicatamente nel bicchiere.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/5noda61589575158.jpg\",\"strIngredient1\":\"Tequila\",\"strIngredient2\":\"Triple sec\",\"strIngredient3\":\"Lime juice\",\"strIngredient4\":\"Salt\",\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1 1\\/2 oz \",\"strMeasure2\":\"1\\/2 oz \",\"strMeasure3\":\"1 oz \",\"strMeasure4\":null,\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":\"https:\\/\\/commons.wikimedia.org\\/wiki\\/File:Klassiche_Margarita.jpg\",\"strImageAttribution\":\"Cocktailmarler\",\"strCreativeCommonsConfirmed\":\"Yes\",\"dateModified\":\"2015-08-18 14:42:59\"},{\"idDrink\":\"11118\",\"strDrink\":\"Blue Margarita\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Ordinary Drink\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Cocktail glass\",\"strInstructions\":\"Rub rim of cocktail glass with lime juice. Dip rim in coarse salt. Shake tequila, blue curacao, and lime juice with ice, strain into the salt-rimmed glass, and serve.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Den Rand des Cocktailglases mit Limettensaft einreiben. Den Rand in grobes Salz tauchen. Tequila, blauen Curacao und Limettensaft mit Eis sch\\u00fctteln, in das mit Salz umh\\u00fcllte Glas abseihen und servieren.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Strofinare il bordo del bicchiere da cocktail con succo di lime. Immergere il bordo nel sale grosso. Shakerare tequila, blue curacao e succo di lime con ghiaccio, filtrare nel bicchiere bordato di sale e servire.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/bry4qh1582751040.jpg\",\"strIngredient1\":\"Tequila\",\"strIngredient2\":\"Blue Curacao\",\"strIngredient3\":\"Lime juice\",\"strIngredient4\":\"Salt\",\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1 1\\/2 oz \",\"strMeasure2\":\"1 oz \",\"strMeasure3\":\"1 oz \",\"strMeasure4\":\"Coarse \",\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"Yes\",\"dateModified\":\"2015-08-18 14:51:53\"},{\"idDrink\":\"17216\",\"strDrink\":\"Tommy's Margarita\",\"strDrinkAlternate\":null,\"strTags\":\"IBA,NewEra\",\"strVideo\":null,\"strCategory\":\"Ordinary Drink\",\"strIBA\":\"New Era Drinks\",\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Old-Fashioned glass\",\"strInstructions\":\"Shake and strain into a chilled cocktail glass.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Sch\\u00fctteln und in ein gek\\u00fchltes Cocktailglas abseihen.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Shakerare e filtrare in una coppetta da cocktail ghiacciata.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/loezxn1504373874.jpg\",\"strIngredient1\":\"Tequila\",\"strIngredient2\":\"Lime Juice\",\"strIngredient3\":\"Agave syrup\",\"strIngredient4\":null,\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"4.5 cl\",\"strMeasure2\":\"1.5 cl\",\"strMeasure3\":\"2 spoons\",\"strMeasure4\":null,\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2017-09-02 18:37:54\"},{\"idDrink\":\"16158\",\"strDrink\":\"Whitecap Margarita\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Other \\/ Unknown\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Margarita\\/Coupette glass\",\"strInstructions\":\"Place all ingredients in a blender and blend until smooth. This makes one drink.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Alle Zutaten in einen Mixer geben und mischen.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Metti tutti gli ingredienti in un frullatore e frulla fino a che non diventa liscio.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/srpxxp1441209622.jpg\",\"strIngredient1\":\"Ice\",\"strIngredient2\":\"Tequila\",\"strIngredient3\":\"Cream of coconut\",\"strIngredient4\":\"Lime juice\",\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1 cup \",\"strMeasure2\":\"2 oz \",\"strMeasure3\":\"1\\/4 cup \",\"strMeasure4\":\"3 tblsp fresh \",\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2015-09-02 17:00:22\"},{\"idDrink\":\"12322\",\"strDrink\":\"Strawberry Margarita\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Ordinary Drink\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Cocktail glass\",\"strInstructions\":\"Rub rim of cocktail glass with lemon juice and dip rim in salt. Shake schnapps, tequila, triple sec, lemon juice, and strawberries with ice, strain into the salt-rimmed glass, and serve.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Cocktailglasrand mit Zitronensaft und Tauchrand in Salz wenden. Schnaps, Tequila, Triple-Sec, Zitronensaft und Erdbeeren mit Eis sch\\u00fctteln, in das salzige Glas sieben und servieren.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Strofinare il bordo del bicchiere da cocktail con succo di limone e immergerlo nel sale. Shakerare grappa, tequila, triple sec, succo di limone e fragole con ghiaccio, filtrare nel bicchiere bordato di sale e servire.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/tqyrpw1439905311.jpg\",\"strIngredient1\":\"Strawberry schnapps\",\"strIngredient2\":\"Tequila\",\"strIngredient3\":\"Triple sec\",\"strIngredient4\":\"Lemon juice\",\"strIngredient5\":\"Strawberries\",\"strIngredient6\":\"Salt\",\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1\\/2 oz \",\"strMeasure2\":\"1 oz \",\"strMeasure3\":\"1\\/2 oz \",\"strMeasure4\":\"1 oz \",\"strMeasure5\":\"1 oz \",\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2015-08-18 14:41:51\"},{\"idDrink\":\"178332\",\"strDrink\":\"Smashed Watermelon Margarita\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Cocktail\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Collins glass\",\"strInstructions\":\"In a mason jar muddle the watermelon and 5 mint leaves together into a puree and strain. Next add the grapefruit juice, juice of half a lime and the tequila as well as some ice. Put a lid on the jar and shake. Pour into a glass and add more ice. Garnish with fresh mint and a small slice of watermelon.\",\"strInstructionsES\":null,\"strInstructionsDE\":null,\"strInstructionsFR\":null,\"strInstructionsIT\":\"In un barattolo di vetro pestare l'anguria e 5 foglie di menta insieme, filtrare il contenuto in un bicchiere. Quindi aggiungere il succo di pompelmo, il succo di mezzo lime, la tequila e un po 'di ghiaccio. Metti un coperchio sul barattolo e agita. Versare in un bicchiere e aggiungere altro ghiaccio. Guarnire con menta fresca e una fettina di anguria.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/dztcv51598717861.jpg\",\"strIngredient1\":\"Watermelon\",\"strIngredient2\":\"Mint\",\"strIngredient3\":\"Grapefruit Juice\",\"strIngredient4\":\"Lime\",\"strIngredient5\":\"Tequila\",\"strIngredient6\":\"Watermelon\",\"strIngredient7\":\"Mint\",\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1\\/2 cup\",\"strMeasure2\":\"5\",\"strMeasure3\":\"1\\/3 Cup\",\"strMeasure4\":\"Juice of 1\\/2\",\"strMeasure5\":\"1 shot\",\"strMeasure6\":\"Garnish with\",\"strMeasure7\":\"Garnish with\",\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":null}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.getCocktailByName("margarita");

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/search.php?s=margarita"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "Cocktail Details :\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  Id     |  Name       |  Category             |  IsAlcholic      |  Glass Type           |\n" +
                "|  11007  |  Margarita  |  ORDINARY_DRINK       |  ALCOHOLIC       |  COCKTAIL_GLASS       |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Instructions : \n" +
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Thumbnail URL : https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }

    @Test
    public void testGetCocktailById() throws IOException {

        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"drinks\":[{\"idDrink\":\"11007\",\"strDrink\":\"Margarita\",\"strDrinkAlternate\":null,\"strTags\":\"IBA,ContemporaryClassic\",\"strVideo\":null,\"strCategory\":\"Ordinary Drink\",\"strIBA\":\"Contemporary Classics\",\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Cocktail glass\",\"strInstructions\":\"Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"Reiben Sie den Rand des Glases mit der Limettenscheibe, damit das Salz daran haftet. Achten Sie darauf, dass nur der \\u00e4u\\u00dfere Rand angefeuchtet wird und streuen Sie das Salz darauf. Das Salz sollte sich auf den Lippen des Genie\\u00dfers befinden und niemals in den Cocktail einmischen. Die anderen Zutaten mit Eis sch\\u00fctteln und vorsichtig in das Glas geben.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Strofina il bordo del bicchiere con la fetta di lime per far aderire il sale.\\r\\nAvere cura di inumidire solo il bordo esterno e cospargere di sale.\\r\\nIl sale dovrebbe presentarsi alle labbra del bevitore e non mescolarsi mai al cocktail.\\r\\nShakerare gli altri ingredienti con ghiaccio, quindi versarli delicatamente nel bicchiere.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/5noda61589575158.jpg\",\"strIngredient1\":\"Tequila\",\"strIngredient2\":\"Triple sec\",\"strIngredient3\":\"Lime juice\",\"strIngredient4\":\"Salt\",\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1 1\\/2 oz \",\"strMeasure2\":\"1\\/2 oz \",\"strMeasure3\":\"1 oz \",\"strMeasure4\":null,\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":\"https:\\/\\/commons.wikimedia.org\\/wiki\\/File:Klassiche_Margarita.jpg\",\"strImageAttribution\":\"Cocktailmarler\",\"strCreativeCommonsConfirmed\":\"Yes\",\"dateModified\":\"2015-08-18 14:42:59\"}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.getCocktailById("11007");

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/lookup.php?i=11007"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "Cocktail Details :\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  Id     |  Name       |  Category             |  IsAlcholic      |  Glass Type           |\n" +
                "|  11007  |  Margarita  |  ORDINARY_DRINK       |  ALCOHOLIC       |  COCKTAIL_GLASS       |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Instructions : \n" +
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Thumbnail URL : https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }

    @Test
    public void testSearchCocktailByIngredients() throws IOException {

        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"drinks\":[{\"strDrink\":\"3-Mile Long Island Iced Tea\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/rrtssw1472668972.jpg\",\"idDrink\":\"15300\"},{\"strDrink\":\"69 Special\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/vqyxqx1472669095.jpg\",\"idDrink\":\"13940\"},{\"strDrink\":\"A1\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/2x8thr1504816928.jpg\",\"idDrink\":\"17222\"},{\"strDrink\":\"Abbey Cocktail\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/mr30ob1582479875.jpg\",\"idDrink\":\"17834\"}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=Gin";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.searchCocktailByIngredients("Gin");

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/filter.php?i=Gin"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "Cocktails having the ingredient - Gin :\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  Id     |  Name                         |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  15300  |  3-Mile Long Island Iced Tea  |\n" +
                "|  13940  |  69 Special                   |\n" +
                "|  17222  |  A1                           |\n" +
                "|  17834  |  Abbey Cocktail               |\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());

    }

    @Test
    public void testFilterCocktailByAlcoholicFilter() throws IOException {

        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"drinks\":[{\"strDrink\":\"1-900-FUK-MEUP\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/uxywyw1468877224.jpg\",\"idDrink\":\"15395\"},{\"strDrink\":\"110 in the shade\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/xxyywq1454511117.jpg\",\"idDrink\":\"15423\"},{\"strDrink\":\"151 Florida Bushwacker\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/rvwrvv1468877323.jpg\",\"idDrink\":\"14588\"}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=ALCOHOLIC";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.filterCocktailByAlcoholicFilter(AlcoholicFilter.ALCOHOLIC);

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/filter.php?a=ALCOHOLIC"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "----------------------------------------------------------------------------------------------------\n" +
                "|  Id     |  Name                    |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  15395  |  1-900-FUK-MEUP          |\n" +
                "|  15423  |  110 in the shade        |\n" +
                "|  14588  |  151 Florida Bushwacker  |\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }

    @Test
    public void testFilterCocktailByCategory() throws IOException {
        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"drinks\":[{\"strDrink\":\"110 in the shade\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/xxyywq1454511117.jpg\",\"idDrink\":\"15423\"},{\"strDrink\":\"Black & Tan\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/rwpswp1454511017.jpg\",\"idDrink\":\"13282\"},{\"strDrink\":\"Black and Brown\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/wwuvxv1472668899.jpg\",\"idDrink\":\"16403\"},{\"strDrink\":\"Buccaneer\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/upvtyt1441249023.jpg\",\"idDrink\":\"17035\"},{\"strDrink\":\"Campari Beer\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/xsqrup1441249130.jpg\",\"idDrink\":\"16047\"},{\"strDrink\":\"Caribbean Boilermaker\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/svsxsv1454511666.jpg\",\"idDrink\":\"17065\"},{\"strDrink\":\"Diesel\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/sxrrqq1454512852.jpg\",\"idDrink\":\"13128\"},{\"strDrink\":\"Green Goblin\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/qxprxr1454511520.jpg\",\"idDrink\":\"13497\"},{\"strDrink\":\"Irish Russian\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/swqurw1454512730.jpg\",\"idDrink\":\"17015\"},{\"strDrink\":\"Limona Corona\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/wwqrsw1441248662.jpg\",\"idDrink\":\"15086\"},{\"strDrink\":\"Lunch Box\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/qywpvt1454512546.jpg\",\"idDrink\":\"14378\"},{\"strDrink\":\"Snake Bite (UK)\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/xuwpyu1441248734.jpg\",\"idDrink\":\"13389\"},{\"strDrink\":\"Snakebite and Black\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/rssvwv1441248863.jpg\",\"idDrink\":\"15789\"},{\"strDrink\":\"Winter Rita\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/fwpd0v1614006733.jpg\",\"idDrink\":\"178347\"}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=BEER";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.filterCocktailByCategory(Category.BEER);

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/filter.php?c=BEER"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "----------------------------------------------------------------------------------------------------\n" +
                "|  Id      |  Name                   |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  15423   |  110 in the shade       |\n" +
                "|  13282   |  Black & Tan            |\n" +
                "|  16403   |  Black and Brown        |\n" +
                "|  17035   |  Buccaneer              |\n" +
                "|  16047   |  Campari Beer           |\n" +
                "|  17065   |  Caribbean Boilermaker  |\n" +
                "|  13128   |  Diesel                 |\n" +
                "|  13497   |  Green Goblin           |\n" +
                "|  17015   |  Irish Russian          |\n" +
                "|  15086   |  Limona Corona          |\n" +
                "|  14378   |  Lunch Box              |\n" +
                "|  13389   |  Snake Bite (UK)        |\n" +
                "|  15789   |  Snakebite and Black    |\n" +
                "|  178347  |  Winter Rita            |\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }

    @Test
    public void testFilterCocktailByGlass() throws IOException {
        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"drinks\":[{\"strDrink\":\"Barracuda\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/jwmr1x1504372337.jpg\",\"idDrink\":\"17209\"},{\"strDrink\":\"Bounty Hunter\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/t8bgxl1596018175.jpg\",\"idDrink\":\"178331\"},{\"strDrink\":\"Death in the Afternoon\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/y7s3rh1598719574.jpg\",\"idDrink\":\"178334\"},{\"strDrink\":\"Honey Bee\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/vu8l7t1582475673.jpg\",\"idDrink\":\"178316\"},{\"strDrink\":\"The Philosopher\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/sp8hkp1596017787.jpg\",\"idDrink\":\"178330\"}]}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?g=MARGARITA_GLASS";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.filterCocktailByGlass(GlassType.MARGARITA_GLASS);

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/filter.php?g=MARGARITA_GLASS"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "----------------------------------------------------------------------------------------------------\n" +
                "|  Id      |  Name                    |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  17209   |  Barracuda               |\n" +
                "|  178331  |  Bounty Hunter           |\n" +
                "|  178334  |  Death in the Afternoon  |\n" +
                "|  178316  |  Honey Bee               |\n" +
                "|  178330  |  The Philosopher         |\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }

    @Test
    public void testGetIngredientById() throws IOException {
        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"ingredients\":[{\"idIngredient\":\"552\",\"strIngredient\":\"Elderflower cordial\",\"strDescription\":\"Elderflower cordial is a soft drink made largely from a refined sugar and water solution and uses the flowers of the European elderberry. Historically the cordial has been popular in North Western Europe where it has a strong Victorian heritage.\",\"strType\":\"Cordial\",\"strAlcohol\":\"No\",\"strABV\":null}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?iid=552";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.getIngredientById("552");

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/lookup.php?iid=552"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "Ingredient details are:\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  Id        |  Name                 |  Type     |  Alcohol  |\n" +
                "|  552       |  Elderflower cordial  |  Cordial  |  No       |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Description : \n" +
                "Elderflower cordial is a soft drink made largely from a refined sugar and water solution and uses th...\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }

    @Test
    public void testGetIngredientsByName() throws IOException {
        // Create a partial mock for the CocktailService
        CocktailHelper cocktailServiceMock = spy(CocktailHelper.class);

        // Create a mock response
        String mockResponse = "{\"ingredients\":[{\"idIngredient\":\"552\",\"strIngredient\":\"Elderflower cordial\",\"strDescription\":\"Elderflower cordial is a soft drink made largely from a refined sugar and water solution and uses the flowers of the European elderberry. Historically the cordial has been popular in North Western Europe where it has a strong Victorian heritage.\",\"strType\":\"Cordial\",\"strAlcohol\":\"No\",\"strABV\":null}]}";

        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=elderflower";
        // Mock the sendGetRequest method to return the mock response
        when(cocktailServiceMock.sendGetRequest(apiUrl)).thenReturn(mockResponse);

        // Call the method under test
        cocktailServiceMock.getIngredientsByName("elderflower");

        // Verify that the sendGetRequest method was called with the correct URL
        verify(cocktailServiceMock).sendGetRequest(eq(BASE_URL + "/search.php?i=elderflower"));

        // Verify the behavior indirectly by checking that the sendGetRequest method was called
        verify(cocktailServiceMock).sendGetRequest(anyString());
        String expectedOuput = "Ingredient details are:\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "|  Id        |  Name                 |  Type     |  Alcohol  |\n" +
                "|  552       |  Elderflower cordial  |  Cordial  |  No       |\n" +
                "----------------------------------------------------------------------------------------------------\n" +
                "Description : \n" +
                "Elderflower cordial is a soft drink made largely from a refined sugar and water solution and uses th...\n" +
                "----------------------------------------------------------------------------------------------------";
        assertEquals(expectedOuput, outputStreamCaptor.toString().replaceAll("Connection Opened !!", "").trim());
    }
}
