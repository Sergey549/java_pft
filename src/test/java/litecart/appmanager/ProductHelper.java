package litecart.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import litecart.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductHelper extends HelperBase {

    public ProductHelper(ChromeDriver driver) {

        super(driver);
    }

    public void fillProductForm(ProductData productData) {
        type(By.name("name[en]"), productData.getName());
        click(By.linkText("Information"));
        type(By.name("short_description[en]"), productData.getShortDescription());
    }

    public void gotoProductCreation() {
        click(By.xpath("//ul[@id='box-apps-menu']/li[2]/a/span[2]"));
    }

    public void initProductCreation() {
        click(By.linkText("Add New Product"));
    }

    public void saveProductForm() {
        click(By.name("save"));
    }

    public void DeleteProduct() {
        click(By.name("delete"));
    }

    public void FindProduct() {
      click(By.name("products[25]"));
    }

}
