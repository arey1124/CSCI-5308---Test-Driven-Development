import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class CocktailTest {

    static Cocktail cocktail;
    @BeforeAll
    public static void SetupBeforeAll() {
        cocktail = mock(Cocktail.class);

        // Set up the behavior of the mock object
        when(cocktail.getName()).thenReturn("151 Florida Bushwacker");
        when(cocktail.getId()).thenReturn("14588");
        when(cocktail.getCategory()).thenReturn(Category.BEER);
        when(cocktail.getIsAlcoholic()).thenReturn(AlcoholicFilter.ALCOHOLIC);
        when(cocktail.getGlassType()).thenReturn(GlassType.COCKTAIL_GLASS);
        when(cocktail.getInstructions()).thenReturn("Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.");
        when(cocktail.getThumbnail()).thenReturn("https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg");
    }

    @Test
    public void testCocktailNameAndIdGetter() {

        // Perform any necessary operations involving the mock object
        String name = cocktail.getName();
        String id = cocktail.getId();
        // Verify the interactions with the mock object
        verify(cocktail).getName();
        verify(cocktail).getId();

        assertEquals(name, "151 Florida Bushwacker");
        assertEquals(id, "14588");
    }

    @Test
    public void testCocktailCategoryGetterAndSetter() {

        // Assert the behaviour to verify the values set during object creation
        assertEquals(cocktail.getCategory(), Category.BEER);

        cocktail.setCategory(Category.COCKTAIL);

        // Verify the interactions with the mock object
        verify(cocktail).setCategory(Category.COCKTAIL);
    }

    @Test
    public void testCocktailAlcoholicGetterAndSetter() {

        // Assert the behaviour to verify the values set during object creation
        assertEquals(cocktail.getIsAlcoholic(), AlcoholicFilter.ALCOHOLIC);

        cocktail.setIsAlcoholic(AlcoholicFilter.NON_ALCOHOLIC);

        // Verify the interactions with the mock object
        verify(cocktail).setIsAlcoholic(AlcoholicFilter.NON_ALCOHOLIC);
    }

    @Test
    public void testCocktailGlassTypeGetterAndSetter() {

        // Assert the behaviour to verify the values set during object creation
        assertEquals(cocktail.getGlassType(), GlassType.COCKTAIL_GLASS);

        cocktail.setGlassType(GlassType.HIGHBALL_GLASS);

        // Verify the interactions with the mock object
        verify(cocktail).setGlassType(GlassType.HIGHBALL_GLASS);
    }

    @Test
    public void testCocktailInstructionsGetterAndSetter() {

        // Assert the behaviour to verify the values set during object creation
        assertEquals(cocktail.getInstructions(), "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.");

        cocktail.setInstructions("Pour it into the glass");

        // Verify the interactions with the mock object
        verify(cocktail).setInstructions("Pour it into the glass");
    }

    @Test
    public void testCocktailThumbnailGetterAndSetter() {

        // Assert the behaviour to verify the values set during object creation
        assertEquals(cocktail.getThumbnail(), "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg");

        cocktail.setThumbnail("https://www.thecocktaildb.com/images/media/drink/5noda61589575159.jpg");

        // Verify the interactions with the mock object
        verify(cocktail).setThumbnail("https://www.thecocktaildb.com/images/media/drink/5noda61589575159.jpg");
    }

}
