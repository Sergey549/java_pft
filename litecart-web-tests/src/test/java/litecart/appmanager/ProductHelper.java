package litecart.appmanager;

import litecart.model.ProductData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class ProductHelper extends HelperBase {

    private boolean acceptNextAlert = true;

    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void fillProductForm(ProductData productData) {
        type(By.name("name[en]"), productData.getDuckName());
        attach(By.cssSelector("input[type='file']"),productData.getProductPhoto());
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


    public void create(ProductData product) {
        initProductCreation();
        fillProductForm(product);
        saveProduct();
    }

    public void modify(ProductData product) {
        selectProductToBeModifiedById(product.getId());
        fillProductForm(product);
        saveProduct();
    }

    private void selectProductToBeModifiedById(int id) {
        driver.findElement(By.xpath("//td[@class='text-right']/a[contains(@href,'"+id+"')]")).click();
    }

    public void delete(ProductData deletedProduct) {
        selectProductToBeDeletedById(deletedProduct.getId());
        deleteProduct();
        acceptDeletion();
        checkProductToBeDeletedSuccessfully();
    }

    private void selectProductToBeDeletedById(int id) {
        driver.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public boolean isThereAProduct() {
        return (isElementPresent(By.xpath("//input[contains(@name,'products')]")));
    }

    public int getProductCount() {
    return driver.findElements(
            By.xpath("//input[contains(@name,'products')]")).size();
    }


    public Set<ProductData> all() {
        Set<ProductData> products = new HashSet<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("tr.semi-transparent"));
        for (WebElement element: elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ProductData product = new ProductData(id, name, null, null, null);
            products.add(product);
        }
        return products;
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

}
