package litecart;

<<<<<<< HEAD
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductAdding {
  ChromeDriver driver;


  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://admin:admin@localhost/litecart/public_html/admin/login.php");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.xpath("//button[@name='login']")).click();
    driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[2]/a/span[2]")).click();
    driver.findElement(By.linkText("Add New Product")).click();
    driver.findElement(By.name("name[en]")).click();
    driver.findElement(By.name("name[en]")).clear();
    driver.findElement(By.name("name[en]")).sendKeys("Test1");
    driver.findElement(By.linkText("Information")).click();
    driver.findElement(By.name("short_description[en]")).click();
    driver.findElement(By.name("short_description[en]")).clear();
    driver.findElement(By.name("short_description[en]")).sendKeys("Test2");
    driver.findElement(By.xpath("//div[@id='en']/div[2]/div/div/div[2]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.name("save")).click();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
=======
import org.junit.Test;

public class ProductAdding extends TestBase {


  @Test
  public void testProductAdding() throws Exception {
    gotoProductCreation();
    initProductCreation();
    fillProductForm(new ProductData("Test1", "Test2"));
    saveProductForm();
  }

>>>>>>> parent of 04f845b... Делегирование

}