package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        List<ProductData> before = app.getProductHelper().getProductList();
        app.getProductHelper().createProduct(new ProductData
                ("Duck11", null, null, null));
        List<ProductData> after = app.getProductHelper().getProductList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}

