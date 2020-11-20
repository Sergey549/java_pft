package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Test;

public class ProductModificationTest extends TestBase {

    @Test
    public void testProductModification (){
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        if (! app.getProductHelper().isThereAProduct()) {
            app.getProductHelper().createProduct(new ProductData
                    ("Duck11", null, null, null));
        }
        app.getProductHelper().initProductModification();
        app.getProductHelper().fillProductForm(new ProductData
                ("Duck8", "test1", "test2", null));
        app.getProductHelper().saveProduct();
    }
}
