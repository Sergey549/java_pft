package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        int before = app.getProductHelper().getProductCount();
        app.getProductHelper().createProduct(new ProductData
                ("Duck11", null, null, null));
        int after = app.getProductHelper().getProductCount();
        Assert.assertEquals(after, before+1);
    }
}

