package litecart.tests;

import litecart.model.ProductData;
import org.junit.Test;

public class ProductCreation extends TestBase {

  @Test
  public void testProductCreation() throws Exception {

    app.getNavigationHelper().goToCatalog();
    app.getProductHelper().AddNewProduct();
    app.getProductHelper().fillProductForm(new ProductData("Test1", "Test2"));
    app.getProductHelper().SaveNewProduct();
  }

}
