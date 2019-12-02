package com.auction.repository;

import com.auction.model.CategorySubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorySubcategoryRepository extends JpaRepository<CategorySubcategory, Integer> {

    List<CategorySubcategory> getAllByCategory_CategoryId(Integer categoryId);
}
