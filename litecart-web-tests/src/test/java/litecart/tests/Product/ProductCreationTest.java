package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        List<ProductData> before = app.getProductHelper().getProductList();
        ProductData group = new ProductData
                ("Duck1", null, null, null);
        app.getProductHelper().createProduct(group);
        List<ProductData> after = app.getProductHelper().getProductList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max =0;
        for (ProductData g: after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}

