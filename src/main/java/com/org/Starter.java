package com.org;

import com.org.models.Product;
import com.org.repositories.ProductRepository;

import java.util.List;

public class Starter {
    public static void main(String[] args) {
        System.out.print("Last");
        System.out.print("Create new application");
     
        try {
            ProductRepository productRepository = new ProductRepository();
            List<Product> productList = productRepository.getAll();
            productList.forEach(product -> System.out.println(product.getProductName()));
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
