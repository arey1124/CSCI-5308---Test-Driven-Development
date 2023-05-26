import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CocktailFetcherTest {
    private static CocktailFetcher cocktailFetcher;

    private static CocktailHelper cocktailHelper;

    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        cocktailHelper = mock(CocktailHelper.class);
        cocktailFetcher = new CocktailFetcher(cocktailHelper);
    }

    @AfterEach
    public void validate() {
        outputStreamCaptor.reset();
    }

    @Test
    public void testFetchRandomCocktail() {
        // Mocking user input
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).fetchRandomCocktail();
    }

    @Test
    public void testGetCocktailByName() {

        // Mocking user input
        String input = "2\nMargarita\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).getCocktailByName(anyString());
    }

    @Test
    public void testGetCocktailById() {
        String input = "3\n11007\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).getCocktailById("11007");
    }

    @Test
    public void testSearchCocktailByIngredients() {
        String input = "4\nGin\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).searchCocktailByIngredients("Gin");
    }

    @Test
    public void testFilterCocktailByAlcoholicFilterValidOption() {
        String input = "5\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).filterCocktailByAlcoholicFilter(AlcoholicFilter.ALCOHOLIC);
    }

    @Test
    public void testFilterCocktailByAlcoholicFilterInvalidOption() {
        String input = "5\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that there is no further interactions and the output is as expected
        String expectedOutput = "Please select a valid option";
        assertEquals(true, outputStreamCaptor.toString().contains(expectedOutput));
    }

    @Test
    public void testFilterCocktailByCategoryValidOption() throws IOException {
        String input = "6\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).filterCocktailByCategory(Category.ORDINARY_DRINK);
    }

    @Test
    public void testFilterCocktailByCategoryInvalidOption() {
        String input = "6\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that there is no further interactions and the output is as expected
        String expectedOutput = "Please select a valid option";
        assertEquals(true, outputStreamCaptor.toString().contains(expectedOutput));
    }

    @Test
    public void testFilterCocktailByGlassValidOption() {
        String input = "7\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).filterCocktailByGlass(GlassType.COCKTAIL_GLASS);
    }

    @Test
    public void testFilterCocktailByGlassInvalidOption() {
        String input = "7\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that there is no further interactions and the output is as expected
        String expectedOutput = "Please select a valid option";
        assertEquals(true, outputStreamCaptor.toString().contains(expectedOutput));
    }

    @Test
    public void testGetIngredientsByName() {
        String input = "8\nelderflower\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).getIngredientsByName("elderflower");
    }

    @Test
    public void testGetIngredientById() {
        String input = "9\n552\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that the expected method is called
        verify(cocktailHelper).getIngredientById("552");
    }

    @Test
    public void testDefaultWhenInvalidOptionSelected() {
        String input = "15\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Calling the method to be tested
        cocktailFetcher.main(new String[]{});

        // Verifying that there is no further interactions and the output is as expected
        String expectedOutput = "Please enter a valid option";
        assertEquals(true, outputStreamCaptor.toString().contains(expectedOutput));
    }
}
