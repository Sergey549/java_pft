package litecart;

import org.junit.Test;

public class ProductCreation extends TestBase {

  @Test
  public void testProductCreation() throws Exception {

    goToCatalog();
    AddNewProduct();
    fillProductForm(new ProductData("Test1", "Test2"));
    SaveNewProduct();
  }

}
