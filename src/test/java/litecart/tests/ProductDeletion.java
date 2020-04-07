package litecart.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductDeletion extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    app.gotoProductCreation();
    app.FindProduct();
    app.acceptNextAlert = true;
    app.DeleteProduct();
    assertTrue(app.closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
  }

}
