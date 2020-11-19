package litecart.tests;

import litecart.model.ProductData;
import org.junit.Test;

public class ProductModificationTest extends TestBase{

    @Test
    public void testProductModification (){
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        app.getProductHelper().initProductModification();
        app.getProductHelper().fillProductForm(new ProductData
                ("Duck10", "test1", "test2", "test3"));
        app.getProductHelper().saveProduct();
    }
}
