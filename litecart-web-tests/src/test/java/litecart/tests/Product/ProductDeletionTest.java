package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class ProductDeletionTest extends TestBase {

    @Test
    public void testProductDeletion() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        int before = app.getProductHelper().getProductCount();
        if (! app.getProductHelper().isThereAProduct()) {
            app.getProductHelper().createProduct(new ProductData
                    ("Duck11", null, null, null));
        }
        app.getProductHelper().selectProductToBeDeleted();
        app.getProductHelper().deleteProduct();
        app.getProductHelper().acceptDeletion();
        app.getProductHelper().checkProductToBeDeletedSuccessfully();
        int after = app.getProductHelper().getProductCount();
        Assert.assertEquals(after, before-1);
    }
}

