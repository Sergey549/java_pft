package litecart.model;

import java.util.Objects;

public class ProductData {

    private int id;
    private final String duckName;
    private final String shortDescription;
    private final String description;
    private final String technicalData;

    public ProductData(String duckName, String shortDescription, String description, String technicalData) {
        this.id = 0;
        this.duckName = duckName;
        this.shortDescription = shortDescription;
        this.description = description;
        this.technicalData = technicalData;

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

    public void setId(int id) {
        this.id = id;
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
