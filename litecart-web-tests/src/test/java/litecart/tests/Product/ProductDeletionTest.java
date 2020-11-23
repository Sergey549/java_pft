package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductDeletionTest extends TestBase {

    @Test
    public void testProductDeletion() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        if (! app.getProductHelper().isThereAProduct()) {
            app.getProductHelper().createProduct(new ProductData
                    ("Duck1", null, null, null));
        }
        List<ProductData> before = app.getProductHelper().getProductList();
        app.getProductHelper().selectProductToBeDeleted(before.size() - 1);
        app.getProductHelper().deleteProduct();
        app.getProductHelper().acceptDeletion();
        app.getProductHelper().checkProductToBeDeletedSuccessfully();
        List<ProductData> after = app.getProductHelper().getProductList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}

