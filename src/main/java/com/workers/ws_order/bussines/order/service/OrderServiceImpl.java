package com.workers.ws_order.bussines.order.service;

import com.workers.ws_order.bussines.order.interfaces.OrderService;
import com.workers.ws_order.bussines.order.mapper.OrderMapper;
import com.workers.ws_order.persistance.entity.OrderEntity;
import com.workers.ws_order.persistance.enums.OrderStatus;
import com.workers.ws_order.persistance.repository.OrderRepository;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    public OrderCreateResponseDto createOrder(OrderCreateRequestDto requestDto) {

        log.info("Creating a new order for customer ID: {}", requestDto.customerId());

        // Шаг 1: Создание сущности заказа
        OrderEntity orderEntity = createOrderEntity(requestDto);

        // Шаг 2: Сохранение заказа в базе данных
        orderEntity = orderRepository.save(orderEntity);

        // Шаг 4: Формирование и возврат ответа
        OrderCreateResponseDto responseDto = mapToResponseDto(orderEntity);

        log.info("Order created successfully with ID: {}", responseDto.orderId());
        return responseDto;
    }

    private OrderEntity createOrderEntity(OrderCreateRequestDto requestDto) {
       OrderEntity orderEntity = orderMapper.toEntity(requestDto);
        orderEntity.setStatus(OrderStatus.NEW);
        return orderEntity;

    }

    private OrderCreateResponseDto mapToResponseDto(OrderEntity orderEntity){
       return orderMapper.toResponseDto(orderEntity);

    }
}
