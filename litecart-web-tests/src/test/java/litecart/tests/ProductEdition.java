package litecart.tests;

import litecart.model.ProductData;
import org.junit.Test;

public class ProductEdition extends TestBase {

    @Test

    public void testProductEdition () {

        app.getNavigationHelper().goToCatalog();
        app.getProductHelper().initEditProduct();
        app.getProductHelper().SaveNewProduct();
    }
}
