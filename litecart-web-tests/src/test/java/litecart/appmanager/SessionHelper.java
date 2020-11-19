package litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.get("http://admin:df4Tu75nk8lf2w@localhost:8080/litecart/public_html/admin/login.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.xpath("//button[@name='login']"));
    }
}
