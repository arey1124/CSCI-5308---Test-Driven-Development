import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;

import java.util.Scanner;

public class CocktailFetcher {

    public static CocktailHelper cocktailHelper;

    public CocktailFetcher(CocktailHelper cocktailHelper) {
        this.cocktailHelper = cocktailHelper;
    }

    public static void main(String args[]) {

        if(cocktailHelper == null) {
            cocktailHelper = new CocktailHelper();
        }

        System.out.println("-----COCKTAIL DB-----");
        System.out.println("1. Fetch a random Cocktail");
        System.out.println("2. Get Cocktail by Name");
        System.out.println("3. Search Cocktail details by Id");
        System.out.println("4. Search Cocktail details by Ingredients");
        System.out.println("5. Filter Cocktail by Alcoholic Filter");
        System.out.println("6. Filter Cocktail by Category");
        System.out.println("7. Filter Cocktail by Glass Type");
        System.out.println("8. Get Ingredient details by Name");
        System.out.println("9. Get Ingredient details by Id");
        System.out.println("10. Exit");

        System.out.println("Please select the option number from the above menu to proceed:");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();

        switch (option) {
            case "1":
                System.out.println("Random Cocktail Data :");
                cocktailHelper.fetchRandomCocktail();
                break;
            case "2":
                System.out.println("Enter a cocktail name :");
                String name = scanner.next();
                cocktailHelper.getCocktailByName(name);
                break;
            case "3":
                System.out.println("Enter the cocktail id :");
                String id = scanner.next();
                cocktailHelper.getCocktailById(id);
                break;
            case "4":
                System.out.println("Enter the ingredient name :");
                String ingredient = scanner.next();
                cocktailHelper.searchCocktailByIngredients(ingredient);
                break;
            case "5":
                System.out.println("Select the alcoholic filter :");
                System.out.println("1. Alcoholic");
                System.out.println("2. Non Alcoholic");
                String alocholicFilter = scanner.next();
                switch (alocholicFilter) {
                    case "1":
                        System.out.println("Cocktails that are Alcoholic");
                        cocktailHelper.filterCocktailByAlcoholicFilter(AlcoholicFilter.ALCOHOLIC);
                        break;
                    case "2":
                        System.out.println("Cocktails that are Non Alcoholic");
                        cocktailHelper.filterCocktailByAlcoholicFilter(AlcoholicFilter.NON_ALCOHOLIC);
                        break;
                    default:
                        System.out.println("Please select a valid option");
                        break;
                }
                break;
            case "6":
                System.out.println("Select the cocktail category :");
                System.out.println("1. Ordinary Drink");
                System.out.println("2. Shake");
                System.out.println("3. Cocoa");
                System.out.println("4. Shot");
                System.out.println("5. Homemade Liqueur");
                System.out.println("6. Beer");
                System.out.println("7. Soft Drink");
                String category = scanner.next();
                switch (category) {
                    case "1":
                        System.out.println("Cocktails under the category Ordinary Drink:");
                        cocktailHelper.filterCocktailByCategory(Category.ORDINARY_DRINK);
                        break;
                    case "2":
                        System.out.println("Cocktails under the category Shake:");
                        cocktailHelper.filterCocktailByCategory(Category.SHAKE);
                        break;
                    case "3":
                        System.out.println("Cocktails under the category Cocoa:");
                        cocktailHelper.filterCocktailByCategory(Category.COCOA);
                        break;
                    case "4":
                        System.out.println("Cocktails under the category Shot:");
                        cocktailHelper.filterCocktailByCategory(Category.SHOT);
                        break;
                    case "5":
                        System.out.println("Cocktails under the category Homemade Liqueur:");
                        cocktailHelper.filterCocktailByCategory(Category.HOMEMADE_LIQUEUR);
                        break;
                    case "6":
                        System.out.println("Cocktails under the category Beer:");
                        cocktailHelper.filterCocktailByCategory(Category.BEER);
                        break;
                    case "7":
                        System.out.println("Cocktails under the category Soft Drink:");
                        cocktailHelper.filterCocktailByCategory(Category.SOFT_DRINK);
                        break;
                    default:
                        System.out.println("Please select a valid option");
                        break;
                }
                break;
            case "7":
                System.out.println("Select the cocktail category :");
                System.out.println("1. Highball glass");
                System.out.println("2. Cocktail glass");
                System.out.println("3. Champagne flute");
                System.out.println("4. Shot glass");
                System.out.println("5. Margarita glass");
                String glassType = scanner.next();
                switch (glassType) {
                    case "1":
                        System.out.println("Cocktails served in Highball glass:");
                        cocktailHelper.filterCocktailByGlass(GlassType.HIGHBALL_GLASS);
                        break;
                    case "2":
                        System.out.println("Cocktails served in Cocktail glass:");
                        cocktailHelper.filterCocktailByGlass(GlassType.COCKTAIL_GLASS);
                        break;
                    case "3":
                        System.out.println("Cocktails served in Champagne flute:");
                        cocktailHelper.filterCocktailByGlass(GlassType.CHAMPAGNE_FLUTE);
                        break;
                    case "4":
                        System.out.println("Cocktails served in Shot glass:");
                        cocktailHelper.filterCocktailByGlass(GlassType.SHOT_GLASS);
                        break;
                    case "5":
                        System.out.println("Cocktails served in Margarita glass:");
                        cocktailHelper.filterCocktailByGlass(GlassType.MARGARITA_GLASS);
                        break;
                    default:
                        System.out.println("Please select a valid option");
                        break;
                }
                break;
            case "8":
                System.out.println("Enter the ingredient name (Example- vodka):");
                String ingredientName = scanner.next();
                cocktailHelper.getIngredientsByName(ingredientName);
                break;
            case "9":
                System.out.println("Enter the ingredient id :");
                String ingredientId = scanner.next();
                cocktailHelper.getIngredientById(ingredientId);
                break;
            case "10":
                System.out.println("Exiting.....");
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }
    }
}
