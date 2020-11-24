package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ProductModificationTest extends TestBase {

    @Test
    public void testProductModification (){
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();

        if (! app.getProductHelper().isThereAProduct()) {
            app.getProductHelper().createProduct(new ProductData
                    ("Duck1", null, null, null));
        }
        List<ProductData> before = app.getProductHelper().getProductList();
        app.getProductHelper().selectProductToBeModificated(before.size() - 1);
        ProductData group = new ProductData
                (before.get(before.size() - 1).getId(), "Duck1", "test1", "test2", null) ;
        app.getProductHelper().fillProductForm(group);
        app.getProductHelper().saveProduct();
        List<ProductData> after = app.getProductHelper().getProductList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);

// Сравниваем множества элементов списка, где игнорируется порядок элементов

        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

// Вариант 2 -> сравнение списков, где происходит сортировка (упорядочивание) элементов списка
// по Id (идентификаторам) и затем сравнение

//        Comparator<? super ProductData> byId = Comparator.comparingInt(ProductData::getId);
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);
    }
}
