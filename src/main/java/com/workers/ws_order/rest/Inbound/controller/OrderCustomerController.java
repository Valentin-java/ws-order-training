package com.workers.ws_order.rest.Inbound.controller;

import com.workers.ws_order.bussines.order.customer.interfaces.OrderCustomerService;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getorder.OrderSummaryDto;
import com.workers.ws_order.rest.Inbound.dto.updateorder.OrderChangeStatusByCustomer;
import com.workers.ws_order.rest.Inbound.dto.updateorder.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderCustomerController {

    private final OrderCustomerService service;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateRequestDto requestDto) {
        return ResponseEntity.ok(service.createOrder(requestDto));
    }

    @GetMapping("/active")
    public ResponseEntity<List<OrderSummaryDto>> getNewOrdersByCustomerId(@RequestParam Long customerId) {
        return ResponseEntity.ok(service.getNewOrdersByCustomerId(customerId));
    }

    @GetMapping("/archive")
    public ResponseEntity<List<OrderSummaryDto>> getCompletedAndCancelledOrdersByCustomerId(@RequestParam Long customerId) {
        return ResponseEntity.ok(service.getCompletedAndCancelledOrdersByCustomerId(customerId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderCreateResponseDto> getOrderDetailsById(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.getOrderDetailsById(orderId));
    }

    @PostMapping("/update/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable Long orderId, @RequestBody OrderUpdateRequestDto requestDto) {
        return ResponseEntity.ok(service.updateOrder(orderId, requestDto));
    }

    @PostMapping("/cancel")
    public ResponseEntity<Void> cancelOrder(@RequestBody OrderChangeStatusByCustomer request) {
        service.cancelOrder(request);
        return ResponseEntity.ok().build();
    }
}
