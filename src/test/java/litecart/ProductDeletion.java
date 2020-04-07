package litecart;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductDeletion extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    gotoProductCreation();
    FindProduct();
    acceptNextAlert = true;
    DeleteProduct();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
  }

}
