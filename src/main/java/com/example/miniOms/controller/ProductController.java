package com.example.miniOms.controller;

import com.example.miniOms.dto.ProductRequestDto;
import com.example.miniOms.dto.ProductResponseDto;
import com.example.miniOms.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController // HTTP 요청을 받아 JSON, 문자열 등의 데이터를 응답하는 컨트롤러
@RequiredArgsConstructor
@RequestMapping("/api") // 공통 경로
public class ProductController {

    private final ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> selectAll() {
        List<ProductResponseDto> dtoList = service.selectAll();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> select(@PathVariable Long id) {
        ProductResponseDto dto = service.select(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto requestDto) {
        ProductResponseDto dto = service.create(requestDto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) {
        ProductResponseDto dto = service.update(id, requestDto);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> softDelete(@PathVariable Long id) {
        ProductResponseDto dto = service.softDelete(id);
        return ResponseEntity.ok(dto);
    }
}
