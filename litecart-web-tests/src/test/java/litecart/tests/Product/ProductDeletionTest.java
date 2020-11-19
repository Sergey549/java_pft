package litecart.tests.Product;

import litecart.tests.TestBase;
import org.junit.Test;

public class ProductDeletionTest extends TestBase {

    @Test
    public void testProductDeletion() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        app.getProductHelper().chooseProductToBeDeleted();
        app.getProductHelper().deleteProduct();
        app.getProductHelper().acceptDeletion();
        app.getProductHelper().checkProductToBeDeletedSuccessfully();
    }
}

