package litecart;

import org.junit.Test;

public class ProductAdding extends TestBase {


  @Test
  public void testProductAdding() throws Exception {
    gotoProductCreation();
    initProductCreation();
    fillProductForm(new ProductData("Test1", "Test2"));
    saveProductForm();
  }


}