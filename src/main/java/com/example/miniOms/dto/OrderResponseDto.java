package com.example.miniOms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderResponseDto {

    private Long id;
    private String productName; // Product 구조를 노출X
    private Long quantity;

}
