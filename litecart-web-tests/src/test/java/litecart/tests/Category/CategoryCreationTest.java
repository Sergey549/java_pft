package litecart.tests.Category;

import litecart.model.CategoryData;
import litecart.tests.TestBase;
import org.junit.Test;

public class CategoryCreationTest extends TestBase {
    @Test
    public void testCategoryCreation () {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        app.getCategoryHelper().initCategoryCreation();
        app.getCategoryHelper().fillCategoryForm(new CategoryData
                ("Category1", null, null));
        app.getCategoryHelper().saveCategory();
    }
}
