package litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(ChromeDriver driver) {

        super(driver);
    }

    protected void login(String username, String password) {
        type(By.name("username"),username);
        type(By.name("password"),password);
        click(By.xpath("//button[@name='login']"));
    }
}
