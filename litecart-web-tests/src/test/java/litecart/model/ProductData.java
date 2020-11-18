package litecart.model;

public class ProductData {
    private final String duckName;
    private final String shortDescription;
    private final String description;
    private final String technicalData;

    public ProductData(String duckName, String shortDescription, String description, String technicalData) {
        this.duckName = duckName;
        this.shortDescription = shortDescription;
        this.description = description;
        this.technicalData = technicalData;
    }

    public String getDuckName() {
        return duckName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnicalData() {
        return technicalData;
    }
}
