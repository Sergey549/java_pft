package litecart.tests.Category;

import litecart.model.CategoryData;
import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Test;

public class CategoryModificationTest extends TestBase {

    @Test
    public void testCategoryModification () {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        app.getCategoryHelper().initCategoryModification();
        app.getCategoryHelper().fillCategoryForm(new CategoryData
                ("Category1", "test1", "test2"));
        app.getCategoryHelper().deleteCategory(true);
        app.getCategoryHelper().saveCategory();
    }
}
