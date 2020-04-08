package litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(ChromeDriver driver) {

        super(driver);
    }

    protected void login(String username, String password) {
      driver.findElement(By.name("username")).click();
      driver.findElement(By.name("username")).clear();
      driver.findElement(By.name("username")).sendKeys(username);
      driver.findElement(By.name("password")).sendKeys(password);
      driver.findElement(By.xpath("//button[@name='login']")).click();
    }
}
