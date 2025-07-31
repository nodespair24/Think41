package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CSVDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public CSVDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("Laptop", "14 inch i5", 650.00));
        productRepository.save(new Product("Phone", "Android phone", 250.00));
        productRepository.save(new Product("Headphones", "Noise cancelling", 120.00));
    }
}

