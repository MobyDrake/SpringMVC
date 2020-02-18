package ru.mobydrake.repository;

import org.springframework.stereotype.Component;
import ru.mobydrake.entites.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private ArrayList<Product> products = new ArrayList<>();

    public Product findOneByID(int id) {
        Product product = new Product();
        product.setTitle("Pen");
        product.setCost(1.99);
        product.setId(id);
        return product;
    }

    public ArrayList<Product> findAllProducts() {
        if (products.isEmpty()) fillList();
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    private void fillList() {
        for(int i = 1; i <= 5; i++) {
            products.add(new Product(i, "Pen - Color:" + i, 1.025 * i));
        }
    }
}
