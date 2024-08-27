package com.example.demoapiforspring.repository;

import com.example.demoapiforspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
