package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() {
        app.checkAdminMainPageIsTrue();
        app.goTo().Catalog();
        Set<ProductData> before = app.product().all();
        ProductData product = new ProductData
                ("Duck2", null, null, null);
        app.product().create(product);
        Set<ProductData> after = app.product().all();
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

        product.setId(after.stream().max(Comparator.comparingInt(ProductData::getId)).get().getId());
        before.add(product);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

//        before.add(group);
//        Comparator<? super ProductData> byId = Comparator.comparingInt(ProductData::getId);
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);

    }
}

