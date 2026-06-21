package com.example.miniOms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order { // 주문 하나 → 상품 하나

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // N쪽, 엔티티와 엔티티를 연결하는 어노테이션
    // 상품 조회가 필요 없는 API에서도 상품을 조회할 가능성이 있으므로 FetchType.LAZY로 설정해서 필요할 때만 조회하도록 설정
    @JoinColumn(name = "product_id")
    private Product product;

    @NonNull
    private Long quantity;

}
