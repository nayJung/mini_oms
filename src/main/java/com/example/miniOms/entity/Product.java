package com.example.miniOms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "products")
@NoArgsConstructor // 컨트롤러 요청 받을 때 리플랙션 때문에 필요
@AllArgsConstructor
@Getter
public class Product { // 상품 하나 → 주문 여러 개 [FK는 항상 N쪽에 있음]

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 널일 수도 있어서 long 보다 Long 선호

    @NonNull
    private String name;

    @NonNull
    private Long price;

    @NonNull
    @Column(name = "use_yn")
    private Boolean useYn;

    public void update(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public void softDelete() {
        this.useYn = false;
    }
}
