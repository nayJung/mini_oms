package com.example.miniOms.mapper;

import com.example.miniOms.dto.OrderRequestDto;
import com.example.miniOms.dto.OrderResponseDto;
import com.example.miniOms.entity.Order;
import com.example.miniOms.entity.Product;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderMapper {

    public Order toEntity(Product product, OrderRequestDto dto) {
        return new Order(null, product, dto.getQuantity());
    }

    public OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getProduct().getName(),
                order.getQuantity()
        );
    }

    public List<OrderResponseDto> toDtoList(List<Order> orders) {
        return orders.stream()
                .map(this::toDto)
                .toList();
    }

}
