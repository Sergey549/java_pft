package litecart.model;

public class ProductData {
    private final String productName;
    private final String productDescription;

    public ProductData(String ProductName, String ProductDescription) {
        productName = ProductName;
        productDescription = ProductDescription;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
