package ru.mobydrake.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mobydrake.entites.Product;
import ru.mobydrake.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/showProduct")
    public String showProductByID(Model model, @ModelAttribute("product") Product product) {
        product = service.getProductByID(10);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/showAll")
    public String showAll(Model model, @ModelAttribute("products") ArrayList<Product> products) {
        products = service.getAllProduct();
        model.addAttribute("products", products);
        return "all-product";
    }

    @GetMapping("/addProduct")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/addProduct")
    public String showResultAdd(@ModelAttribute Product product, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()){
            service.addProduct(product);
        }
        return "product-form";
    }
}
