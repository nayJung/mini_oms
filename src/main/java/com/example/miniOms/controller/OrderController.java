package com.example.miniOms.controller;

import com.example.miniOms.dto.OrderRequestDto;
import com.example.miniOms.dto.OrderResponseDto;
import com.example.miniOms.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService service;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> selectAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        List<OrderResponseDto> dtoList = service.selectAll(page, size);
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDto> select(@PathVariable Long id) {
        OrderResponseDto dto = service.select(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDto> create(@Valid @RequestBody OrderRequestDto requestDto) {
        OrderResponseDto dto = service.create(requestDto);
        return ResponseEntity.ok(dto);
    }

}
