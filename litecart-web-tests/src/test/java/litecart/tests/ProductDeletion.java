package litecart.tests;

import org.junit.Test;

public class ProductDeletion extends TestBase {

  @Test
  public void testProductDeletion() throws Exception {

    app.getNavigationHelper().goToCatalog();
    app.getProductHelper().FindProductToBeDeleted();
    app.getProductHelper().DeleteProduct();
  }

}
