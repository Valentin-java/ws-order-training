package com.workers.ws_order.bussines.order.service;

import com.workers.ws_order.bussines.order.interfaces.OrderService;
import com.workers.ws_order.bussines.order.mapper.OrderMapper;
import com.workers.ws_order.persistance.entity.OrderEntity;
import com.workers.ws_order.persistance.entity.OrderPhotoEntity;
import com.workers.ws_order.persistance.enums.OrderStatus;
import com.workers.ws_order.persistance.repository.OrderPhotoRepository;
import com.workers.ws_order.persistance.repository.OrderRepository;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getorder.OrderSummaryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderPhotoRepository orderPhotoRepository;

    @Override
    public OrderCreateResponseDto createOrder(OrderCreateRequestDto requestDto) {

        log.info("Creating a new order for customer ID: {}", requestDto.customerId());

        // Шаг 1: Создание сущности заказа
        OrderEntity orderEntity = createOrderEntity(requestDto);

        // Шаг 2: Сохранение заказа в базе данных
        orderEntity = orderRepository.save(orderEntity);

        // Шаг 3: Сохранение фотографий заказа
        saveOrderWithPhotos(requestDto.photoData(), orderEntity);

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

    private void saveOrderWithPhotos(List<MultipartFile> photoDataList, OrderEntity orderEntity) {
        photoDataList.forEach(photoData -> {
            OrderPhotoEntity photoEntity = new OrderPhotoEntity();
            photoEntity.setOrderId(orderEntity.getId());
            photoEntity.setFileName(photoData.getName());
            photoEntity.setOriginalName(photoData.getOriginalFilename());
            photoEntity.setContentType(photoData.getContentType());
            try {
                photoEntity.setPhotoData(photoData.getBytes());
            } catch (IOException e) {
                throw new ResponseStatusException(BAD_REQUEST, "Error was occurred while read photo with order id: " + orderEntity.getId());
            }
            orderPhotoRepository.save(photoEntity);
        });
    }

    private OrderCreateResponseDto mapToResponseDto(OrderEntity orderEntity) {
        return orderMapper.toResponseDto(orderEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderSummaryDto> getNewOrdersByCustomerId(Long customerId) {
        log.info("Fetching new orders for customer ID: {}", customerId);
        return orderRepository.findByCustomerIdAndStatus(customerId, OrderStatus.NEW)
                .stream()
                .map(orderMapper::toSummaryDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public OrderCreateResponseDto getOrderDetailsById(Long orderId) {
        log.info("Fetching new details for order ID: {}", orderId);
        return orderRepository.findById(orderId)
                .map(orderMapper::toResponseDto)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Order not found with ID: " + orderId));

    }
}
