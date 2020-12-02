package litecart.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import litecart.model.ProductData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ProductDataGenerator {

    @Parameter(names = "-c", description = "Product count")
    public static int count;

    @Parameter(names = "-f", description = "File")
    public static String file;

    @Parameter(names = "-d", description = "Data format")
    public static String format;

    public static void main(String[] args) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        ProductDataGenerator generator = new ProductDataGenerator();
        new JCommander(generator, args);
        generator.run();
    }

    private void run() throws IOException {
        List<ProductData> products = generateGroups(count);
        if (format.equals("csv")) {
            saveAsCsv(products, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(products, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(products, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<ProductData> products, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(products);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsCsv(List<ProductData> products, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ProductData product : products) {
                writer.write(String.format("%s;%s;%s;%s\n",
                        product.getDuckName(), product.getShortDescription(),
                        product.getDescription(), product.getTechnicalData()));
            }
        }
    }

    private void saveAsXml(List<ProductData> products, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ProductData.class);
        String xml = xStream.toXML(products);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private static List<ProductData> generateGroups(int count) {
        List<ProductData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new ProductData().withName(String.format("Duck%s", i))
                    .withShortDescription(String.format("test%s", i))
                    .withDescription(String.format("test%s", i))
                    .withTechnicalData(String.format("test%s", i)));
        }
        return groups;
    }
}
