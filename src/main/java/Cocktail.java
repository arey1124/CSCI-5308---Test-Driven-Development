import enums.AlcoholicFilter;
import enums.Category;
import enums.GlassType;

import java.util.ArrayList;
import java.util.List;

public class Cocktail {
    private String name;
    private String id;
    private Category category;
    private AlcoholicFilter isAlcoholic;
    private GlassType glassType;
    private String instructions;
    private String thumbnail;

    public Cocktail(String cocktailName, String cocktailId) {
        this.name = cocktailName;
        this.id = cocktailId;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AlcoholicFilter getIsAlcoholic() {
        return isAlcoholic;
    }

    public void setIsAlcoholic(AlcoholicFilter isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    public GlassType getGlassType() {
        return glassType;
    }

    public void setGlassType(GlassType glassType) {
        this.glassType = glassType;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
