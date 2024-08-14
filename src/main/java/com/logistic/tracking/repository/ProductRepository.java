package com.logistic.tracking.repository;

import com.logistic.tracking.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}