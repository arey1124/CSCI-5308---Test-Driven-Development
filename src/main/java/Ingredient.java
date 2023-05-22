public class Ingredient {
    private String name;
    private String id;
    private String description;
    private String type;
    private String hasAlcohol;
    private String alocholByVolume;

    public Ingredient(String ingredientName, String ingredientId) {
        this.name = ingredientName;
        this.id = ingredientId;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getHasAlcohol() {
        return hasAlcohol;
    }

    public String getAlocholByVolume() {
        return alocholByVolume;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHasAlcohol(String hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }

    public void setAlocholByVolume(String alocholByVolume) {
        this.alocholByVolume = alocholByVolume;
    }
}
