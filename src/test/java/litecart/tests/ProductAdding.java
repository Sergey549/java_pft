package litecart.tests;

import litecart.model.ProductData;
import org.junit.Test;

public class ProductAdding extends TestBase {


  @Test
  public void testProductAdding() throws Exception {
    app.gotoProductCreation();
    app.initProductCreation();
    app.fillProductForm(new ProductData("Test1", "Test2"));
    app.saveProductForm();
  }


}