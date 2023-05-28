package enums;

public enum GlassType {
    HIGHBALL_GLASS("Highball glass"),
    COCKTAIL_GLASS("Cocktail glass"),
    OLD_FASHIONED_GLASS("Old-fashioned glass"),
    COLLINS_GLASS("Collins glass"),
    PUNCH_BOWL("Punch bowl"),
    SHOT_GLASS("Shot glass"),
    BEER_MUG("Beer mug"),
    PINT_GLASS("Pint glass"),
    MARTINI_GLASS("Martini glass"),
    MARGARITA_GLASS("Margarita glass"),
    CHAMPAGNE_FLUTE("Champagne flute"),
    WINE_GLASS("Wine glass"),
    BRANDY_SNIFTER("Brandy snifter"),
    WHISKEY_GLASS("Whiskey glass"),
    COFFEE_MUG("Coffee mug"),
    IRISH_COFFEE_CUP("Irish coffee cup"),
    POCO_GRANDE_GLASS("Poco grande glass"),
    COPPER_MUG("Copper mug"),
    WINE_TUMBLER("Wine tumbler"),
    SHERRY_GLASS("Sherry glass"),
    BEER_PILSNER("Beer pilsner"),
    BEER_WEIZEN("Beer weizen"),
    MASON_JAR("Mason jar"),
    MARGARITA_COUPETTE_GLASS("Margarita/Coupette glass"),
    BEER_PINT_SHAKER("Beer shaker"),
    BEER_GLASS("Beer glass"),
    PITCHER("Pitcher"),
    MARGARITA_METAL("Margarita metal"),
    MARTINI_COGNAC_GLASS("Martini Cognac glass"),
    BALLOON_GLASS("Balloon glass"),
    SHOT_PONY("Shot-poon"),
    MARTINI_SAUCER("Martini saucer"),
    BEER_MAI_TAI_GLASS("Beer Mai Tai glass");

    private final String glassName;

    GlassType(String glassName) {
        this.glassName = glassName;
    }

    public static GlassType fromGlassName(String glassName) {
        for (GlassType glassType : GlassType.values()) {
            if (glassType.glassName.equalsIgnoreCase(glassName)) {
                return glassType;
            }
        }
        return null;
    }
}
