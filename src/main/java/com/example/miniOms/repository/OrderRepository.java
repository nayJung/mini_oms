package com.example.miniOms.repository;

import com.example.miniOms.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // JPQL은 엔티티의 필드명을 사용
    @Query("select o from Order o join fetch o.product order by o.id")
    List<Order> findAllWithProduct(Pageable pageable);

}
