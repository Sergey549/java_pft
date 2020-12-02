package litecart.model;


public class CategoryData {

    private final String categoryName;
    private final String shortDescription;
    private final String description;


    public CategoryData(String categoryName, String shortDescription, String description) {

        this.categoryName = categoryName;
        this.shortDescription = shortDescription;
        this.description = description;

    }


    public String getCategoryName() {
        return categoryName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }
}
