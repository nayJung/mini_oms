package com.example.miniOms.mapper;

import com.example.miniOms.dto.ProductRequestDto;
import com.example.miniOms.dto.ProductResponseDto;
import com.example.miniOms.entity.Product;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDto dto) {
        return new Product(null, dto.getName(), dto.getPrice(), true);
    }

    public ProductResponseDto toDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getUseYn()
        );
    }

    public List<ProductResponseDto> toDtoList(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .toList();
    }

}
