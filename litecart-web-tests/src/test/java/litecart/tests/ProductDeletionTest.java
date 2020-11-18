package litecart.tests;

import org.junit.Test;

public class ProductDeletionTest extends TestBase {

    @Test
    public void testProductDeletion() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.goToCatalog();
        app.checkProductToBeDeleted();
        app.deleteProduct();
        app.acceptDeletion();
        app.checkProductToBeDeletedSuccessfully();
    }
}

