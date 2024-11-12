package com.workers.ws_order.rest.Inbound.dto.order.createorder;

import java.math.BigDecimal;

public record OrderCreateRequestDto(
        Long customerId,
        String category,
        String shortDescription,
        String detailedDescription,
        BigDecimal amount

) {
}
