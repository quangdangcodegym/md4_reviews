package com.codegym.review.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
// implements Serializable de dong bo du lieu khi gui qua internet
// Bat buoc co contructor khong tham so
// Tao getter setter

@Entity
@Table (name="category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;


    public Category(){}

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
