package litecart.tests;

import litecart.model.ProductData;
import org.junit.Test;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.goToCatalog();
        app.initProductCreation();
        app.fillProductForm(new ProductData
                ("Duck1", "test1", "test2", "test3"));
        app.saveProduct();
    }
}

