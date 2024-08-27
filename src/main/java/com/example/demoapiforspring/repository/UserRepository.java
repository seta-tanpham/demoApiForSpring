package com.example.demoapiforspring.repository;

import com.example.demoapiforspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
