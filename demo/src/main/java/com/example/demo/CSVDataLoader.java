package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CSVDataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            ClassPathResource resource = new ClassPathResource("products.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                // Skip header row
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    try {
                        Long id = Long.parseLong(fields[0].trim());
                        String name = fields[1].trim();
                        Long distributionCenterId = Long.parseLong(fields[2].trim());

                        Product product = new Product(id, name, distributionCenterId);
                        productRepository.save(product);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid row: " + line);
                    }
                } else {
                    System.err.println("Skipping incomplete row: " + line);
                }
            }

            reader.close();
            System.out.println("Products loaded from CSV.");
        }
    }
}
