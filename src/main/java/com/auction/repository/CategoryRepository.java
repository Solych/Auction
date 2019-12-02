package com.auction.repository;

import com.auction.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
