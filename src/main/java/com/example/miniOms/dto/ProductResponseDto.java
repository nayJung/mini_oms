package com.example.miniOms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter // 컨트롤러에서 ProductResponseDto 객체를 리턴할 때 Jackson 사용해서 자바 객체를 JSON 형태로 직렬화함
// 객체의 필드 값을 읽기 위해 Getter 사용
public class ProductResponseDto {

    private Long id;
    private String name;
    private Long price;
    private Boolean useYn;
}
