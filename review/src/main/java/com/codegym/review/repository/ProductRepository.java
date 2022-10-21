package com.codegym.review.repository;

import com.codegym.review.model.Product;
import com.codegym.review.model.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT NEW com.codegym.review.model.dto.ProductDTO (" +
            "p.id, " +
            "p.name, " +
            "p.price, " +
            "p.image, " +
            "p.category" +
            " )  " +
            "FROM Category c join Product p on c.id = p.category.id WHERE c.description like ?1 ")
    List<ProductDTO> findAllProductByDesctiptionCategoryWithJoin(String desc);
}
