package litecart.generator;

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

public class ProductDataGenerator {

    @Parameter(names = "-d", description = "Data format")
    public static String format;

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ProductData> products = generateGroups(count);
        saveAsJson(products, file);
//        if (format.equals("csv")) {
//
//        } else if (format.equals("xml")) {
//            saveAsXml(products, file);
//        } else if (format.equals("json")) {
//            saveAsJson(products, file);
//        } else {
//            System.out.println("Unrecognized format " + format);
//        }
    }

    private static void saveAsJson(List<ProductData> products, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(products);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static void saveAsCsv(List<ProductData> products, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ProductData product : products) {
            writer.write(String.format("%s;%s;%s;%s\n",
                    product.getDuckName(), product.getShortDescription(),
                    product.getDescription(), product.getTechnicalData()));
        }
        writer.close();
    }


    private static void saveAsXml(List<ProductData> products, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ProductData.class);
        String xml = xStream.toXML(products);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
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
