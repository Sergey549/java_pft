package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Test;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        app.getProductHelper().createProduct(new ProductData
                ("Duck11", null, null, null));
    }
}

