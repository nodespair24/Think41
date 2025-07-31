package com.example.demo;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@Component
public class CSVDataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        String filePath = "src/main/resources/products.csv";

        try (Reader reader = new FileReader(filePath)) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> rows = csvReader.readAll();

            for (int i = 1; i < rows.size(); i++) {
                String[] data = rows.get(i);

                Product product = new Product(
                        Long.parseLong(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]),
                        data[4],
                        data[5],
                        Double.parseDouble(data[6]),
                        Integer.parseInt(data[7])
                );

                productRepository.save(product);
            }
        }
    }
}
