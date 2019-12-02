package com.auction.repository;

import com.auction.model.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRepository extends JpaRepository<Pictures, Integer> {
}
