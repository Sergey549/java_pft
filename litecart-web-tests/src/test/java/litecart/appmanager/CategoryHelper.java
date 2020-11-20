package litecart.appmanager;

import litecart.model.CategoryData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CategoryHelper extends HelperBase {

    public CategoryHelper(WebDriver driver) {
        super(driver);
    }

    public void initCategoryCreation() {
        click(By.linkText("Add New Category"));
    }

    public void fillCategoryForm(CategoryData categoryData) {
        type(By.name("name[en]"), categoryData.getCategoryName());
        click(By.linkText("Information"));
        type(By.name("short_description[en]"), categoryData.getShortDescription());
        type(By.xpath("//div[@id='en']/div[3]/div/div/div[2]"), categoryData.getDescription());

    }

    public void saveCategory() {
        click(By.name("save"));
    }

    public void initCategoryModification() {
        click(By.xpath("//form[@name='catalog_form']/table/tbody/tr/td/a[contains(@href,'category&category') " +
                "and contains(@href,'4') and contains (@title, 'Edit')]"));
    }
    public void deleteCategory(boolean modific) {
        if (modific) {
            driver.findElement(By.name("delete"));
        } else
            Assert.assertFalse(isElementPresent(By.name("delete")));
    }
}

