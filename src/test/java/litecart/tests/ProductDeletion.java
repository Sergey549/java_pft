package litecart.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductDeletion extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    app.getProductHelper().gotoProductCreation();
    app.getProductHelper().FindProduct();
    app.acceptNextAlert = true;
    app.getProductHelper().DeleteProduct();
    assertTrue(app.closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
  }

}
