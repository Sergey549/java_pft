package litecart;

public class ProductData {
    private final String name;
    private final String shortDescription;

    public ProductData(String Name, String ShortDescription) {
        name = Name;
        shortDescription = ShortDescription;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}