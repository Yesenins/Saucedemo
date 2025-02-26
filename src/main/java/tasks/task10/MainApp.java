package tasks.task10;

import tasks.task10.service.Filter;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Filter filter = new Filter();
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Samsung", 50, Category.PHONE));
        list.add(new Product(2, "Lenovo", 100, Category.PC));
        list.add(new Product(3, "MSI", 150, Category.LAPTOP));
        list.add(new Product(4, "Samsung", 200, Category.LAPTOP));
        list.add(new Product(5, "Alien", 180, Category.LAPTOP));

        List<Product> filterList = filter.filterProducts(list,Category.LAPTOP,190);
        System.out.println(filterList);
    }
}
