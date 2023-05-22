package enums;

public enum Category {
    ORDINARY_DRINK("Ordinary Drink"),
    COCKTAIL("Cocktail"),
    SHAKE("Shake"),
    OTHER("Other / Unknown"),
    COCOA("Cocoa"),
    SHOT("Shot"),
    COFFEE_TEA("Coffee / Tea"),
    HOMEMADE_LIQUEUR("Homemade Liqueur"),
    PARTY_PUNCH("Punch / Party Drink"),
    BEER("Beer"),
    SOFT_DRINK("Soft Drink");

    private String displayText;

    Category(String displayText) {
        this.displayText = displayText;
    }

    public static Category fromString(String categoryText) {
        //System.out.println("Debugger: " + categoryText);
        for (Category category : Category.values()) {
            if (category.displayText.equalsIgnoreCase(categoryText)) {
                return category;
            }
        }
        return null;
    }
}
