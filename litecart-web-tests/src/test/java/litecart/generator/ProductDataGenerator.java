package litecart.generator;

import litecart.model.ProductData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ProductDataGenerator {

    public static void main(String[] args) throws IOException {
        int count  = Integer.parseInt(args[0]);
        File file  = new File(args[1]);

        List<ProductData> products = generateGroups(count);
        save(products, file);
    }

    private static void save(List<ProductData> products, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ProductData product : products) {
            writer.write(String.format("%s;%s;%s\n",
                    product.getDuckName(), product.getShortDescription(), product.getDescription()));
        }
        writer.close();
    }

    private static List<ProductData> generateGroups(int count) {
    List<ProductData> groups = new ArrayList<>();
    for (int i = 0; i<count; i++) {
        groups.add(new ProductData().withName(String.format("Duck%s", i))
                .withShortDescription(String.format("test%s", i))
                .withDescription(String.format("test%s", i)));
        }
    return groups;
    }
}
