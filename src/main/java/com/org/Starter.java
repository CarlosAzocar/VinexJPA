package com.org;

import com.org.models.Product;
import com.org.repositories.ProductRepository;

import java.util.List;

/**
 * Starter Class
 *
 */
public class Starter {
    public static void main(String[] args) {
<<<<<<< HEAD
        System.out.print("Create pp");
=======
        System.out.print("create app");
>>>>>>> 98efae1fcb4f96ad1239e726b3f213584d71e369
        
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
