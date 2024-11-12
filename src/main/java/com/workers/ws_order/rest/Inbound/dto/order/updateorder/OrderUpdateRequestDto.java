package com.workers.ws_order.rest.Inbound.dto.order.updateorder;

import com.workers.ws_order.persistance.enums.OrderStatus;

import java.math.BigDecimal;

public record OrderUpdateRequestDto(
        String category,
        String shortDescription,
        String detailedDescription,
        BigDecimal amount,
        OrderStatus status
) {
}
