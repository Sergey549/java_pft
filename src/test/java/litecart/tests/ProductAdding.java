package litecart.tests;

import litecart.model.ProductData;
import org.junit.Test;

public class ProductAdding extends TestBase {


  @Test
  public void testProductAdding() throws Exception {
    app.getProductHelper().gotoProductCreation();
    app.getProductHelper().initProductCreation();
    app.getProductHelper().fillProductForm(new ProductData("Test1", "Test2"));
    app.getProductHelper().saveProductForm();
  }


}