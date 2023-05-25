import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import static org.mockito.Mockito.*;

public class CocktailFetcherTest {
    private static CocktailFetcher cocktailFetcher;

    @BeforeAll
    public static void setUp() {
        cocktailFetcher = mock(CocktailFetcher.class);
    }

    @Test
    public void testGetCocktailByName() {

    }

    @Test
    public void testFetchRandomCocktail() {

    }

    @Test
    public void testGetCocktailById() {

    }

    @Test
    public void testSearchCocktailByIngredients() {

    }

    @Test
    public void testFilterCocktailByAlcoholicFilterValidOption() {

    }

    @Test
    public void testFilterCocktailByAlcoholicFilterInvalidOption() {

    }

    @Test
    public void testFilterCocktailByCategoryValidOption() {

    }

    @Test
    public void testFilterCocktailByCategoryInvalidOption() {

    }

    @Test
    public void testFilterCocktailByGlassValidOption() {

    }

    @Test
    public void testFilterCocktailByGlassInvalidOption() {

    }

    @Test
    public void testGetIngredientsByName() {

    }

    @Test
    public void testGetIngredientById() {

    }

    @Test
    public void testDefaultWhenInvalidOptionSelected() {

    }


}
