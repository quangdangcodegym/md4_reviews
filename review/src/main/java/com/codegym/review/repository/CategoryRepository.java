package com.codegym.review.repository;

import com.codegym.review.model.Category;
import com.codegym.review.model.dto.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByDescriptionLike(String desc);

    @Query("SELECT NEW com.codegym.review.model.dto.CategoryDTO (" +
            "c.name, " +
            "c.description " +
            " )  " +
            "FROM Category c  WHERE c.description like ?1 ")
    List<CategoryDTO> findAllCategoryDTOByDesciption(String desc);
}
