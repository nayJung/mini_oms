package com.example.miniOms.service;

import com.example.miniOms.dto.ProductRequestDto;
import com.example.miniOms.dto.ProductResponseDto;
import com.example.miniOms.entity.Product;
import com.example.miniOms.mapper.ProductMapper;
import com.example.miniOms.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    public List<ProductResponseDto> selectAll() {
        List<Product> products = repository.findAll();
        return productMapper.toDtoList(products);
    }

    public ProductResponseDto select(Long id) {
        Product selectProduct = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 없음"));
        // orElseThrow() : 값이 존재하면 꺼내고 없으면 에러 반환
        return productMapper.toDto(selectProduct);
    }

    @Transactional
    public ProductResponseDto create(ProductRequestDto requestDto) {
        Product product = productMapper.toEntity(requestDto);
        Product savedProduct = repository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Transactional
    public ProductResponseDto update(Long id, ProductRequestDto requestDto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 없음"));
        product.update(requestDto.getName(), requestDto.getPrice());
        return productMapper.toDto(product);
    }

    @Transactional
    public ProductResponseDto softDelete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 없음"));
        product.softDelete();
        return productMapper.toDto(product);
    }
}
