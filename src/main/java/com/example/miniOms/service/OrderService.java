package com.example.miniOms.service;

import com.example.miniOms.dto.OrderRequestDto;
import com.example.miniOms.dto.OrderResponseDto;
import com.example.miniOms.entity.Order;
import com.example.miniOms.entity.Product;
import com.example.miniOms.mapper.OrderMapper;
import com.example.miniOms.repository.OrderRepository;
import com.example.miniOms.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    public List<OrderResponseDto> selectAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Order> orders = orderRepository.findAllWithProduct(pageable);
        return orderMapper.toDtoList(orders);
    }

    public OrderResponseDto select(Long id) {
        Order order = orderRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("해당 주문 없음"));;
        return orderMapper.toDto(order);
    }

    public OrderResponseDto create(OrderRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 없음"));
        Order order = orderMapper.toEntity(product, requestDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }
}
