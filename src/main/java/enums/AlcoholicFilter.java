package enums;

public enum AlcoholicFilter {
    ALCOHOLIC("Alcoholic"),
    NON_ALCOHOLIC("Non alcoholic"),
    OPTIONAL("Optional alcohol");

    private String isAlcholoic;

    AlcoholicFilter(String isAlcholoic) {
        this.isAlcholoic = isAlcholoic;
    }

    public static AlcoholicFilter fromString(String isAlcholoic) {
        for (AlcoholicFilter alcoholic : AlcoholicFilter.values()) {
            if (alcoholic.isAlcholoic.equalsIgnoreCase(isAlcholoic)) {
                return alcoholic;
            }
        }
        return null;
    }

}
