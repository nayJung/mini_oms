package com.example.miniOms.repository;

import com.example.miniOms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository<엔티티 타입, Pk 타입>
public interface ProductRepository extends JpaRepository<Product, Long> {

}
