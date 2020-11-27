package litecart.tests.Category;

import litecart.model.CategoryData;
import litecart.tests.TestBase;
import org.testng.annotations.Test;

import java.io.File;

public class CategoryCreationTest extends TestBase {
    @Test
    public void testCategoryCreation () {
        app.checkAdminMainPageIsTrue();
        app.goTo().Catalog();
        app.getCategoryHelper().initCategoryCreation();
        app.getCategoryHelper().fillCategoryForm(new CategoryData
                ("Category1", null, null));
        app.getCategoryHelper().deleteCategory(false);
        app.getCategoryHelper().saveCategory();
    }
}
