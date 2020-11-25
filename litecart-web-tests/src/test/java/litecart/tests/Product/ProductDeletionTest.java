package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ProductDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.checkAdminMainPageIsTrue();
        app.goTo().Catalog();
        if (app.product().all().size() == 0) {
            app.product().create(new ProductData
                    ("Duck1", null, null, null));
        }
    }

    @Test
    public void testProductDeletion() {
        Set<ProductData> before = app.product().all();
        ProductData deletedProduct = before.iterator().next();
        app.product().delete(deletedProduct);
        Set<ProductData> after = app.product().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedProduct);
        Assert.assertEquals(before, after);
    }
}

