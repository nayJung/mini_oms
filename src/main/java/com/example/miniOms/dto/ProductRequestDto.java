package com.example.miniOms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRequestDto {

    @NotBlank(message = "상품명을 입력해주세요.")
    private String name;

    @NotNull(message = "상품 가격을 입력해주세요.")
    private Long price;

    @NotNull(message = "상품 재고를 입력해주세요.")
    private Long stock;

}
