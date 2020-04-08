package litecart;

import org.junit.Test;

public class ProductDeletion extends TestBase {

  @Test
  public void testProductDeletion() throws Exception {

    goToCatalog();
    FindProductToBeDeleted();
    DeleteProduct();
  }

}
