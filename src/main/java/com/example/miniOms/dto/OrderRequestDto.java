package com.example.miniOms.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderRequestDto {

    @NotNull(message = "상품 ID를 입력해주세요.")
    private Long productId;

    @NotNull(message = "주문 수량을 입력해주세요.")
    @Positive(message = "주문 수량은 1개 이상이어야 합니다.")
    private Long quantity;

}
