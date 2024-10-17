package com.workers.ws_order.rest.Inbound.dto.getorder;

import java.time.LocalDateTime;

public record OrderSummaryDto(
        Long orderId,
        String category,
        String shortDescription,
        String status,
        LocalDateTime createdAt
) {
}
