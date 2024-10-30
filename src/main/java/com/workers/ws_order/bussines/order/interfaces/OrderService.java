package com.workers.ws_order.bussines.order.interfaces;

import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getorder.OrderSummaryDto;
import com.workers.ws_order.rest.Inbound.dto.updateorder.OrderUpdateRequestDto;

import java.util.List;

public interface OrderService {

    OrderCreateResponseDto createOrder(OrderCreateRequestDto requestDto);

    List<OrderSummaryDto> getNewOrdersByCustomerId(Long customerId);

    OrderCreateResponseDto getOrderDetailsById(Long orderId);

    List<OrderSummaryDto>getCompletedAndCancelledOrdersByCustomerId(Long customerId);

    OrderCreateResponseDto updateOrder(Long orderId, OrderUpdateRequestDto requestDto);

    void completeOrder(Long orderId,Long specialistId);




}
