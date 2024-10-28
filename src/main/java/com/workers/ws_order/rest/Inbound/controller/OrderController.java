package com.workers.ws_order.rest.Inbound.controller;

import com.workers.ws_order.bussines.order.interfaces.OrderService;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getorder.OrderSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//HH
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderCreateResponseDto> createOrder(@RequestBody OrderCreateRequestDto request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("/active")
    public ResponseEntity<List<OrderSummaryDto>> getNewOrdersByCustomerId(@RequestParam Long customerId) {
        return ResponseEntity.ok(orderService.getNewOrdersByCustomerId(customerId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderCreateResponseDto> getOrderDetailsById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderDetailsById(orderId));
    }
}
