package litecart.appmanager;

import litecart.model.ProductData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class ProductHelper extends HelperBase {

    private boolean acceptNextAlert = true;

    public ProductHelper(ChromeDriver driver) {

        super(driver);
    }

    public void SaveNewProduct() {
      click(By.name("save"));
    }

    public void fillProductForm(ProductData productData) {
        type(By.name("name[en]"), productData.getProductName());
        click(By.linkText("Information"));
        type(By.name("short_description[en]"), productData.getProductDescription());
    }

    public void AddNewProduct() {
        click(By.linkText("Add New Product"));
    }

    private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }

    public void DeleteProduct() {
      acceptNextAlert = true;
        click(By.name("delete"));
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
    }

    public void FindProductToBeDeleted() {
        click(By.name("products[39]"));
    }

    public void initEditProduct() {

        click(By.xpath("//div[@id='content']/div/div[3]/form/table/tbody/tr[3]/td[6]/a/i"));
    }
}
