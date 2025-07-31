package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;

    private String name;

    @Column(name = "distribution_center_id")
    private Long distributionCenterId;

    // Constructors
    public Product() {}

    public Product(Long id, String name, Long distributionCenterId) {
        this.id = id;
        this.name = name;
        this.distributionCenterId = distributionCenterId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDistributionCenterId() {
        return distributionCenterId;
    }

    public void setDistributionCenterId(Long distributionCenterId) {
        this.distributionCenterId = distributionCenterId;
    }
}
