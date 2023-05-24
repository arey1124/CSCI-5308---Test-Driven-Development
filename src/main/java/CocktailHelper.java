import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class CocktailHelper {

    public static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1";

    public void fetchRandomCocktail() {
        try {
            String apiUrl = BASE_URL + "/random.php";

            String jsonResponse = sendGetRequest(apiUrl);
            Cocktail cocktail = JSONParser.parseCocktailData(jsonResponse);
            displayCocktailData(cocktail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getCocktailByName(String name) {
        try {
            String apiUrl = BASE_URL + "/search.php?s=" + name;

            String jsonResponse = sendGetRequest(apiUrl);

            Cocktail cocktail = JSONParser.parseCocktailData(jsonResponse);
            if(cocktail != null) {
                System.out.println("Cocktail Details :");
                displayCocktailData(cocktail);
            } else {
                System.out.println("Please enter a valid cocktail name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCocktailById(String id) {
        try {
            String apiUrl = BASE_URL + "/lookup.php?i=" + id;

            String jsonResponse = sendGetRequest(apiUrl);
            Cocktail cocktail = JSONParser.parseCocktailData(jsonResponse);
            if(cocktail != null) {
                System.out.println("Cocktail Details :");
                displayCocktailData(cocktail);
            } else {
                System.out.println("Please enter a valid cocktail Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchCocktailByIngredients(String ingredient) {
        try {
            String apiUrl = BASE_URL + "/filter.php?i=" + ingredient;

            String jsonResponse = sendGetRequest(apiUrl);
            ArrayList<Cocktail> cocktails = JSONParser.parseCocktails(jsonResponse);
            if(cocktails.size() > 0) {
                System.out.println("Cocktails having the ingredient - "+ ingredient +" :");
                displayCocktailsList(cocktails);
            } else {
                System.out.println("There do not exists any cocktails with the ingredient - "+ ingredient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filterCocktailByAlcoholicFilter(AlcoholicFilter filter) {
        try {
            String apiUrl = BASE_URL + "/filter.php?a=" + filter;

            String jsonResponse = sendGetRequest(apiUrl);
            ArrayList<Cocktail> cocktails = JSONParser.parseCocktails(jsonResponse);
            displayCocktailsList(cocktails);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filterCocktailByCategory(Category category) {
        try {
            String apiUrl = BASE_URL + "/filter.php?c=" + category;

            String jsonResponse = sendGetRequest(apiUrl);
            ArrayList<Cocktail> cocktails = JSONParser.parseCocktails(jsonResponse);
            displayCocktailsList(cocktails);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filterCocktailByGlass(GlassType glassType) {
        try {
            String apiUrl = BASE_URL + "/filter.php?g=" + glassType;

            String jsonResponse = sendGetRequest(apiUrl);
            ArrayList<Cocktail> cocktails = JSONParser.parseCocktails(jsonResponse);
            displayCocktailsList(cocktails);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getIngredientById(String id) {
        try {
            String apiUrl = BASE_URL + "/lookup.php?iid=" + id;

            String jsonResponse = sendGetRequest(apiUrl);
            Ingredient ingredient = JSONParser.parseIngredientData(jsonResponse);
            if(ingredient != null) {
                System.out.println("Ingredient details are:");
                displayIngredientData(ingredient);
            } else {
                System.out.println("Please enter a valid ingredient Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getIngredientsByName(String name) {
        try {
            String apiUrl = BASE_URL + "/search.php?i=" + name;

            String jsonResponse = sendGetRequest(apiUrl);
            Ingredient ingredient = JSONParser.parseIngredientData(jsonResponse);
            if(ingredient != null) {
                System.out.println("Ingredient details are:");
                displayIngredientData(ingredient);
            } else {
                System.out.println("Please enter a valid ingredient name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendGetRequest (String apiUrl) throws IOException {
        //System.out.println(apiUrl);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("Failed to retrieve data from the API. Response code: " + responseCode);
        }
    }

    private void displayCocktailData(Cocktail cocktail) {
        String id = cocktail.getId();
        String name = cocktail.getName();
        Category category = cocktail.getCategory();
        AlcoholicFilter isAlcoholic = cocktail.getIsAlcoholic();
        GlassType glassType = cocktail.getGlassType();

        String format = "|  %-" + (id.length()) + "s  |  %-" + (name.length()) + "s  |  %-" + (category.toString().length() + 5) + "s  |  %-" + (isAlcoholic.toString().length() + 5) + "s  |  %-" + (glassType.toString().length() + 5) + "s  |%n";

        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.printf(format,
                "Id", "Name","Category","IsAlcholic","Glass Type");
        // Print the extracted values in a table row
        System.out.printf(format,
                cocktail.getId(), cocktail.getName(), cocktail.getCategory(), cocktail.getIsAlcoholic(), cocktail.getGlassType());

        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.println("Instructions : ");
        System.out.println(cocktail.getInstructions());
        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.println("Thumbnail URL : " + cocktail.getThumbnail());
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    private void displayCocktailsList(ArrayList<Cocktail> cocktailList) {

        int nameLength = Collections.max(cocktailList, (a, b) -> a.getName().length() - b.getName().length()).getName().length();
        int idLength = Collections.max(cocktailList, (a, b) -> a.getId().length() - b.getId().length()).getId().length();
        String format = "|  %-" + (idLength) + "s  |  %-" + (nameLength) + "s  |%n";
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf(format,
                "Id", "Name");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for(int i = 0; i < cocktailList.size(); i++) {
            System.out.printf(format,
                    cocktailList.get(i).getId(), cocktailList.get(i).getName());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    private void displayIngredientData(Ingredient ingredient) {
        String id = ingredient.getId();
        String name = ingredient.getName();
        String type = ingredient.getType();
        String hasAlcohol = ingredient.getHasAlcohol();
        String alcoholByVolume = ingredient.getAlocholByVolume();
        String description = ingredient.getDescription();
        String format;
        if(hasAlcohol.equalsIgnoreCase("Yes")) {
            format = "|  %-" + (id.length()+5) + "s  |  %-" + (name.length()) + "s  |  %-" + (type.length()) + "s  |  %-" + (hasAlcohol.length()+5) + "s  |  %-" + (alcoholByVolume.length()+5) + "s  |%n";
        } else {
            format = "|  %-" + (id.length()+5) + "s  |  %-" + (name.length()) + "s  |  %-" + (type.length()) + "s  |  %-" + (hasAlcohol.length()+5) + "s  |%n";
        }
        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.printf(format,
                "Id", "Name","Type","Alcohol","ABV");
        // Print the extracted values in a table row
        System.out.printf(format,
                ingredient.getId(), ingredient.getName(), ingredient.getType(), ingredient.getHasAlcohol(), ingredient.getAlocholByVolume());

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Description : ");
        if ((description.length() > 100)) {
            System.out.println(description.substring(0, 100) + "...");
        } else {
            System.out.println(description);
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
}
