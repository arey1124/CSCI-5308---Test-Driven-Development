import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONParser {
    public static Cocktail parseCocktailData(String data) {
        try {
            String cocktailName = parseName(data);
            String cocktailId = parseId(data);
            if(cocktailId.isEmpty() || cocktailName.isEmpty()) {
                return null;
            }
            Cocktail cocktail = new Cocktail(cocktailName, cocktailId);
            cocktail.setCategory(parseCategory(data));
            cocktail.setIsAlcoholic(parseAlcoholicFilter(data));
            cocktail.setGlassType(parseGlassType(data));
            cocktail.setInstructions(parseInstructions(data));
            cocktail.setThumbnail(parseThumbnail(data));

            return cocktail;
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<Cocktail> parseCocktails (String data) {
        ArrayList<Cocktail> cocktails = new ArrayList<Cocktail>();

        String regex = "\"strDrink\":\\s*\"([^\"]+)\",\\s*\"strDrinkThumb\":\\s*\"([^\"]+)\",\\s*\"idDrink\":\\s*\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            String strDrink = matcher.group(1);
            String idDrink = matcher.group(3);
            Cocktail cocktail = new Cocktail(strDrink, idDrink);
            cocktails.add(cocktail);
        }

        return cocktails;
    }

    private static String parseId(String data) {
        String pattern = "\"idDrink\":\"(\\d+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String id = match.group(1);
            return id;
        }
        return null;
    }

    private static String parseName(String data) {
        String pattern = "\"strDrink\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String name = match.group(1);
            return name;
        }
        return null;
    }

    private static Category parseCategory(String data) {
        String pattern = "\"strCategory\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String category = match.group(1).replace("\\", "");;
            return Category.fromString(category);
        }
        return null;
    }

    private static AlcoholicFilter parseAlcoholicFilter(String data) {
        String pattern = "\"strAlcoholic\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String isAlcoholic = match.group(1).replace("\\", "");;
            return AlcoholicFilter.fromString(isAlcoholic);
        }
        return null;
    }

    private static GlassType parseGlassType(String data) {
        String pattern = "\"strGlass\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String glassType = match.group(1).replace("\\", "");;
            return GlassType.fromGlassName(glassType);
        }
        return null;
    }

    private static String parseInstructions(String data) {
        String pattern = "\"strInstructions\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String instructions = match.group(1);
            return instructions;
        }
        return null;
    }

    private static String parseThumbnail(String data) {
        String pattern = "\"strDrinkThumb\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String thumbnail = match.group(1);
            return thumbnail.replace("\\/","/");
        }
        return null;
    }

    public static Ingredient parseIngredientData (String data) {
        try {
            String ingredientName = parseIngredientName(data);
            String ingredientId = parseIngredientId(data);
            if(ingredientName.isEmpty() || ingredientId.isEmpty()) {
                return null;
            }
            Ingredient ingredient = new Ingredient(ingredientName, ingredientId);
            ingredient.setDescription(parseIngredientDescription(data));
            ingredient.setType(parseIngredientType(data));
            ingredient.setHasAlcohol(parseIngredientHasAlcohol(data));
            ingredient.setAlocholByVolume(parseIngredientAlcoholByVolume(data));
            return ingredient;
        } catch (Exception e) {
            return null;
        }
    }

    private static String parseIngredientId(String data) {
        String pattern = "\"idIngredient\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String thumbnail = match.group(1);
            return thumbnail;
        }
        return null;
    }

    private static String parseIngredientName(String data) {
        String pattern = "\"strIngredient\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String thumbnail = match.group(1);
            return thumbnail;
        }
        return null;
    }

    private static String parseIngredientDescription(String data) {
        String pattern = "\"strDescription\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String thumbnail = match.group(1);
            return thumbnail;
        }
        return null;
    }

    private static String parseIngredientType(String data) {
        String pattern = "\"strType\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String thumbnail = match.group(1);
            return thumbnail;
        }
        return null;
    }

    private static String parseIngredientHasAlcohol(String data) {
        String pattern = "\"strAlcohol\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String thumbnail = match.group(1);
            return thumbnail;
        }
        return null;
    }

    private static String parseIngredientAlcoholByVolume(String data) {
        String pattern = "\"strABV\":\"([^\"]+)\"";
        // Create a Pattern object
        Pattern pat = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher match = pat.matcher(data);
        if (match.find()) {
            String thumbnail = match.group(1);
            return thumbnail;
        }
        return null;
    }
}
