package ru.mobydrake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mobydrake.entites.Product;
import ru.mobydrake.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public Product getProductByID(int id) {
        return repository.findOneByID(id);
    }

    public ArrayList<Product> getAllProduct() {
        return repository.findAllProducts();
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }
}
