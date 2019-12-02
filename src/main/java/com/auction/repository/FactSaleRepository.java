package com.auction.repository;

import com.auction.model.FactSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactSaleRepository extends JpaRepository<FactSale, Integer> {
}
