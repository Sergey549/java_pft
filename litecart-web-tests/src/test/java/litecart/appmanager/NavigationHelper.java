package litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(ChromeDriver driver) {

        super(driver);

    }

    public void goToCatalog() {

        click(By.xpath("//ul[@id='box-apps-menu']/li[2]/a/span[2]"));

    }
}
