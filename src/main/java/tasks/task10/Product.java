package tasks.task10;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    public int price;
    public Category category;

    public Product(int id, String name, int price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
