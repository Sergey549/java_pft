package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductModificationTest extends TestBase {

    @Test
    public void testProductModification (){
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();

        if (! app.getProductHelper().isThereAProduct()) {
            app.getProductHelper().createProduct(new ProductData
                    ("Duck11", null, null, null));
        }
        List<ProductData> before = app.getProductHelper().getProductList();
        app.getProductHelper().selectProductToBeModificated(before.size() - 1);
        app.getProductHelper().fillProductForm(new ProductData
                ("Duck8", "test1", "test2", null));
        app.getProductHelper().saveProduct();
        List<ProductData> after = app.getProductHelper().getProductList();
        Assert.assertEquals(after.size(), before.size());
    }
}
