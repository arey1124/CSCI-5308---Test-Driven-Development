import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class JSONParserTest {

    @Spy
    private static JSONParser jsonParser;

    @BeforeAll
    public static void SetupBeforeAll() {
        // Set up the behavior of the mock object
        jsonParser = mock(JSONParser.class);
    }

    @Test
    public void testParseCocktailData_ValidData_ReturnsCocktail() {
        // Set up the data for the mock object
        String data = "{\"drinks\":[{\"idDrink\":\"17060\",\"strDrink\":\"24k nightmare\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Shot\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Shot glass\",\"strInstructions\":\"Add over ice,shake and pour.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"\\u00dcber das Eis geben, sch\\u00fctteln und eingiessen.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Aggiungere gli ingredienti dopo aver versato un po\\u2019 di ghiaccio, agitare e versare.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/yyrwty1468877498.jpg\",\"strIngredient1\":\"Goldschlager\",\"strIngredient2\":\"J\\u00e4germeister\",\"strIngredient3\":\"Rumple Minze\",\"strIngredient4\":\"151 proof rum\",\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1\\/2 oz \",\"strMeasure2\":\"1\\/2 oz \",\"strMeasure3\":\"1\\/2 oz \",\"strMeasure4\":\"1\\/2 oz Bacardi \",\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2016-07-18 22:31:38\"}]}";
        Cocktail expectedCocktail = new Cocktail("24k nightmare", "17060");

        // Retrive the result of parsed cocktail data
        Cocktail result = jsonParser.parseCocktailData(data);

        // Assert values to see if the data is correct
        assertEquals(expectedCocktail.getName(), result.getName());
        assertEquals(expectedCocktail.getId(), result.getId());
        assertEquals(Category.SHOT, result.getCategory());
        assertEquals(AlcoholicFilter.ALCOHOLIC, result.getIsAlcoholic());
        assertEquals(GlassType.SHOT_GLASS, result.getGlassType());
        assertEquals("Add over ice,shake and pour.", result.getInstructions());
        assertEquals("https://www.thecocktaildb.com/images/media/drink/yyrwty1468877498.jpg", result.getThumbnail());
    }

    @Test
    public void testParseCocktailData_ValidData_SomeNullValues() {
        // Set up the data for the mock object
        String data = "{\"drinks\":[{\"idDrink\":\"17060\",\"strDrink\":\"24k nightmare\"]}";
        Cocktail expectedCocktail = new Cocktail("24k nightmare", "17060");

        // Retrive the result of parsed cocktail data
        Cocktail result = jsonParser.parseCocktailData(data);

        // Assert values to see if the data is correct
        assertEquals(expectedCocktail.getName(), result.getName());
        assertEquals(expectedCocktail.getId(), result.getId());
        assertEquals(null, result.getCategory());
        assertEquals(null, result.getIsAlcoholic());
        assertEquals(null, result.getGlassType());
        assertEquals(null, result.getInstructions());
        assertEquals(null, result.getThumbnail());
    }

    @Test
    public void testParseCocktailData_InvalidData_ReturnsNull() {
        String data = "{\"drinks\":[{\"idDrink\":\"17060\",\"strDrink\":\"\",\"strDrinkAlternate\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Shot\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Shot glass\",\"strInstructions\":\"Add over ice,shake and pour.\",\"strInstructionsES\":null,\"strInstructionsDE\":\"\\u00dcber das Eis geben, sch\\u00fctteln und eingiessen.\",\"strInstructionsFR\":null,\"strInstructionsIT\":\"Aggiungere gli ingredienti dopo aver versato un po\\u2019 di ghiaccio, agitare e versare.\",\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/yyrwty1468877498.jpg\",\"strIngredient1\":\"Goldschlager\",\"strIngredient2\":\"J\\u00e4germeister\",\"strIngredient3\":\"Rumple Minze\",\"strIngredient4\":\"151 proof rum\",\"strIngredient5\":null,\"strIngredient6\":null,\"strIngredient7\":null,\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"1\\/2 oz \",\"strMeasure2\":\"1\\/2 oz \",\"strMeasure3\":\"1\\/2 oz \",\"strMeasure4\":\"1\\/2 oz Bacardi \",\"strMeasure5\":null,\"strMeasure6\":null,\"strMeasure7\":null,\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"strImageSource\":null,\"strImageAttribution\":null,\"strCreativeCommonsConfirmed\":\"No\",\"dateModified\":\"2016-07-18 22:31:38\"}]}";
        Cocktail expectedCocktail = new Cocktail("24k nightmare", "17060");

        // Retrive the result of parsed cocktail data
        Cocktail result = jsonParser.parseCocktailData(data);

        // Assert
        assertNull(result);

        // Verify that no other methods were called
        verifyNoMoreInteractions(jsonParser);
    }

    @Test
    public void testParseCocktails_ValidData_ReturnsCocktail() {
        // Set up the data for the mock object
        String data = "{\"drinks\":[{\"strDrink\":\"3-Mile Long Island Iced Tea\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/rrtssw1472668972.jpg\",\"idDrink\":\"15300\"},{\"strDrink\":\"69 Special\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/vqyxqx1472669095.jpg\",\"idDrink\":\"13940\"}]}";
        ArrayList<Cocktail> expected = new ArrayList<>();
        expected.add(new Cocktail("3-Mile Long Island Iced Tea","15300"));
        expected.add(new Cocktail("69 Special", "13940"));

        // Retrive the result of parsed cocktail data
        ArrayList<Cocktail> actual = jsonParser.parseCocktails(data);

        // Assert to see if the array size is correct
        assertEquals(expected.size(), actual.size());

        for(int i = 0; i < expected.size(); i++) {
            // Assert values to see if the data is correct
            assertEquals(expected.get(i).getName(), actual.get(i).getName());
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
        }
    }

    @Test
    public void testParseCocktails_InvalidData_ReturnsEmpty() {
        // Set up the data for the mock object
        String data = "{\"drinks\":[]}";
        ArrayList<Cocktail> expected = new ArrayList<>();

        // Retrive the result of parsed cocktail data
        ArrayList<Cocktail> actual = jsonParser.parseCocktails(data);

        // Assert to see if the array size is correct
        assertEquals(expected.size(), actual.size());

        // Assert to see if the returned list is empty
        assertEquals(0, actual.size());
    }

    @Test
    public void testParseIngredientData_ValidData_ReturnsIngredient() {
        // Set up the data for the mock object
        String data = "{\"ingredients\":[{\"idIngredient\":\"552\",\"strIngredient\":\"Elderflower cordial\",\"strDescription\":\"Elderflower cordial is a soft drink made largely from a refined sugar and water solution and uses the flowers of the European elderberry. Historically the cordial has been popular in North Western Europe where it has a strong Victorian heritage.\",\"strType\":\"Cordial\",\"strAlcohol\":\"No\",\"strABV\":\"50\"}]}";
        Ingredient expected = new Ingredient("Elderflower cordial", "552");

        // Retrive the result of parsed ingredient data
        Ingredient actual = jsonParser.parseIngredientData(data);

        // Assert values to see if the data is correct
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getId(), actual.getId());
        assertEquals("Cordial", actual.getType());
        assertEquals("No", actual.getHasAlcohol());
        assertEquals("Elderflower cordial is a soft drink made largely from a refined sugar and water solution and uses the flowers of the European elderberry. Historically the cordial has been popular in North Western Europe where it has a strong Victorian heritage.",
                actual.getDescription());
        assertEquals("50", actual.getAlocholByVolume());
    }

    @Test
    public void testParseIngredientData_ValidData_SomeNullValues() {
        // Set up the data for the mock object
        String data = "{\"ingredients\":[{\"idIngredient\":\"552\",\"strIngredient\":\"Elderflower cordial\"]}";
        Ingredient expected = new Ingredient("Elderflower cordial", "552");

        // Retrive the result of parsed ingredient data
        Ingredient actual = jsonParser.parseIngredientData(data);

        // Assert values to see if the data is correct
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(null, actual.getType());
        assertEquals(null, actual.getHasAlcohol());
        assertEquals(null, actual.getDescription());
        assertEquals(null, actual.getAlocholByVolume());
    }

    @Test
    public void testParseIngredientData_InvalidData_ReturnsNull() {
        // Set up the data for the mock object
        String data = "{\"ingredients\":[{\"idIngredient\":\"552\",\"strIngredient\":\"\",\"strDescription\":\"Elderflower cordial is a soft drink made largely from a refined sugar and water solution and uses the flowers of the European elderberry. Historically the cordial has been popular in North Western Europe where it has a strong Victorian heritage.\",\"strType\":\"Cordial\",\"strAlcohol\":\"No\",\"strABV\":\"50\"}]}";

        // Retrive the result of parsed ingredient data
        Ingredient actual = jsonParser.parseIngredientData(data);

        // Assert
        assertNull(actual);

        // Verify that no other methods were called
        verifyNoMoreInteractions(jsonParser);
    }
}
