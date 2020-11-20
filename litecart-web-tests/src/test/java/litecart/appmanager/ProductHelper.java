package litecart.appmanager;

import litecart.model.ProductData;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class ProductHelper extends HelperBase {

    private boolean acceptNextAlert = true;

    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void fillProductForm(ProductData productData) {
        type(By.name("name[en]"), productData.getDuckName());
        click(By.linkText("Information"));
        type(By.name("short_description[en]"), productData.getShortDescription());
        type(By.xpath("//div[@id='en']/div[2]/div/div/div[2]"), productData.getDescription());
        type(By.name("technical_data[en]"), productData.getTechnicalData());
    }

    public void saveProduct() {
        click(By.name("save"));
    }

    public void initProductCreation() {
        String catalogTitle = driver.findElement(By.cssSelector("div[class='panel-heading']")).getText();
        if (!isElementPresent(By.cssSelector("div[class='panel-heading']"))
                || catalogTitle.equals("Catalog")) {
            click(By.xpath("//a[contains(.,' Add New Product')]"));
        }
    }

    public void checkProductToBeDeletedSuccessfully() {
        WebElement modalText = driver.findElement(By.xpath("//div[@id='notices']"));
        Assert.assertEquals("Deleted 1 products",
                modalText.getText().substring(2));
    }

    public void acceptDeletion() {
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
    }

    public void deleteProduct() {
        click(By.name("delete"));
    }

    public void selectProductToBeDeleted() {
        click(By.xpath("//tr[@class=' semi-transparent']/td/input[contains(@type,'checkbox')]"));
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

    public void initProductModification() {
        click(By.xpath("//form[@name='catalog_form']/table/tbody/tr/td/a[contains(@href,'id=0&product') " +
                "and contains (@title, 'Edit')]"));
    }

    public void createProduct(ProductData product) {
        initProductCreation();
        fillProductForm(product);
        saveProduct();
    }

    public boolean isThereAProduct() {
        return (isElementPresent(By.xpath("//tr[@class=' semi-transparent']/td/input[contains(@type,'checkbox')]")));
    }
}