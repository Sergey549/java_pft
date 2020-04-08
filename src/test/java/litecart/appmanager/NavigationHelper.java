package litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {

    private ChromeDriver driver;


    public NavigationHelper(ChromeDriver driver) {

        this.driver = driver;

    }

    public void goToCatalog() {
      driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[2]/a/span[2]")).click();
    }
}
