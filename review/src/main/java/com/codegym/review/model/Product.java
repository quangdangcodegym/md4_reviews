package com.codegym.review.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String image;

    @Column(name="create_date")
    private Date createDate;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;


    @ManyToMany
    @JoinTable(
            name = "pro_man",
            joinColumns = {@JoinColumn(name = "pm_productid")},
            inverseJoinColumns = {@JoinColumn(name = "pm_manufacturerid")}
    )
    private Set<Manufacturer> manufacturers;




    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String name, BigDecimal price, String image, Date createDate, boolean active, Category category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.createDate = createDate;
        this.active = active;
        this.category = category;
    }
}
