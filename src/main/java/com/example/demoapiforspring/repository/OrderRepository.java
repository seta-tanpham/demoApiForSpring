package com.example.demoapiforspring.repository;

import com.example.demoapiforspring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
