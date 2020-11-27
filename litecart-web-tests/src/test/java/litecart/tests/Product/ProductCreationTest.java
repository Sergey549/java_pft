package litecart.tests.Product;

import litecart.model.ProductData;
import litecart.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ProductCreationTest extends TestBase {

    @Test
    public void testProductCreation() {
        app.checkAdminMainPageIsTrue();
        app.goTo().Catalog();
        Set<ProductData> before = app.product().all();
        File photo = new File("src/test/resources/file.jpeg");
        ProductData product = new ProductData().withName("Duck2")
                .withShortDescription(null).withDescription(null).withTechnicalData(null).withPhoto(photo);
        app.product().create(product);
        Set<ProductData> after = app.product().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        product.withId(after.stream().max(Comparator.comparingInt(ProductData::getId)).get().getId());
        before.add(product);
        Assert.assertEquals(before, after);

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

//        before.add(group);
//        Comparator<? super ProductData> byId = Comparator.comparingInt(ProductData::getId);
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);

    }
}

