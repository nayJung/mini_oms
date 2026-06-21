package com.example.miniOms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderRequestDto {

    //private Long id;
    private Long productId;
    private Long quantity;

}
