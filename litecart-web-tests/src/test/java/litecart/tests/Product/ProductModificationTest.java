package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ProductModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.checkAdminMainPageIsTrue();
        app.goTo().Catalog();
        if (app.product().all().size() == 0) {
            app.product().create(new ProductData
                    ("Duck1", null, null, null, null));
        }
    }

    @Test
    public void testProductModification() {
        Set<ProductData> before = app.product().all();
        ProductData modifiedProduct = before.iterator().next();
        ProductData product = new ProductData(modifiedProduct.getId(),
                "Duck1", "test1", "test2", null) ;
        app.product().modify(product);
        Set<ProductData> after = app.product().all();
        Assert.assertEquals(after.size(), before.size());
// Сравниваем множества элементов списка, где игнорируется порядок элементов
        before.remove(modifiedProduct);
        before.add(product);
        Assert.assertEquals(before, after);

// Вариант 2 -> сравнение списков, где происходит сортировка (упорядочивание) элементов списка
// по Id (идентификаторам) и затем сравнение

//        Comparator<? super ProductData> byId = Comparator.comparingInt(ProductData::getId);
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);
    }

}
