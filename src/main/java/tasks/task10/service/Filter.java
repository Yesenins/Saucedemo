package tasks.task10.service;

import tasks.task10.Category;
import tasks.task10.Product;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public List<Product> filterProducts(List<Product> list, Category category, int maxPrice){
        List<Product> filterList = new ArrayList<>();
        for (Product element : list){
            if (element.category.equals(category) && element.price < maxPrice){
                filterList.add(element);
            }
        }
        return filterList;
    }
}
