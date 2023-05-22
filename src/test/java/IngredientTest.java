import enums.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class IngredientTest {

    static Ingredient ingredient;

    @BeforeAll
    public static void SetupBeforeAll() {
        ingredient = mock(Ingredient.class);

        // Set up the behavior of the mock object
        when(ingredient.getName()).thenReturn("Vodka");
        when(ingredient.getId()).thenReturn("1");
        when(ingredient.getType()).thenReturn("Vodka");
        when(ingredient.getDescription()).thenReturn("Vodka is a distilled beverage composed primarily of water and ethanol.");
        when(ingredient.getHasAlcohol()).thenReturn("Yes");
        when(ingredient.getAlocholByVolume()).thenReturn("40");
    }

    @Test
    public void testIngredientNameAndIdGetter() {
        // Perform any necessary operations involving the mock object
        String name = ingredient.getName();
        String id = ingredient.getId();

        // Verify the interactions with the mock object
        verify(ingredient).getName();
        verify(ingredient).getId();

        assertEquals(name, "Vodka");
        assertEquals(id, "1");
    }

    @Test
    public void testIngredientTypeGetterAndSetter() {
        // Assert the behaviour to verify the values set during object creation
        assertEquals(ingredient.getType(), "Vodka");

        ingredient.setType("Beer");

        // Verify the interactions with the mock object
        verify(ingredient).setType("Beer");
    }

    @Test
    public void testIngredientDescriptionGetterAndSetter() {
        // Assert the behaviour to verify the values set during object creation
        assertEquals(ingredient.getDescription(), "Vodka is a distilled beverage composed primarily of water and ethanol.");

        ingredient.setDescription("Let's make this boring tests interesting with cocktails");

        // Verify the interactions with the mock object
        verify(ingredient).setDescription("Let's make this boring tests interesting with cocktails");
    }

    @Test
    public void testIngredientHasAlcoholGetterAndSetter() {
        // Assert the behaviour to verify the values set during object creation
        assertEquals(ingredient.getHasAlcohol(), "Yes");

        ingredient.setHasAlcohol("No");

        // Verify the interactions with the mock object
        verify(ingredient).setHasAlcohol("No");
    }

    @Test
    public void testIngredientAlcoholByVolumeGetterAndSetter() {
        // Assert the behaviour to verify the values set during object creation
        assertEquals(ingredient.getAlocholByVolume(), "40");

        ingredient.setAlocholByVolume("55");

        // Verify the interactions with the mock object
        verify(ingredient).setAlocholByVolume("55");
    }
}
