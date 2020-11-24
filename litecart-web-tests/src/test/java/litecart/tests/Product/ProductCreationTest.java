package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() throws Exception {
        app.checkAdminMainPageIsTrue();
        app.getNavigationHelper().goToCatalog();
        List<ProductData> before = app.getProductHelper().getProductList();
        ProductData group = new ProductData
                ("Duck2", null, null, null);
        app.getProductHelper().createProduct(group);
        List<ProductData> after = app.getProductHelper().getProductList();
        Assert.assertEquals(after.size(), before.size() + 1);

//        int max =0;
//        for (ProductData g: after) {
//            if (g.getId() > max) {
//                max = g.getId();
//            }
//        }
//        group.setId(max);

// Преобразовал цикл, вводим анонимную функцию (лямбда выражение) ->
// Новый список превращаем в поток.
// У потока есть метод max, в который позволяет вычислять макс. элемент.
// Передаем компаратор (сравниватель) в качестве параметра. Получаем макс. элемент и его Id

        group.setId(after.stream().max(Comparator.comparingInt(ProductData::getId)).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

//        before.add(group);
//        Comparator<? super ProductData> byId = Comparator.comparingInt(ProductData::getId);
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);

    }
}

