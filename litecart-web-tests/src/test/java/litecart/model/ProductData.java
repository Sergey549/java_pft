package litecart.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("product")
public class ProductData {
    @XStreamOmitField
    private int id;
    @Expose
    private String duckName;
    @Expose
    private String shortDescription;
    @Expose
    private String description;
    @Expose
    private String technicalData;
    private File photo;

    public ProductData(String duckName, String shortDescription, String description, String technicalData, File photo) {
        this.id = 0;
        this.duckName = duckName;
        this.shortDescription = shortDescription;
        this.description = description;
        this.technicalData = technicalData;
        this.photo = photo;

        // this.id = Integer.MAX_VALUE;
        // -> если хотим использовать сортировку элементов списка
        // по идентификатору при создании товара,
        // это гарантирует, что созданная группа при сортировки окажется последней
        // Не забыть перегенерировать equals() и hashCode(), чтобы осталось только имя элементов,
        // т.к. после сортировки элементов идентифифкаторы не важны
        //Но этот способ не подходит, если иденфиуаторами нельзя пренебречь
        // (если в результате добавления товара испортятся идентификаторы у какого-то уже существующего товара,
        // тст этого не поймает, он увидит, что в списке присутствуют все товары с теми же самыми именами
        // и не заметит, что идентификаторы испортились

    }

    public ProductData(int id, String duckName, String shortDescription, String description, String technicalData) {
        this.id = id;
        this.duckName = duckName;
        this.shortDescription = shortDescription;
        this.description = description;
        this.technicalData = technicalData;
    }

    public ProductData() {
    }

    public int getId() {
        return id;
    }

    public String getDuckName() {
        return duckName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnicalData() {
        return technicalData;
    }

    public File getPhoto(File photo) {
        return photo;
    }


    public ProductData withId(int id) {
        this.id = id;
        return this;
    }

    public ProductData withName(String duckName) {
        this.duckName = duckName;
        return this;
    }

    public ProductData withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public ProductData withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductData withTechnicalData(String technicalData) {
        this.technicalData = technicalData;
        return this;
    }

    public ProductData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return id == that.id &&
                Objects.equals(duckName, that.duckName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duckName);
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "id=" + id +
                ", duckName='" + duckName + '\'' +
                '}';
    }
}
