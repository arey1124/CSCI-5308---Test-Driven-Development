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

    }

    @Test
    public void testIngredientTypeGetterAndSetter() {

    }

    @Test
    public void testIngredientDescriptionGetterAndSetter() {

    }

    @Test
    public void testIngredientHasAlcoholGetterAndSetter() {

    }

    @Test
    public void testIngredientAlcoholByVolumeGetterAndSetter() {

    }
}
